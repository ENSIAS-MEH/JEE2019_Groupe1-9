package metier;

import DAO.db_interaction;
import com.sun.xml.internal.bind.v2.TODO;
import entities._person;
import entities._user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class _user_dao_impl implements _user_dao {

    private static Connection conn ;
    public  _user _login(_user _curr_user) {

        conn = db_interaction._get_connection();
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

    @Override
    public void _add_user(_user check_user) {

        Connection connection=db_interaction._get_connection();
        try{
            PreparedStatement ps = connection.prepareStatement
                    ("insert into user" +
                            "( PASSWORD, EMAIL, FIRSTNAME, LASTNAME, BIRTHDATE," +
                            " GENDER, NATIONALITY, ISACTIVE, PROFILEIMAGE) " +
                            "values (?,?,?,?,?,?,?,1,?)");
            ps.setString(1,check_user.get_password());
            ps.setString(2,check_user.get_email());
            ps.setString(3,check_user.get_first_name());
            ps.setString(4,check_user.get_last_name());
            ps.setString(5,check_user.get_birth_date());
            ps.setString(6,check_user.get_gender());
            ps.setString(7,check_user.get_nationality());
            ps.setString(8,check_user.get_profile_img());
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void _modify_user(_user check_user) {
        // TODO Auto-generated method stub
        Connection con =db_interaction._get_connection();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE USER SET  PASSWORD=? , EMAIL=? , FIRSTNAME=? , " +
                    "LASTNAME=? , BIRTHDATE=? , GENDER=? ," +
                    " NATIONALITY=? , ISACTIVE=? , PROFILEIMAGE=?  WHERE USERID=?");

            ps.setString(1,check_user.get_password());
            ps.setString(2,check_user.get_email());
            ps.setString(3,check_user.get_first_name());
            ps.setString(4,check_user.get_last_name());
            ps.setString(5,check_user.get_birth_date());
            ps.setString(6,check_user.get_gender());
            ps.setString(7,check_user.get_nationality());
            ps.setInt(8, check_user.get_is_active());
            ps.setString(8,check_user.get_profile_img());
            ps.setInt(10,check_user.get_id());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("user modified!");
            }
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }


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
