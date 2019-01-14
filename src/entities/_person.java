package entities;

import java.io.Serializable;

public class _person implements Serializable {

    protected int _id;
    protected String _email;
    protected String _password;

    public _person(String email, String password) {
        this._email = email;
        this._password = password;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public _person() {

    }

    public int get_id() {
        return _id;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String  get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
