package metier;

import java.util.List;

import entities._user;

public interface _interfaceUser {
	public void _add_user(_user u);
	public  void _modify_user(_user u);
	
	public  _user _login(_user user);
	
	public _user _get_user_by_id(Long id);
    public _user _save_user(_user user);
    public List<_user> _get_all_users();
}
