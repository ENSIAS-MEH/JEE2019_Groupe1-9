package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.db_interaction;
import entities.Choice;

public class implChoice implements interfaceChoice {

	
	

	@Override
	public void _add_choice(Choice c) {
		// TODO Auto-generated method stub
		Connection connection=db_interaction.getConnection();
		try{
		PreparedStatement ps = connection.prepareStatement
				("insert into choice(CHOICEID, DESCRIPTION, VOTERSNUMBER, POLLID) values (?,?,?,?)");
		ps.setInt(1,c.getChoiceId());
		ps.setString(2,c.getDescription());
		ps.setInt(3,c.getNumberOfVoters());
		ps.setInt(4,c.getPollId());


		ps.executeUpdate();
		}catch(SQLException e){
		e.printStackTrace();
		}
		
	}

	@Override
	public  void _vote(Choice c, int d) {
	    Connection con =db_interaction.getConnection();
	 try {
	PreparedStatement posted = con.prepareStatement("UPDATE CHOICE SET  VOTERSNUMBER=?  WHERE CHOICEID=?");
	int p=c.getNumberOfVoters() +1;
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
}	

