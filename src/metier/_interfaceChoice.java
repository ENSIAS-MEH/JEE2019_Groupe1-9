package metier;

import java.util.ArrayList;

import entities._choice;
import entities._poll;

public interface _interfaceChoice {
	public static void _add_choice(_choice c) {
		// TODO Auto-generated method stub
		
	}
	public  void _vote(_choice c);
	public  ArrayList<_choice>  _search_choice_for_poll(int id);
	public _choice _get_choice_bydescription_andpollid(int pollid, String description);
	
}
