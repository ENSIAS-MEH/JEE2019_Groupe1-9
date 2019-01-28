package metier;
import java.util.ArrayList;

//modified
import entities._admin;

public interface _interfaceAdmin {
	public void _add_admin(_admin a);
	public void _update_admin(_admin a);
	public _admin _get_admin_by_id(int _id);
	public ArrayList<_admin> _get_all_admins();
	

}
