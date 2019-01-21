package metier;

import entities._choice;
import entities._poll;
import entities._user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface  _user_dao {

    public  _user _login(_user user);
    void _modify_user(_user check_user);
    public _user _save_user(_user user);
    public void _modify_password(String mdp , String email);
    public void _add_user(_user check_user);
    
    
    public ArrayList<_user> _get_all_users();
    public void _delete_user(_user u);
    public ArrayList<_poll> _get_poll_of_user(_user u);
    public HashMap<_poll,_choice> _get_vote_of_user(_user u);
    public ArrayList<_user> _get_recent_users(int _number_of_users);
    public int _get_number_of_users();
	_user _get_user_by_id(int id) ;
}
