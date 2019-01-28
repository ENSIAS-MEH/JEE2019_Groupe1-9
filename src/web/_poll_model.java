package web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import entities.*;
import metier._implPoll;
import metier._interfacePoll;



public class _poll_model implements Serializable{
	private _interfacePoll _poll_metier = new _implPoll();
	public int getPoll_id() {
		return poll_id;
	}
	public void setPoll_id(int poll_id) {
		this.poll_id = poll_id;
	}
	public ArrayList<_poll> getAll_polls() {
		return all_polls;
	}
	public void setAll_polls(ArrayList<_poll> all_polls) {
		this.all_polls = all_polls;
	}
	public ArrayList<_choice> getAll_choices_of_poll() {
		return all_choices_of_poll;
	}
	public void setAll_choices_of_poll(ArrayList<_choice> all_choices_of_poll) {
		this.all_choices_of_poll = all_choices_of_poll;
	}
	public HashMap<_poll, _choice> getAll_votes_of_polls() {
		return all_votes_of_polls;
	}
	public void setAll_votes_of_polls(HashMap<_poll, _choice> all_votes_of_polls) {
		this.all_votes_of_polls = all_votes_of_polls;
	}
	public ArrayList<_poll> getRecent_polls() {
		return recent_polls;
	}
	public void setRecent_polls(ArrayList<_poll> recent_polls) {
		this.recent_polls = recent_polls;
	}
	public int getNumber_of_voters_of_poll() {
		return number_of_voters_of_poll;
	}
	public void setNumber_of_voters_of_poll(int number_of_voters_of_poll) {
		this.number_of_voters_of_poll = number_of_voters_of_poll;
	}
	public int getNumber_of_polls() {
		return number_of_polls;
	}
	public void setNumber_of_polls(int number_of_polls) {
		this.number_of_polls = number_of_polls;
	}
	public _user getUser_creator_of_poll() {
		return user_creator_of_poll;
	}
	public void setUser_creator_of_poll(_user user_creator_of_poll) {
		this.user_creator_of_poll = user_creator_of_poll;
	}
	public _poll getPoll() {
		return poll;
	}
	public void setPoll(_poll poll) {
		this.poll = poll;
	}
	public _poll_model() {
		super();
		// TODO Auto-generated constructor stub
	}
	public _poll_model(int poll_id, ArrayList<_poll> all_polls, ArrayList<_choice> all_choices_of_poll,
			HashMap<_poll, _choice> all_votes_of_polls, ArrayList<_poll> recent_polls, int number_of_voters_of_poll,
			int number_of_polls, _user user_creator_of_poll, _poll poll) {
		super();
		this.poll_id = poll_id;
		this.all_polls = all_polls;
		this.all_choices_of_poll = all_choices_of_poll;
		this.all_votes_of_polls = all_votes_of_polls;
		this.recent_polls = recent_polls;
		this.number_of_voters_of_poll = number_of_voters_of_poll;
		this.number_of_polls = number_of_polls;
		this.user_creator_of_poll = user_creator_of_poll;
		this.poll = poll;
	}
	public _interfacePoll get_poll_metier() {
		return _poll_metier;
	}
	public void set_poll_metier(_interfacePoll _poll_metier) {
		this._poll_metier = _poll_metier;
	}
	public ArrayList<_user> getVoters() {
		return voters;
	}
	public void setVoters(ArrayList<_user> voters) {
		this.voters = voters;
	}
	private int poll_id;
	private ArrayList<_poll> all_polls = new ArrayList<_poll>();
	private ArrayList<_choice> all_choices_of_poll = new ArrayList<_choice>();
	private HashMap<_poll,_choice> all_votes_of_polls = new HashMap<_poll,_choice>();
	private ArrayList<_poll> recent_polls = new ArrayList<_poll>();
	private ArrayList<_user> voters =new ArrayList<_user>(); 
	private int number_of_voters_of_poll;
	private int number_of_polls;
	private _user user_creator_of_poll = new _user();
	private _poll poll = new _poll();
}
