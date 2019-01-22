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
        java.sql.Date  sqlDateexpires = new java.sql.Date(new java.util.Date().getTime());
        _poll p = new _poll();
        p.set_description("ok ok  this is my test");
        p.set_date(sqlDate);
        p.set_category("an other test");
        p.set_userId(2);
        p.set_expires(sqlDateexpires);
        poll_dao._create_poll(p);
        int _the_poll = poll_dao._last_poll_for_user(2);
        System.out.println("this is after creating the account :"+_the_poll);


    }


}
