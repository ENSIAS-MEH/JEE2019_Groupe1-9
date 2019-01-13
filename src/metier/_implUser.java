package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAO.db_interaction;
import entities._user;

public class _implUser implements _interfaceUser{

	@Override
	public void _add_user(_user u) {
		// TODO Auto-generated method stub
		Connection connection=db_interaction.getConnection();
		try{
		PreparedStatement ps = connection.prepareStatement
		("insert into user(PASSWORD, EMAIL, FIRSTNAME, LASTNAME, BIRTHDATE, GENDER, NATIONALITY, ISACTIVE, PROFILEIMAGE) values (?,?,?,?,?,?,?,?,?)");
		//ps.setInt(1,u.getId());
		ps.setString(1,u.get_password());
		ps.setString(2,u.get_email());
		ps.setString(3,u.get_first_name());
		ps.setString(4,u.get_last_name());
		ps.setString(5,u.get_birth_date());
		ps.setString(6,u.get_gender());
		ps.setString(7,u.get_nationality());
		ps.setInt(8,u.get_is_active());
		ps.setString(9,u.get_profile_img());

		ps.executeUpdate();

		}catch(SQLException e){
		e.printStackTrace();
		}
		
	}

	@Override
	public void _modify_user(_user u) {
		// TODO Auto-generated method stub
		Connection con =db_interaction.getConnection();
		 try {
		PreparedStatement posted = con.prepareStatement("UPDATE USER SET  PASSWORD=? , EMAIL=? , FIRSTNAME=? , LASTNAME=? , BIRTHDATE=? , GENDER=? , NATIONALITY=? , ISACTIVE=? , PROFILEIMAGE=?  WHERE USERID=?");
		
		posted.setString(1,u.get_password());
		posted.setString(2,u.get_email());
		posted.setString(3,u.get_first_name());
		posted.setString(4,u.get_last_name());
		posted.setString(5,u.get_birth_date());
		posted.setString(6,u.get_gender());
		posted.setString(7,u.get_nationality());
		posted.setInt(8,u.get_is_active());
		posted.setString(9,u.get_profile_img());
		posted.setInt(10,u.get_id());
		
		int rowsUpdated = posted.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("user modified!");
		}
		posted.executeUpdate();
		 }catch(SQLException e){
				e.printStackTrace();
			}
		 
		
	}
	
	
	private static Connection conn ;
    public  _user _login(_user _curr_user) {

        conn = db_interaction.getConnection();
        _user _new_user = null;
        String sql = "select * from user where Email= ? and Password= ? ";
        PreparedStatement pstmnt = null;
        try {
            pstmnt = conn.prepareStatement(sql);
            pstmnt.setString(1,_curr_user.get_email());
            pstmnt.setString(2,_curr_user.get_password());
            ResultSet rs = pstmnt.executeQuery();
            if(rs.next()) {
                _new_user = new _user();
                _new_user = get_user_Rs(rs);
                return _new_user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _new_user;
    }
    
    
    
    private _user get_user_Rs(ResultSet rs) {

        _user _new_user= null;
        try {
            _new_user = new _user();
            _new_user.set_id(rs.getInt("UserId"));
            _new_user.set_first_name(rs.getString("FirstName"));
            _new_user.set_last_name(rs.getString("LastName"));
            _new_user.set_email(rs.getString("Email"));
            _new_user.set_gender(rs.getString("Gender"));
            _new_user.set_nationality(rs.getString("Nationality"));
            _new_user.set_birth_date(rs.getString("BirthDate"));
            _new_user.set_is_active(Integer.parseInt(rs.getString("IsActive")));
            _new_user.set_profile_img(rs.getString("ProfileImage"));
            return _new_user;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _new_user;


    }
    
    
    @Override
    public _user _get_user_by_id(Long id) {
        return null;
    }

    @Override
    public _user _save_user(_user user) {
        return null;
    }

    @Override
    public List<_user> _get_all_users() {
        return null;
    }

    
    
    
    
    
	
	
	
	

}
