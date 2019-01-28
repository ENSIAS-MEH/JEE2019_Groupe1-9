package entities;

import java.io.Serializable;

public class _admin  extends _person implements Serializable {

    public _admin(String email, String password) {
        super(email, password);
    }

    
	public _admin(String email, String password, int id) {
		super(email, password, id);
	}


	public _admin() {
		super();
	}


	@Override
	public String toString() {
		return "_admin [_id=" + _id + ", _email=" + _email + ", _password=" + _password + "]";
	}
}
