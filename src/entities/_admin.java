
package entities;

import java.io.Serializable;

public class _admin extends _person implements Serializable{

	public _admin(int id, String email, String password) {
		super(id, email, password);
	}
}
