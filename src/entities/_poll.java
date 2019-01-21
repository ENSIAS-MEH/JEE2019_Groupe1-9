package entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class _poll implements Serializable{
	private int _pollId;
	private String _description;
	private java.sql.Timestamp _date;
	private java.sql.Date _expires;
	private String _category;
	private int _userId;
	private int _number_choices;

	public _poll(String _description,  Timestamp _date,
				 String _category, int _userId, int _number_choices) {
		this._description = _description;
		this._date = _date;
		this._category = _category;
		this._userId = _userId;
		this._number_choices = _number_choices;
	}

	public Date get_expires() {
		return _expires;
	}

	public void set_expires(Date _expires) {
		this._expires = _expires;
	}

	public int get_pollId() {
		return _pollId;
	}

	public void set_pollId(int _pollId) {
		this._pollId = _pollId;
	}



	public Timestamp get_date() {
		return _date;
	}

	public void set_date(Timestamp _date) {
		this._date = _date;
	}

	public int get_userId() {
		return _userId;
	}

	public void set_userId(int _userId) {
		this._userId = _userId;
	}

	public int get_number_choices() {
		return _number_choices;
	}

	public void set_number_choices(int _number_choices) {
		this._number_choices = _number_choices;
	}
//			`id` int(11) NOT NULL AUTO_INCREMENT,
//  		`userid` mediumint(9) NOT NULL DEFAULT '0',
//			`open` int(1) NOT NULL DEFAULT '1',
//			`question` text NOT NULL,
//			`options` text NOT NULL,
//			`results` int(1) NOT NULL DEFAULT '1',
//			`choice` int(1) NOT NULL DEFAULT '0',
//			`share` int(1) NOT NULL DEFAULT '1',
//			`pass` varchar(255) NOT NULL,
//			`theme` varchar(255) NOT NULL,
//  		`custom` text NOT NULL,
//			`count` enum('day','month','off') DEFAULT 'off',
//			`created` datetime NOT NULL,
//			`expires` varchar(255) NOT NULL,
//  		`uniqueid` varchar(8) NOT NULL,
// 			 `votes` bigint(20) NOT NULL DEFAULT '0',
//			PRIMARY KEY (`id`)
	
	public _poll(int pollId, String description, String category, int userId) {
		super();
		_pollId = pollId;
		_description = description;
		_category = category;
		_userId = userId;
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
