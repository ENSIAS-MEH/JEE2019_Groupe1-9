package entities;

import java.io.Serializable;

public class _vote implements Serializable{
	private String _type;
	private int _userId;
	private int _choiceId;
	
	public String get_type() {
		return _type;
	}

	public void set_type(String type) {
		_type = type;
	}

	public int get_userId() {
		return _userId;
	}

	public void set_userId(int userId) {
		_userId = userId;
	}

	public int get_choiceId() {
		return _choiceId;
	}

	public void set_choiceId(int choiceId) {
		_choiceId = choiceId;
	}

	public _vote(String type, int userId, int choiceId) {
		super();
		_type = type;
		_userId = userId;
		_choiceId = choiceId;
	}
	public _vote() {
		
	}
}
