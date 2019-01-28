package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.db_interaction;
import entities._admin;
import entities._user;

public class _implAdmin implements _interfaceAdmin {
	private static Connection conn ;

	public void _add_admin(_admin a) {
		Connection connection=db_interaction._get_connection();
		try{
		PreparedStatement ps = connection.prepareStatement
		("insert into admin(PASSWORD, EMAIL) values (?,?)");
		//ps.setInt(1,a.getId());
		ps.setString(1,a. get_password());
		ps.setString(2,a.get_email());
		ps.executeUpdate();
		System.out.println("test1");
		}catch(SQLException e){
		e.printStackTrace();
		}
		
	}

	public  _admin _login(_admin _curr_user) {

		conn = db_interaction._get_connection();
		_admin _new_user = new _admin();
		String sql = "select * from admin where Email= ? and Password= ? ";
		PreparedStatement pstmnt = null;
		try {
			pstmnt = conn.prepareStatement(sql);
			pstmnt.setString(1,_curr_user.get_email());
			pstmnt.setString(2,_curr_user.get_password());
			ResultSet rs = pstmnt.executeQuery();
			if(rs.next()) {
				_new_user = get_user_Rs(rs);
				return _new_user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return _new_user;
	}
	private _admin get_user_Rs(ResultSet rs) {
		_admin _new_user= null;
		try {
			_new_user = new _admin();
			_new_user.set_id(rs.getInt("AdminId"));
			_new_user.set_email(rs.getString("Email"));
			return _new_user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return _new_user;


	}

}
