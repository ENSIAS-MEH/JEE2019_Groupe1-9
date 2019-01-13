package web;
import java.util.ArrayList;
import java.util.List;

import entities.Choice;
import entities.Poll;

public class Modelcreatepoll {
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
	public Poll poll=new Poll();
	public Choice choice =new Choice();
	public Poll getPoll() {
		return poll;
	}
	public void setPoll(Poll poll) {
		this.poll = poll;
	}
	public Choice getChoice() {
		return choice;
	}
	public void setChoice(Choice choice) {
		this.choice = choice;
	}
	public List<Poll> listpoll = new ArrayList<Poll>(); 
	
	public List<Poll> getListpoll() {
		return listpoll;
	}
	public void setListpoll(List<Poll> listpoll) {
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
