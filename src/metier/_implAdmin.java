package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.db_interaction;
import entities._admin;

public class _implAdmin implements _interfaceAdmin {

	public void _add_admin(_admin a) {
		// TODO Auto-generated method stub
		Connection connection=db_interaction._get_connection();
		try{
		PreparedStatement ps = connection.prepareStatement
		("insert into admin(PASSWORD, EMAIL) values (?,?)");
		//ps.setInt(1,a.getId());
		ps.setString(1,a. get_password());
		ps.setString(2,a.get_email());
		ps.executeUpdate();
		}catch(SQLException e){
		e.printStackTrace();
		}
		
	}

}
