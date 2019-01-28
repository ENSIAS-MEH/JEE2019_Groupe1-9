package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.db_interaction;
import entities._choice;
import entities._poll;
import entities._user;

public class _implChoice implements _interfaceChoice {


	private static Connection conn ;


	public void _add_choice(_choice c) {
		Connection connection=db_interaction._get_connection();
		try{
		PreparedStatement ps = connection.prepareStatement
				("insert into choice( DESCRIPTION, VOTERSNUMBER, POLLID) values (?,?,?)");
		//ps.setInt(1,c.getChoiceId());
		ps.setString(1,c.get_description());
		ps.setInt(2,c.get_number_of_voters());
		ps.setInt(3,c.get_pollId());


		ps.executeUpdate();
		}catch(SQLException e){
		e.printStackTrace();
		}
		
	}
	@Override
	public _choice _get_choice_bydescription_andpollid(int pollid, String description) {
		Connection con =db_interaction._get_connection();
		_choice c=new _choice();
		try {
			PreparedStatement statement = con.prepareStatement("SELECT choiceid, description, votersnumber, pollid" +
					" FROM CHOICE WHERE pollid=? AND description=? ");
			statement.setInt(1,pollid);
			statement.setString(2,description);
			ResultSet result = statement.executeQuery();

			while (result.next()) {



				c= new _choice(result.getInt("choiceid"), result.getString("description"),
						result.getInt("votersnumber"),
						result.getInt("pollid"));

			}

			System.out.println("choices selected");

		}catch(SQLException e){
			e.printStackTrace();
		}


		return c;
	}


	@Override
	public ArrayList<_choice> _search_choice_for_poll(int id){
		Connection con =db_interaction._get_connection();
		ArrayList<_choice> listechoice= new ArrayList<_choice>();
		try {
			PreparedStatement statement = con.prepareStatement("SELECT choiceid, description, votersnumber, pollid FROM CHOICE WHERE pollid=? ");
			statement.setInt(1,id);
			ResultSet result = statement.executeQuery();

			while (result.next()) {



				_choice c= new _choice(result.getInt("choiceid"), result.getString("description"), result.getInt("votersnumber"),result.getInt("pollid"));
				listechoice.add(c);

			}

			System.out.println("choices selected");

		}catch(SQLException e){
			e.printStackTrace();
		}


		return listechoice;


	}
	public ArrayList<_choice> get_choices_by_poll_id(int poll_id){
		Connection con =db_interaction._get_connection();
		ArrayList<_choice> list_choices= new ArrayList<_choice>();
		try {
			PreparedStatement statement =
					con.prepareStatement("SELECT ChoiceId, description," +
							" VotersNumber FROM choice WHERE  PollId =? ");
			statement.setInt(1,poll_id);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				_choice new_choice =new _choice();
//				p.set_pollId(result.getInt("pollId"));
				new_choice.set_choiceId(result.getInt("ChoiceId"));
				new_choice.set_description(result.getString("description"));
				new_choice.set_number_of_voters(result.getInt("VotersNumber"));
				new_choice.set_pollId(poll_id);
				list_choices.add(new_choice);
			}
			System.out.println("poll selected");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list_choices;
	}

	@Override
	public  void _vote( int choice_id) {
	    Connection con =db_interaction._get_connection();
	 try {
		 PreparedStatement statement =
				 con.prepareStatement("SELECT  VotersNumber FROM choice WHERE  CHOICEID =? ");
		 statement.setInt(1,choice_id);
		 ResultSet result = statement.executeQuery();
		 int number_of_voters = -2;
		 if (result.next()) {
		 	number_of_voters=result.getInt("VotersNumber")+1;

		 }
		 if(number_of_voters>=0){
			 PreparedStatement posted = con.prepareStatement("UPDATE CHOICE SET  VOTERSNUMBER=?  " +
					 "WHERE CHOICEID=?");
			 posted.setInt(1,number_of_voters);
			 posted.setInt(2,choice_id);
			 int rowsUpdated = posted.executeUpdate();
			 if (rowsUpdated > 0) {
				 System.out.println("thanks for voting!");
			 }

		 }


	}catch(SQLException e){
		e.printStackTrace();
		}
	}

	@Override
	public ArrayList<_user> _list_of_voters(_choice c) {
		List<_user> _user_list = new ArrayList<_user>();
		conn = db_interaction._get_connection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT USERID FROM VOTE WHERE CHOICEID = ?");
			ps.setInt(1, c.get_choiceId());
			ResultSet res = ps.executeQuery();
			int i =0 ;
			while(res.next()) {
				_user_dao_impl user_metier = new _user_dao_impl();
				_user user= user_metier._get_user_by_id(res.getInt("USERID"));
				_user_list.add(user);
			}}
		catch(SQLException e){
			e.printStackTrace();
		}
		return (ArrayList<_user>) _user_list;
	}

	@Override
	public _choice _get_choice_by_id(int _choice_id) {
		_choice choice = new _choice();
		try{
			conn = db_interaction._get_connection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CHOICE WHERE CHOICEID = ?");
			ps.setLong(1, _choice_id);
			ResultSet res = ps.executeQuery();
			if(res.next()){
				choice.set_choiceId(res.getInt("CHOICEID"));
				choice.set_description(res.getString("DESCRIPTION"));
				choice.set_number_of_voters(res.getInt("VOTERSNUMBER"));
				choice.set_pollId(res.getInt("POLLID"));
				System.out.println(choice);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return choice;
	}
	
	@Override
	public void _delete_choice(_choice c) {
		conn = db_interaction._get_connection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("DELETE FROM VOTE WHERE CHOICEID = ?");
			ps.setLong(1, c.get_choiceId());
			ps.executeUpdate();
			ps = conn.prepareStatement("DELETE FROM CHOICE WHERE CHOICEID = ?");
			ps.setLong(1, c.get_choiceId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	

