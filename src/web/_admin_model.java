package web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import entities.*;
public class _admin_model implements Serializable{
	private int admin_id;
	private ArrayList<_admin> all_admins = new ArrayList<_admin>();
	public _admin_model(int admin_id, ArrayList<_admin> all_admins) {
		super();
		this.admin_id = admin_id;
		this.all_admins = all_admins;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public ArrayList<_admin> getAll_admins() {
		return all_admins;
	}
	public void setAll_admins(ArrayList<_admin> all_admins) {
		this.all_admins = all_admins;
	}
	public _admin_model() {
		// TODO Auto-generated constructor stub
	}
	
}
