package metier;

import java.util.ArrayList;

import entities._user;
import entities._vote;

public interface _interfaceVote {
	public ArrayList<_vote> _get_vote_of_user(_user u);
}
