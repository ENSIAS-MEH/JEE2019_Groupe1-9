package test;

import java.util.ArrayList;

import entities.Admin;
import entities.Choice;
import entities.Poll;
import entities.User;
import metier.implAdmin;
import metier.implChoice;
import metier.implPoll;
import metier.implUser;
import metier.interfaceAdmin;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*//test1 :done
		Admin a=new Admin(1, "email",  "5f");
		implAdmin aa =new implAdmin();
		aa._add_admin(a);
		*/
		
		
		/*//test2:done
		Choice cc =new  Choice(1, "description", 0, 1 );
		implChoice test2=new implChoice();
		test2. _add_choice( cc);
		
		test2. _vote( cc, 1);
		
		
		*/
		  
		
		//test3:done
		/*Poll p=new Poll(6, "description", 50, "tout le monde", 2,"type1");
		implPoll pp=new implPoll();
		
		pp._create_poll( p);
		 Poll o= pp._last_poll_for_user(2);
		 System.out.println(o.getPollId());
		/*
		ArrayList<Poll> listevote= pp._search_vote_by_Type( "type1");
		for (int i=0; i<=listevote.size()-1; i++)
	      {
	       String  ch2= (String)listevote.get(i).getDescription();
	        System.out.println(ch2+" ")  ;
	      }
		
		
		
		*/
		  //test4:done
		/*User u =new User(1,  "email",  "password",  "firstName",  "lastName",  "maroc",
				 "1999-01-01",  "femme",  "profileImage",  0);
		User u1 =new User(1,  "email",  "password",  "firstName",  "lastName",  "maroc",
				 "1999-01-01",  "homme",  "profileImage",  0);
		implUser uu=new implUser();
		
		uu. _add_user( u);
		 uu._modify_user(u1);
*/
	}

}
