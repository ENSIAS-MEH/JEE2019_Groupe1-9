package metier;

import java.util.ArrayList;

import entities._poll;

public interface _interfacePoll {
	public  void _create_poll(_poll p) ;
	public ArrayList<_poll>  _search_vote_by_Type(String type);
	public  _poll  _last_poll_for_user(int i);
	public  ArrayList<_poll>  _search_poll_by_category(String typ);

}
