package web;

import java.io.Serializable;
import java.util.ArrayList;

import entities._choice;
import entities._poll;
import entities._vote;

public   class _model_list_vote implements Serializable {
	public ArrayList<_poll> listepoll = new ArrayList<_poll>();
	public ArrayList<_poll> listepoll1 = new ArrayList<_poll>();
	public ArrayList<_poll> getListepoll1() {
		return listepoll1;
	}

	public void setListepoll1(ArrayList<_poll> listepoll1) {
		this.listepoll1 = listepoll1;
	}

	public ArrayList<_choice> listechoice= new ArrayList<_choice>();
	public _choice choice= new _choice();
	public _vote vote= new _vote();
	public int id;
	public _poll poll= new _poll();
	 public _poll pollclone =(_poll) poll.clone();
	public _poll getPollclone() {
		return pollclone;
	}

	public _poll getPoll() {
		return poll;
	}

	public void setPoll(_poll poll) {
		this.poll = poll;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public _vote getVote() {
		return vote;
	}

	public void setVote(_vote vote) {
		this.vote = vote;
	}

	public _choice getChoice() {
		return choice;
	}

	public void setChoice(_choice choice) {
		this.choice = choice;
	}

	public ArrayList<_choice> getListechoice() {
		return listechoice;
	}

	public void setListechoice(ArrayList<_choice> listechoice) {
		this.listechoice = listechoice;
	}

	public String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<_poll> getListepoll() {
		return listepoll;
	}

	public void setListepoll(ArrayList<_poll> listepoll) {
		this.listepoll = listepoll;
	}
	

}
