package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.db_interaction;
import entities._choice;
import entities._poll;

public class _implChoice implements _interfaceChoice {

	
	

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
	
	
	
	
	
	
}	

