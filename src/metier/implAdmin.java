package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.db_interaction;
import entities.Admin;

public class implAdmin implements interfaceAdmin {

	public void _add_admin(Admin a) {
		// TODO Auto-generated method stub
		Connection connection=db_interaction.getConnection();
		try{
		PreparedStatement ps = connection.prepareStatement
		("insert into admin(ADMINID, PASSWORD, EMAIL) values (?,?,?)");
		ps.setInt(1,a.getId());
		ps.setString(2,a.getPassword());
		ps.setString(3,a.getEmail());
		ps.executeUpdate();
		System.out.println("test1");
		}catch(SQLException e){
		e.printStackTrace();
		}
		
	}

}
