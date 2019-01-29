package metier;

import DAO.db_interaction;
import com.sun.xml.internal.bind.v2.TODO;
import entities._choice;
import entities._person;
import entities._poll;
import entities._user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Connection con =db_interaction._get_connection();
        try {
            PreparedStatement ps;
            if (check_user.get_id()>=1){ //modify by id
                ps = con.prepareStatement("UPDATE USER SET  Password=? , Email=? , FirstName=? , " +
                        "LastName=? , BirthDate=? , Gender=? ," +
                        " Nationality=? , IsActive=? , ProfileImage=?  WHERE USERID=?");
                ps.setInt(10,check_user.get_id());
            }else { //modify by email
                ps = con.prepareStatement("UPDATE USER SET  Password=? , Email=? , FirstName=? , " +
                        "LastName=? , BirthDate=? , Gender=? ," +
                        " Nationality=? , IsActive=? , ProfileImage=?  WHERE Email=?");
                ps.setString(10,check_user.get_email());
            }
            ps.setString(1,check_user.get_password());
            ps.setString(2,check_user.get_email());
            ps.setString(3,check_user.get_first_name());
            ps.setString(4,check_user.get_last_name());
            ps.setString(5,check_user.get_birth_date());
            ps.setString(6,check_user.get_gender());
            ps.setString(7,check_user.get_nationality());
            ps.setInt(8, check_user.get_is_active());
            ps.setString(9,check_user.get_profile_img());
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
    public void _modify_password(String mdp , String email) {
        // TODO Auto-generated method stub
        Connection con =db_interaction._get_connection();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE USER SET  PASSWORD=?  WHERE EMAIL=?");

            ps.setString(1,mdp);
            ps.setString(2,email);


            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("password modified!");
            }
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public _user _get_user_by_id(int id) {
        _user user = new _user();
        try{
            conn = db_interaction._get_connection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE USERID = ?");
            ps.setLong(1, id);
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                user.set_id(res.getInt("UserId"));
                user.set_password(res.getString("Password"));
                user.set_email(res.getString("Email"));
                user.set_first_name(res.getString("FirstName"));
                user.set_last_name(res.getString("LastName"));
                user.set_birth_date(res.getString("BirthDate"));
                user.set_gender(res.getString("Gender"));
                user.set_nationality(res.getString("Nationality"));
                user.set_is_active(res.getInt("IsActive"));
                user.set_profile_img(res.getString("ProfileImage"));
                System.out.println(user);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;}

    @Override
    public _user _save_user(_user user) {
        return null;
    }

    @Override
    public ArrayList<_user> _get_all_users(){
        conn = db_interaction._get_connection();
        ArrayList<_user> _user_list= new ArrayList<_user>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE 1");
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                System.out.print("here");
                _user user = new _user();
                user.set_id(res.getInt("UserId"));
                user.set_password(res.getString("Password"));
                user.set_email(res.getString("Email"));
                user.set_first_name(res.getString("FirstName"));
                user.set_last_name(res.getString("LastName"));
                user.set_birth_date(res.getString("BirthDate"));
                user.set_gender(res.getString("Gender"));
                user.set_nationality(res.getString("Nationality"));
                user.set_is_active(res.getInt("IsActive"));
                user.set_profile_img(res.getString("ProfileImage"));
                _user_list.add(user);
                System.out.println(user);
            }
        }catch(SQLException e) {
            e.printStackTrace();}
        return _user_list;
    }

    @Override
    public void _delete_user(_user u)  {
        conn = db_interaction._get_connection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM USER WHERE USERID = ?");
            ps.setLong(1, u.get_id());
            ps.executeUpdate();
            ps = conn.prepareStatement("SELECT POLLID FROM POLL WHERE USERID = ?");
            ps.setLong(1, u.get_id());
            ResultSet rs = ps.executeQuery();
            _implPoll _metier_poll = new _implPoll();
            while (rs.next()) {
                _poll poll = _metier_poll._get_poll_by_id(rs.getInt("POLLID"));
                _metier_poll._delete_poll(poll);
            }
            ps = conn.prepareStatement("DELETE FROM VOTE WHERE USERID = ?");
            ps.setLong(1, u.get_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<_poll> _get_poll_of_user(_user u) {
        conn = db_interaction._get_connection();
        List<_poll> _poll_list= new ArrayList<_poll>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM POLL WHERE USERID = ?");
            ps.setLong(1, u.get_id());
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                _poll poll = new _poll();
                poll.set_id_poll(res.getInt("POLLID"));
                poll.set_description(res.getString("DESCRIPTION"));
                poll.set_category(res.getString("CATEGORY"));
                poll.set_user_id(res.getInt("USERID"));

                // turn the String POLLDATE in database to LocalDate
                poll.set_date(res.getTimestamp("POLLDATE"));
                poll.set_expires(res.getDate("expires"));

                _poll_list.add(poll);
                System.out.println(poll);
            }
        }catch(SQLException e) {
            e.printStackTrace();}
        return (ArrayList<_poll>) _poll_list;
    }

    @Override
    public HashMap<_poll, _choice> _get_vote_of_user(_user u) {
        conn = db_interaction._get_connection();
        Map<_poll,_choice> _vote_list= new HashMap<_poll,_choice>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM POLL,CHOICE,VOTE WHERE POLL.PollId=CHOICE.PollId and CHOICE.choiceId = Vote.ChoiceId and Vote.userId = ?");
            ps.setLong(1, u.get_id());
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                _poll poll = new _poll();
                poll.set_id_poll(res.getInt("POLLID"));
                poll.set_description(res.getString("DESCRIPTION"));
                poll.set_category(res.getString("CATEGORY"));
                poll.set_user_id(res.getInt(5));          // 5 is the column_index of UserId of the user that creates the poll

                // turn the String POLLDATE in database to LocalDate
                poll.set_date(res.getTimestamp("POLLDATE"));
                _choice choice = new _choice();
                choice.set_choiceId(res.getInt("CHOICEID"));
                choice.set_description(res.getString(8));   // 8 is the column_index of Description of the choice
                choice.set_number_of_voters(res.getInt("VOTERSNUMBER"));
                choice.set_pollId(res.getInt("POLLID"));
                poll.set_expires(res.getDate("expires"));

                System.out.println(poll);
                System.out.println(choice);
                _vote_list.put(poll, choice);
            }
        }catch(SQLException e) {
            e.printStackTrace();}
        return (HashMap<_poll, _choice>) _vote_list;
    }

    @Override
    public ArrayList<_user> _get_recent_users(int _number_of_users) {
        conn = db_interaction._get_connection();
        List<_user> _user_list= new ArrayList<_user>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER ORDER BY USERID DESC");
            ResultSet res = ps.executeQuery();
            int i = 0;
            while((res.next()) && (i<_number_of_users) ) {
                _user user = new _user();
                user.set_id(res.getInt("UserId"));
                user.set_password(res.getString("Password"));
                user.set_email(res.getString("Email"));
                user.set_first_name(res.getString("FirstName"));
                user.set_last_name(res.getString("LastName"));
                user.set_birth_date(res.getString("BirthDate"));
                user.set_gender(res.getString("Gender"));
                user.set_nationality(res.getString("Nationality"));
                user.set_is_active(res.getInt("IsActive"));
                user.set_profile_img(res.getString("ProfileImage"));
                _user_list.add(user);
                i++;
                System.out.println(user);
            }
        }catch(SQLException e) {
            e.printStackTrace();}
        return (ArrayList<_user>) _user_list;
    }

    @Override
    public int _get_number_of_users() {
        int _number_of_users = 0;
        try{
            conn = db_interaction._get_connection();
            PreparedStatement ps = conn.prepareStatement("SELECT Count(*) AS NUMBER FROM USER ");
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                _number_of_users = res.getInt("NUMBER");
                System.out.println(_number_of_users);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return _number_of_users;
    }







}
