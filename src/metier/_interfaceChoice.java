package metier;

import entities._choice;
import entities._user;

import java.util.ArrayList;

public interface _interfaceChoice {
	public  void _add_choice(_choice c) ;
	public  void _vote(int choice_id);

	public ArrayList<_user> _list_of_voters(_choice c);
	public _choice _get_choice_by_id(int _choice_id);
	public void _delete_choice(_choice c);
	public ArrayList<_choice> _search_choice_for_poll(int id);
	public _choice _get_choice_bydescription_andpollid(int pollid, String description);
}
