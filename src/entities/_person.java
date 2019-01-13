package entities;

import java.io.Serializable;

public class _person implements Serializable {
	private int _id;
	private String _email;
	private String _password;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int id) {
		_id = id;
	}
	public String get_email() {
		return _email;
	}
	public void set_email(String email) {
		_email = email;
	}
	public String get_password() {
		return _password;
	}
	public void set_password(String password) {
		_password = password;
	}
	
	public _person(int id, String email, String password) {
		super();
		_id = id;
		_email = email;
		_password = password;
	}
	public _person() {
		// TODO Auto-generated constructor stub
	}
}
