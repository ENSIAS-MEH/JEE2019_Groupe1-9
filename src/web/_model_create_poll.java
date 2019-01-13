package web;
import java.util.ArrayList;
import java.util.List;

import entities._choice;
import entities._poll;

public class _model_create_poll {
	public String description;
	public int duration;
	public String category;
	public String type;
	public String desc;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public _poll poll=new _poll();
	public _choice choice =new _choice();
	public _poll getPoll() {
		return poll;
	}
	public void setPoll(_poll poll) {
		this.poll = poll;
	}
	public _choice getChoice() {
		return choice;
	}
	public void setChoice(_choice choice) {
		this.choice = choice;
	}
	public List<_poll> listpoll = new ArrayList<_poll>(); 
	
	public List<_poll> getListpoll() {
		return listpoll;
	}
	public void setListpoll(List<_poll> listpoll) {
		this.listpoll = listpoll;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
