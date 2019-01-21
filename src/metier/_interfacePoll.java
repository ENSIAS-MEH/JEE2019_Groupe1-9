package metier;

import java.util.ArrayList;

import entities._choice;
import entities._poll;
import entities._user;

public interface _interfacePoll {
	public static void _create_poll(_poll p) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<_poll>  _search_vote_by_Type(String type);
	public  _poll  _last_poll_for_user(int i);
	
	
	public void _delete_poll(_poll p);
	public ArrayList<_poll> _get_recent_polls(int _number_of_polls);
	public ArrayList<_choice> _get_choice_for_poll(_poll _p);
	public int _get_number_of_voters(_poll _p);
	public _user _get_user_of_poll(_poll _p);
	public int _get_number_of_polls();
	public _poll _get_poll_by_id(long _id);
	
}
