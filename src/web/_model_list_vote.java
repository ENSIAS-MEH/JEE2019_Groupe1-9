package web;

import java.util.ArrayList;

import entities._choice;
import entities._poll;

public class _model_list_vote {
	public ArrayList<_poll> listepoll;
	public ArrayList<_choice> listechoice;
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