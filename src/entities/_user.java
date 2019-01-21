package entities;

import java.io.Serializable;

public class _user extends _person implements Serializable {
    @Override
	public String toString() {
		return "_user [_first_name=" + _first_name + ", _last_name=" + _last_name + ", _birth_date=" + _birth_date
				+ ", _nationality=" + _nationality + ", _gender=" + _gender + ", _is_active=" + _is_active
				+ ", _profile_img=" + _profile_img + ", _id=" + _id + ", _email=" + _email + ", _password=" + _password
				+ "]";
	}

	private String _first_name;
    private String _last_name;
    private String _birth_date;
    private String _nationality;
    private String _gender;
    private int _is_active;
    private String _profile_img;

    public _user(String email, String password, String _first_name, String _last_name, String _birth_date, String _nationality, String _gender, int _is_active, String _profile_img) {
        super(email, password);
        this._first_name = _first_name;
        this._last_name = _last_name;
        this._birth_date = _birth_date;
        this._nationality = _nationality;
        this._gender = _gender;
        this._is_active = _is_active;
        this._profile_img = _profile_img;
    }

    public int get_is_active() {
        return _is_active;
    }

    public void set_is_active(int _is_active) {
        this._is_active = _is_active;
    }

    public String get_profile_img() {
        return _profile_img;
    }

    public void set_profile_img(String _profile_img) {
        this._profile_img = _profile_img;
    }

    public _user() {
        super();
    }

    public String get_first_name() {
        return _first_name;
    }

    public String get_last_name() {
        return _last_name;
    }

    public String get_birth_date() {
        return _birth_date;
    }

    public String get_nationality() {
        return _nationality;
    }

    public String get_gender() {
        return _gender;
    }

    public void set_last_name(String _last_name) {
        this._last_name = _last_name;
    }

    public void set_birth_date(String _birth_date) {
        this._birth_date = _birth_date;
    }

    public void set_nationality(String _nationality) {
        this._nationality = _nationality;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    public void set_first_name(String _first_name) {
        this._first_name = _first_name;
    }
}
