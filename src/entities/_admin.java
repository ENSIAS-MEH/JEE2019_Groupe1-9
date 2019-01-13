package entities;

import java.io.Serializable;

public class _admin  extends _person implements Serializable {

    public _admin(String email, String password) {
        super(email, password);
    }
}
