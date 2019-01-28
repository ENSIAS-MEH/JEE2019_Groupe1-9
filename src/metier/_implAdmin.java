package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.db_interaction;
import entities._admin;
import entities._user;

public class _implAdmin implements _interfaceAdmin {
	private static Connection conn ;

	public void _add_admin(_admin a) {
		// TODO Auto-generated method stub
		Connection connection=db_interaction._get_connection();
		try{
		PreparedStatement ps = connection.prepareStatement("insert into admin(PASSWORD, EMAIL) values (?,?)");
		//ps.setInt(1,a.getId());
		ps.setString(1,a. get_password());
		ps.setString(2,a.get_email());
		ps.executeUpdate();
		}catch(SQLException e){
		e.printStackTrace();
		}
		
	}

	@Override
	public void _update_admin(_admin a) {
		Connection connection=db_interaction._get_connection();
		try{
		PreparedStatement ps = connection.prepareStatement("UPDATE ADMIN SET PASSWORD=?  , EMAIL=? WHERE ADMINID = ?");
		//ps.setInt(1,a.getId());
		ps.setString(1,a. get_password());
		ps.setString(2,a.get_email());
		ps.setInt(3,a.get_id());
		ps.executeUpdate();
		}catch(SQLException e){
		e.printStackTrace();
		}
		
	}

	@Override
	public _admin _get_admin_by_id(int _id) {
		_admin admin = new _admin();
		try{
			conn = db_interaction._get_connection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ADMIN WHERE ADMINID = ?");
			ps.setLong(1, _id);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				admin.set_id(res.getInt("AdminId"));
				admin.set_password(res.getString("Password"));
				admin.set_email(res.getString("Email"));
				
				System.out.println(admin);
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return admin;
	}

	@Override
	public ArrayList<_admin> _get_all_admins() {
		conn = db_interaction._get_connection();
    	List<_admin> _admin_list= new ArrayList<_admin>();
    	try {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ADMIN WHERE 1");
		ResultSet res = ps.executeQuery();
		while(res.next()) {
			_admin admin = new _admin();
			admin.set_id(res.getInt("AdminId"));
			admin.set_password(res.getString("Password"));
			admin.set_email(res.getString("Email"));
			_admin_list.add(admin);
			System.out.println(admin);
		}
    	}catch(SQLException e) {
    		e.printStackTrace();}
		return (ArrayList<_admin>) _admin_list;
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
