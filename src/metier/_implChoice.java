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
		// TODO Auto-generated method stub
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
	public  void _vote(_choice c, int d) {
	    Connection con =db_interaction._get_connection();
	 try {
	PreparedStatement posted = con.prepareStatement("UPDATE CHOICE SET  VOTERSNUMBER=?  WHERE CHOICEID=?");
	int p=c.get_number_of_voters() +1;
	posted.setInt(1,p);
	posted.setInt(2,d);
	
	int rowsUpdated = posted.executeUpdate();
	if (rowsUpdated > 0) {
	    System.out.println("thanks for voting!");
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


}	

