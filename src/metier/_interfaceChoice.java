package metier;

import entities._choice;
import entities._poll;

public interface _interfaceChoice {
	public static void _add_choice(_choice c) {
		// TODO Auto-generated method stub
		
	}
	public  void _vote(_choice c, int d);
	
	public _poll _get_poll(_choice _c);
	public int _number_of_voters_of_choice(_choice _c);
}
