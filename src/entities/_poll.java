package entities;

import java.io.Serializable;

public class _poll extends Object implements Cloneable{
	private int _pollId;
	private String _description;
	private int _duration;
	private String _category;
	private int _userId;
	private String _type;
	
	public String get_type() {
		return _type;
	}
	public void set_type(String type) {
		this._type = type;
	}
	public _poll(int pollId, String description, int duration, String category, int userId, String type ) {
		super();
		_pollId = pollId;
		_description = description; 
		_duration = duration;
		_category = category;
		_userId = userId;
		_type = type;
	}
	public _poll() {
		// TODO Auto-generated constructor stub
	}
	public _poll(int pollId) {
		_pollId =pollId;
	}
	public int get_pollId() {
		return _pollId;
	}
	public void set_pollId(int pollId) {
		_pollId = pollId;
	}
	public String get_description() {
		return _description;
	}
	public void set_description(String description) {
		_description = description;
	}
	public int get_duration() {
		return _duration;
	}
	public void set_duration(int duration) {
		_duration = duration;
	}
	public String get_category() {
		return _category;
	}
	public void set_category(String category) {
		_category = category;
	}
	public int get_user_id() {
		return _userId;
	}
	public void set_user_id(int userId) {
		_userId = userId;
	}
	
	
	
	 public  Object clone(){
		 try {
		 return super.clone();
		 }
		 catch (CloneNotSupportedException e){
		 throw new InternalError();
		 }
		 }
}
