package entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class _poll implements Serializable {
	private int _pollId;
	private String _description;
	private java.sql.Timestamp _date;
	private java.sql.Date _expires;
	private String _category;
	private int _userId;


	public _poll() {
		// TODO Auto-generated constructor stub
	}

	public int get_pollId() {
		return _pollId;
	}

	public void set_pollId(int _pollId) {
		this._pollId = _pollId;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

	public Timestamp get_date() {
		return _date;
	}

	public void set_date(Timestamp _date) {
		this._date = _date;
	}

	public Date get_expires() {
		return _expires;
	}

	public void set_expires(Date _expires) {
		this._expires = _expires;
	}

	public String get_category() {
		return _category;
	}

	public void set_category(String _category) {
		this._category = _category;
	}

	public int get_userId() {
		return _userId;
	}

	public void set_userId(int _userId) {
		this._userId = _userId;
	}

	@Override
	public String toString() {
		return "_poll{" +
				"_pollId=" + _pollId +
				", _description='" + _description + '\'' +
				", _date=" + _date +
				", _expires=" + _expires +
				", _category='" + _category + '\'' +
				", _userId=" + _userId +
				'}';
	}
}

