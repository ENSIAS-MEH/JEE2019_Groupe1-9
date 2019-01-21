package entities;

import java.io.Serializable;
import java.sql.Date;

public class _poll implements Serializable{
	private int _pollId;
	private String _description;
	private int _duration;
	private String _category;
	private int _userId;
	private String _type;
	private Date _pollDate;
	
	public Date get_pollDate() {
		return _pollDate;
	}
	public void set_pollDate(Date _pollDate) {
		this._pollDate = _pollDate;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String type) {
		this._type = type;
	}
	public _poll(int pollId, String description, int duration, String category, int userId, String type ,Date pollDate) {
		super();
		_pollId = pollId;
		_description = description;
		_duration = duration;
		_category = category;
		_userId = userId;
		_type = type;
		_pollDate = pollDate;
	}
	
	@Override
	public String toString() {
		return "_poll [_pollId=" + _pollId + ", _description=" + _description + ", _duration=" + _duration
				+ ", _category=" + _category + ", _userId=" + _userId + ", _type=" + _type + ", _pollDate=" + _pollDate
				+ "]";
	}
	public _poll() {
		// TODO Auto-generated constructor stub
	}
	public int get_id_poll() {
		return _pollId;
	}
	public void set_id_poll(int pollId) {
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
}
