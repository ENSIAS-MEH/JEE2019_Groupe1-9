package metier;

import java.util.ArrayList;

import entities.*;


public interface _interfaceChoice {
	public static void _add_choice(_choice c) {
		// TODO Auto-generated method stub
		
	}
	public  void _vote(_choice c, int d);
	
	public ArrayList<_user> _list_of_voters(_choice c);
	}
