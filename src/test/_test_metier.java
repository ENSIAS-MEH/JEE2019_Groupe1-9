package test;

import entities._user;
import metier._user_dao_impl;

public class _test_metier {


    //This just a test
    public static void main(String[] args) {
        _user test_user = new _user();
        test_user.set_password("passwordtestt");
        test_user.set_email("mailtest");
//        _user my_test = _user_dao_impl._login(test_user);
//        System.out.println(my_test.get_last_name()+"here you are");

    }
}
