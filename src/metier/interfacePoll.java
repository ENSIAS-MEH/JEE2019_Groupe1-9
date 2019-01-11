package metier;

import java.util.ArrayList;

import entities.Poll;

public interface interfacePoll {
	public void _create_poll(Poll p);
	public ArrayList<Poll>  _search_vote_by_Type(String type);

}
