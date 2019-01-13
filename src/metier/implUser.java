package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.db_interaction;
import entities.User;

public class implUser implements interfaceUser{

	@Override
	public void _add_user(User u) {
		// TODO Auto-generated method stub
		Connection connection=db_interaction.getConnection();
		try{
		PreparedStatement ps = connection.prepareStatement
		("insert into user(PASSWORD, EMAIL, FIRSTNAME, LASTNAME, BIRTHDATE, GENDER, NATIONALITY, ISACTIVE, PROFILEIMAGE) values (?,?,?,?,?,?,?,?,?)");
		//ps.setInt(1,u.getId());
		ps.setString(1,u.getPassword());
		ps.setString(2,u.getEmail());
		ps.setString(3,u.getFirstName());
		ps.setString(4,u.getLastName());
		ps.setString(5,u.getBirthDate());
		ps.setString(6,u.getGender());
		ps.setString(7,u.getNationality());
		ps.setInt(8,u.isIsActive());
		ps.setString(9,u.getProfileImage());

		ps.executeUpdate();

		}catch(SQLException e){
		e.printStackTrace();
		}
		
	}

	@Override
	public void _modify_user(User u) {
		// TODO Auto-generated method stub
		Connection con =db_interaction.getConnection();
		 try {
		PreparedStatement posted = con.prepareStatement("UPDATE USER SET  PASSWORD=? , EMAIL=? , FIRSTNAME=? , LASTNAME=? , BIRTHDATE=? , GENDER=? , NATIONALITY=? , ISACTIVE=? , PROFILEIMAGE=?  WHERE USERID=?");
		
		posted.setString(1,u.getPassword());
		posted.setString(2,u.getEmail());
		posted.setString(3,u.getFirstName());
		posted.setString(4,u.getLastName());
		posted.setString(5,u.getBirthDate());
		posted.setString(6,u.getGender());
		posted.setString(7,u.getNationality());
		posted.setInt(8,u.isIsActive());
		posted.setString(9,u.getProfileImage());
		posted.setInt(10,u.getId());
		
		int rowsUpdated = posted.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("user modified!");
		}
		posted.executeUpdate();
		 }catch(SQLException e){
				e.printStackTrace();
			}
		 
		
	}

}
