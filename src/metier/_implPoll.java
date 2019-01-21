package metier;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DAO.db_interaction;
import entities._choice;
import entities._poll;
import entities._user;

public class _implPoll implements _interfacePoll {
	private static Connection conn ;
	public void _create_poll(_poll p) {
		// TODO Auto-generated method stub
		Connection connection=db_interaction._get_connection();
		try{
		PreparedStatement ps = connection.prepareStatement
				("insert into poll( DESCRIPTION, DURATION, CATEGORY, USERID, TYPE) values (?,?,?,?,?)");
		//ps.setInt(1,p.getPollId());
		ps.setString(1,p.get_description());
		ps.setInt(2,p.get_duration());
		ps.setString(3,p.get_category());
		ps.setInt(4,p.get_user_id());
		ps.setString(5,p.get_type());

		ps.executeUpdate();
		}catch(SQLException e){
		e.printStackTrace();
		}
	}

	/*@Override
	public  ArrayList<_poll>  _search_vote_by_Type(String typ){
		Connection con =db_interaction._get_connection();
		ArrayList<_poll> listevote= new ArrayList<_poll>();
		try {
		PreparedStatement statement = con.prepareStatement("SELECT pollid, description, duration, category, userid, type FROM POLL WHERE type=? ");
		statement.setString(1,typ);
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
			
			
			_poll p  = new _poll(result.getInt("pollid"), result.getString("description"), result.getInt("duration"), result.getString("category"), result.getInt("userid"),result.getString("type"));
			listevote.add(p);
			
		}
		
		System.out.println("poll selected");
		
		}catch(SQLException e){
			e.printStackTrace();
			}
		
		
		return listevote;
		
	
	}*/
	
	
	
	
	
	
	
	
			
			/*public  _poll  _last_poll_for_user(int i){
		Connection con =db_interaction._get_connection();
		_poll p = null;
		
		try {
		PreparedStatement statement = con.prepareStatement("SELECT pollid, description, duration, category, userid, type FROM POLL WHERE   pollid = (SELECT MAX(pollid) FROM POLL WHERE userid=?) ");
		statement.setInt(1,i);
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
			
			
			 p  = new _poll(result.getInt("pollid"), result.getString("description"), result.getInt("duration"), result.getString("category"), result.getInt("userid"),result.getString("type"));
			
			
		}
		
		System.out.println("last poll selected");
		
		}catch(SQLException e){
			e.printStackTrace();
			}
		
		
		return p;
		
	
	}*/

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
					poll.set_duration(res.getInt("DURATION"));
					poll.set_category(res.getString("CATEGORY"));
					poll.set_user_id(res.getInt("USERID"));
					LocalDate _date_poll = LocalDate.parse(res.getString("POLLDATE"),DateTimeFormatter.ISO_LOCAL_DATE);    
					poll.set_pollDate(_date_poll);
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
						poll.set_duration(res.getInt("DURATION"));
						poll.set_category(res.getString("CATEGORY"));
						poll.set_user_id(res.getInt("USERID"));
						LocalDate _date_poll = LocalDate.parse(res.getString("POLLDATE"),DateTimeFormatter.ISO_LOCAL_DATE);    
						poll.set_pollDate(_date_poll);
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
			public ArrayList<_poll> _search_vote_by_Type(String type) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public _poll _last_poll_for_user(int i) {
				// TODO Auto-generated method stub
				return null;
			}
	
	
			
			
			
	
}

