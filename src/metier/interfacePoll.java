package metier;

import java.util.ArrayList;

import entities.Poll;

public interface interfacePoll {
	public static void _create_poll(Poll p) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Poll>  _search_vote_by_Type(String type);
	public  Poll  _last_poll_for_user(int i);

}
