package entities;

import java.io.Serializable;

public class _choice implements Serializable{
	private int _choiceId;
	private String _description;
	private int _numberOfVoters;
	private int _pollId;
	
	public _choice(int choiceId, String description, int numberOfVoters, int pollId) {
		super();
		_choiceId = choiceId;
		_description = description;
		_numberOfVoters = numberOfVoters;
		_pollId = pollId;
	}
	
	public _choice() {
		// TODO Auto-generated constructor stub
	}

	public int get_choiceId() {
		return _choiceId;
	}
	public void set_choiceId(int choiceId) {
		_choiceId = choiceId;
	}
	public String get_description() {
		return _description;
	}
	public void set_description(String description) {
		_description = description;
	}
	public int get_number_of_voters() {
		return _numberOfVoters;
	}
	public void set_number_of_voters(int numberOfVoters) {
		_numberOfVoters = numberOfVoters;
	}
	public int get_pollId() {
		return _pollId;
	}
	public void set_pollId(int pollId) {
		_pollId = pollId;
	}
}
