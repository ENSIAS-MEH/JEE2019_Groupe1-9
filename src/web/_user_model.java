package web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import entities.*;
public class _user_model implements Serializable{
	private int user_id;
	private ArrayList<_user> all_users = new ArrayList<_user>();
	private ArrayList<_poll> all_polls_of_user = new ArrayList<_poll>();
	private HashMap<_poll,_choice> all_votes_of_users = new HashMap<_poll,_choice>();
	private ArrayList<_user> recent_users = new ArrayList<_user>();
	private int number_of_users;
	private _user user = new _user();
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public ArrayList<_user> getAll_users() {
		return all_users;
	}
	public void setAll_users(ArrayList<_user> all_users) {
		this.all_users = all_users;
	}
	public ArrayList<_poll> getAll_polls_of_user() {
		return all_polls_of_user;
	}
	public void setAll_polls_of_user(ArrayList<_poll> all_polls_of_user) {
		this.all_polls_of_user = all_polls_of_user;
	}
	public HashMap<_poll, _choice> getAll_votes_of_users() {
		return all_votes_of_users;
	}
	public void setAll_votes_of_users(HashMap<_poll, _choice> all_votes_of_users) {
		this.all_votes_of_users = all_votes_of_users;
	}
	public ArrayList<_user> getRecent_users() {
		return recent_users;
	}
	public void setRecent_users(ArrayList<_user> recent_users) {
		this.recent_users = recent_users;
	}
	public int getNumber_of_users() {
		return number_of_users;
	}
	public void setNumber_of_users(int number_of_users) {
		this.number_of_users = number_of_users;
	}
	public _user getUser() {
		return user;
	}
	public void setUser(_user user) {
		this.user = user;
	}
	public _user_model(int user_id, ArrayList<_user> all_users, ArrayList<_poll> all_polls_of_user,
			HashMap<_poll, _choice> all_votes_of_users, ArrayList<_user> recent_users, int number_of_users,
			_user user) {
		super();
		this.user_id = user_id;
		this.all_users = all_users;
		this.all_polls_of_user = all_polls_of_user;
		this.all_votes_of_users = all_votes_of_users;
		this.recent_users = recent_users;
		this.number_of_users = number_of_users;
		this.user = user;
	}
	public _user_model() {
		super();
	}
	
}
