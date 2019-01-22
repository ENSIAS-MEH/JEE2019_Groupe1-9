package entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class _poll implements Serializable{
	private int _pollId;
	private String _description;
	private int _duration;
	private String _category;
	private int _userId;
	private String _type;
	public int get_pollId() {
		return _pollId;
	}
	public void set_pollId(int _pollId) {
		this._pollId = _pollId;
	}
	public int get_userId() {
		return _userId;
	}
	public void set_userId(int _userId) {
		this._userId = _userId;
	}
	private LocalDate _pollDate;
	
	public LocalDate get_pollDate() {
		return _pollDate;
	}
	public void set_pollDate(LocalDate _pollDate) {
		this._pollDate = _pollDate;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String type) {
		this._type = type;
	}
	public _poll(int pollId, String description, int duration, String category, int userId, String type ,LocalDate pollDate) {
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
