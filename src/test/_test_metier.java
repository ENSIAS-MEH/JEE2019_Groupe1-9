package test;

import entities._poll;
import entities._user;
import metier._implPoll;
import metier._interfacePoll;
import metier._user_dao_impl;

public class _test_metier {


    //This just a test
    public static void main(String[] args) {
        _user test_user = new _user();
         _implPoll poll_dao = new _implPoll() ;
        test_user.set_password("passwordtestt");
        test_user.set_email("mailtest");
//        _user my_test = _user_dao_impl._login(test_user);
//        System.out.println(my_test.get_last_name()+"here you are");
        java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        _poll _new_poll = new _poll("This is the description of the poll",99999,
                "who is Bihy the one you don't know",
                sqlDate,"this is the category",5,null,3);
        poll_dao._create_poll(_new_poll);


    }


}
