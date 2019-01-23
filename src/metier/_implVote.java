package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.db_interaction;
import entities._poll;
import entities._vote;

public class _implVote implements _interfaceVote {

	@Override
	public void _add_vote(_vote v) {
		
			// TODO Auto-generated method stub
			Connection connection=db_interaction._get_connection();
			try{
			PreparedStatement ps = connection.prepareStatement
					("insert into vote( TYPE, CHOICEID, USERID) values (?,?,?)");
			
			ps.setString(1,v.get_type());
			ps.setInt(2,v.get_choiceId());
			ps.setInt(3,v.get_userId());
			

			ps.executeUpdate();
			}catch(SQLException e){
			e.printStackTrace();
			}
		}


}
