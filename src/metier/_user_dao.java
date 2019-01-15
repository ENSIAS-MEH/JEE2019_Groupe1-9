package metier;

import entities._user;

import java.util.List;

public interface  _user_dao {

    public  _user _login(_user user);

    void _modify_user(_user check_user);
    void _modify_password(String  password, String email);

    public _user _get_user_by_id(Long id);
    public _user _save_user(_user user);
    public List<_user> _get_all_users();

    public void _add_user(_user check_user);
}
