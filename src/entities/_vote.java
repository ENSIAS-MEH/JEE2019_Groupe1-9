package entities;

import java.io.Serializable;

public class _vote implements Serializable {
    private String type;
    private Long _user_id;
    private Long _choice_id;
    private String _date;

    public _vote(String type, Long _user_id, Long _choice_id, String _date) {
        this.type = type;
        this._user_id = _user_id;
        this._choice_id = _choice_id;
        this._date = _date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void set_user_id(Long _user_id) {
        this._user_id = _user_id;
    }

    public void set_choice_id(Long _choice_id) {
        this._choice_id = _choice_id;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public String getType() {
        return type;
    }

    public Long get_user_id() {
        return _user_id;
    }

    public Long get_choice_id() {
        return _choice_id;
    }

    public String get_date() {
        return _date;
    }


}
