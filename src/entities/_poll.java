package entities;

import java.io.Serializable;

public class _poll implements Serializable {

    private Long _id;
    private String _date;
    private String _description;
    private String _duration;
    private String _category;
    private Long _user_id;

    public _poll(String _date, String _description, String _duration, String _category, Long _user_id) {
        this._date = _date;
        this._description = _description;
        this._duration = _duration;
        this._category = _category;
        this._user_id = _user_id;
    }

    public Long get_id() {
        return _id;
    }

    public String get_date() {
        return _date;
    }

    public String get_description() {
        return _description;
    }

    public String get_duration() {
        return _duration;
    }

    public String get_category() {
        return _category;
    }

    public Long get_user_id() {
        return _user_id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public void set_duration(String _duration) {
        this._duration = _duration;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public void set_user_id(Long _user_id) {
        this._user_id = _user_id;
    }
}
