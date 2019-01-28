package web;

import java.io.Serializable;
import java.util.ArrayList;

import entities._number_of_voters;
import entities._poll;
import metier._implPoll;

public class _model_dashboard implements Serializable {
	public ArrayList<_poll> listepoll = new ArrayList<_poll>();
	public ArrayList<_poll> listepoll2 = new ArrayList<_poll>();
	public ArrayList<_number_of_voters> mylist=new ArrayList<_number_of_voters>();
	public String type;
	
	
	public ArrayList<_poll> getListepoll2() {
		return listepoll2;
	}

	public void setListepoll2(ArrayList<_poll> listepoll2) {
		this.listepoll2 = listepoll2;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	_implPoll impl =new _implPoll();
	
	public ArrayList<_number_of_voters> getMylist() {
		return mylist;
	}

	public void setMylist(ArrayList<_poll> mylist1) {
		int i;
		for(i=0;i<mylist1.size();i++) {
			_number_of_voters test= new _number_of_voters(mylist1.get(i),impl._get_number_of_voters(mylist1.get(i)));
			this.mylist.add(test);
			
		}
		
	}

	public ArrayList<_poll> getListepoll() {
		return listepoll;
	}

	public void setListepoll(ArrayList<_poll> listepoll) {
		this.listepoll = listepoll;
	} 

}
