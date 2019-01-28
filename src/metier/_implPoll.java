package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAO.db_interaction;
import entities._choice;
import entities._poll;
import entities._user;

public class _implPoll implements _interfacePoll {
	private static Connection conn ;

	public void _create_poll(_poll p) {
		Connection connection=db_interaction._get_connection();
		try{
			PreparedStatement ps = connection.prepareStatement
					("insert into poll (Description, Category, UserId, pollDate,expires)  " +
							"values (?,?,?,?,?)");

			//ps.setInt(1,p.getPollId());
			ps.setString(1,p.get_description());
			ps.setString(2,p.get_category());
			ps.setInt(3,p.get_userId());
			ps.setTimestamp(4,p.get_date());
			ps.setDate(5,p.get_expires());
			ps.executeUpdate();

			System.out.println("poll created");
		}catch(SQLException e){
		e.printStackTrace();
		}
	}

	@Override
	public ArrayList<_poll> _search_vote_by_userid(int id) {
		Connection con =db_interaction._get_connection();
		ArrayList<_poll> listevote= new ArrayList<_poll>();
		try {
			PreparedStatement statement = con.prepareStatement("SELECT *  FROM POLL WHERE userid=? ");
			statement.setInt(1,id);
			ResultSet result = statement.executeQuery();

			while (result.next()) {


				_poll p  = new _poll(result.getInt("pollid"),
						result.getString("description"),
						result.getDate("expires"),
						result.getString("category"),
						result.getInt("userid"));
				listevote.add(p);

			}

			System.out.println("poll selected");

		}catch(SQLException e){
			e.printStackTrace();
		}


		return listevote;



	}
	@Override
	public void delete_poll(int id) {

		Connection con =db_interaction._get_connection();

		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM POLL WHERE pollid=?");
			statement.setInt(1, id);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A poll was deleted successfully!");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<_poll> _search_vote_by_Type(String type) {
		return null;
	}

	public _poll _get_poll_by_id(int poll_id){
		_poll my_poll  = new _poll();
		Connection con =db_interaction._get_connection();
		try {
			PreparedStatement statement =
					con.prepareStatement("SELECT description,category,userId,pollDate,expires" +
							" FROM poll WHERE  pollid =? ");
			statement.setInt(1,poll_id);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				my_poll.set_description(result.getString("description"));
				my_poll.set_date(result.getTimestamp("pollDate"));
				my_poll.set_category(result.getString("category"));
				my_poll.set_userId(result.getInt("userId"));
				my_poll.set_expires(result.getDate("expires"));

			}
			System.out.println("poll selected");
		}catch(SQLException e){
			e.printStackTrace();
		}
		my_poll.set_pollId(poll_id);
		return my_poll;

	}

	@Override
	public  ArrayList<_poll>  _search_poll_by_category(String typ){
		Connection con =db_interaction._get_connection();
		ArrayList<_poll> listevote= new ArrayList<_poll>();
		try {
		PreparedStatement statement =
				con.prepareStatement("SELECT pollid, description," +
				" userid, type FROM POLL WHERE  category =? ");
		statement.setString(1,typ);
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
			_poll p  = null;
			p.set_pollId(result.getInt("pollId"));
			p.set_description(result.getString("description"));
			p.set_date(result.getTimestamp("pollDate"));
			p.set_category(result.getString("category"));
			p.set_userId(result.getInt("userId"));
			p.set_expires(result.getDate("expires"));
			listevote.add(p);
			
		}
		System.out.println("poll selected");
		}catch(SQLException e){
			e.printStackTrace();
			}
		return listevote;
	}

	public int _last_poll_for_user(int i){
		Connection con =db_interaction._get_connection();
		int poll_id = -1;

		try {
		PreparedStatement statement =
				con.prepareStatement("SELECT MAX(pollid) FROM POLL WHERE userid=?");
		statement.setInt(1,i);
		ResultSet result = statement.executeQuery();
			System.out.println(""+result);
		if  (result.next()) {
			poll_id=result.getInt("MAX(pollid)");
		}
		System.out.println("last poll selected");

		}catch(SQLException e){
			e.printStackTrace();
			}

		return poll_id;


	}

	@Override
	public void _delete_poll(_poll p) {
		conn = db_interaction._get_connection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("DELETE FROM POLL WHERE POLLID = ?");
			ps.setLong(1, p.get_id_poll());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<_poll> _get_recent_polls(int _number_of_polls) {
		conn = db_interaction._get_connection();
		List<_poll> _poll_list= new ArrayList<_poll>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM POLL ORDER BY POLLID DESC");
			ResultSet res = ps.executeQuery();
			int i = 0;
			while((res.next()) && (i<_number_of_polls) ) {
				_poll poll = new _poll();
				poll.set_id_poll(res.getInt("POLLID"));
				poll.set_description(res.getString("DESCRIPTION"));
				poll.set_category(res.getString("CATEGORY"));
				poll.set_user_id(res.getInt("USERID"));
				poll.set_date(res.getTimestamp("POLLDATE"));
				poll.set_expires(res.getDate("expires"));
				_poll_list.add(poll);
				i++;
				System.out.println(poll);
			}
		}catch(SQLException e) {
			e.printStackTrace();}
		return (ArrayList<_poll>) _poll_list;
	}

	@Override
	public ArrayList<_choice> _get_choice_for_poll(_poll _p) {
		conn = db_interaction._get_connection();
		List<_choice> _choice_list= new ArrayList<_choice>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CHOICE WHERE POLLID = ?");
			ps.setInt(1, _p.get_id_poll());
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				_choice choice = new _choice();
				choice.set_choiceId(res.getInt("CHOICEID"));
				choice.set_description(res.getString("DESCRIPTION"));
				choice.set_number_of_voters(res.getInt("VOTERSNUMBER"));
				choice.set_pollId(res.getInt("POLLID"));

				System.out.println(choice);
				_choice_list.add(choice);
			}}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<_choice>) _choice_list;
	}

	@Override
	public int _get_number_of_voters(_poll _p) {
		int _number_of_voters = 0;
		try{
			conn = db_interaction._get_connection();
			PreparedStatement ps = conn.prepareStatement("SELECT SUM(VOTERSNUMBER) AS NUMBER FROM CHOICE WHERE POLLID = ? ");
			ps.setInt(1, _p.get_id_poll());
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				_number_of_voters = res.getInt("NUMBER");
				System.out.println(_number_of_voters);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _number_of_voters;
	}

	@Override
	public _user _get_user_of_poll(_poll _p) {
		_user user= new _user();
		try{
			conn = db_interaction._get_connection();
			PreparedStatement ps = conn.prepareStatement("SELECT USERID FROM POLL WHERE POLLID =? ");
			ps.setInt(1, _p.get_id_poll());
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				_user_dao_impl metier = new _user_dao_impl();
				user = metier._get_user_by_id(res.getInt("USERID"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int _get_number_of_polls() {
		int _number_of_polls = 0;
		try{
			conn = db_interaction._get_connection();
			PreparedStatement ps = conn.prepareStatement("SELECT Count(*) AS NUMBER FROM POLL ");
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				_number_of_polls = res.getInt("NUMBER");
				System.out.println(_number_of_polls);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _number_of_polls;
	}


	@Override
	public _poll _get_poll_by_id(long _id) {
		_poll poll = new _poll();
		try{
			conn = db_interaction._get_connection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM POLL WHERE POLLID = ?");
			ps.setLong(1, _id);
			ResultSet res = ps.executeQuery();
			if(res.next()){
				poll.set_id_poll(res.getInt("POLLID"));
				poll.set_description(res.getString("DESCRIPTION"));
				poll.set_category(res.getString("CATEGORY"));
				poll.set_user_id(res.getInt("USERID"));
				poll.set_date(res.getTimestamp("POLLDATE"));
				poll.set_expires(res.getDate("expires"));

				System.out.println(poll);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return poll;
	}

	@Override
	public ArrayList<_poll> _get_all_polls() {
		conn = db_interaction._get_connection();
		List<_poll> _poll_list= new ArrayList<_poll>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM POLL");
			ResultSet res = ps.executeQuery();
			while((res.next()) ) {
				_poll poll = new _poll();
				poll.set_id_poll(res.getInt("POLLID"));
				poll.set_description(res.getString("DESCRIPTION"));
				poll.set_category(res.getString("CATEGORY"));
				poll.set_user_id(res.getInt("USERID"));
				poll.set_date(res.getTimestamp("POLLDATE"));
				_poll_list.add(poll);
				System.out.println(poll);
			}
		}catch(SQLException e) {
			e.printStackTrace();}
		return (ArrayList<_poll>) _poll_list;
	}
	
	
			
			
			
	
}

