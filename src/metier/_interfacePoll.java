package metier;

import java.util.ArrayList;

import entities._poll;

public interface _interfacePoll {
	public static void _create_poll(_poll p) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<_poll>  _search_vote_by_Type(String type);
	public ArrayList<_poll>  _search_vote_by_userid(int id);
	public  _poll  _last_poll_for_user(int i);
	public void delete_poll(int id);
}
