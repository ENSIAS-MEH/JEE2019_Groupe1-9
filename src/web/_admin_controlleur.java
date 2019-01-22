package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.*;
import metier.*;
@WebServlet(name="c_admin" ,urlPatterns="*.admin")
public class _admin_controlleur extends HttpServlet{
	_user_dao _user_metier;
	_interfaceVote _vote_metier;
	_interfacePoll _poll_metier;
	_interfaceChoice _choice_metier;
	_interfaceAdmin _admin_metier;
	
@Override
public void init() throws ServletException {
	_user_metier = new _user_dao_impl();
	_vote_metier = new _implVote();
	_poll_metier = new _implPoll();
	_choice_metier = new _implChoice();
	_admin_metier = new _implAdmin();
	super.init();
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String path =req.getServletPath();
	if(path.equals("/dashboard.admin")) 
	{
		_user_model user_model = new _user_model();
		_poll_model poll_model = new _poll_model();
		user_model.setNumber_of_users(_user_metier._get_number_of_users());
		user_model.setRecent_users(_user_metier._get_recent_users(5));
		poll_model.setRecent_polls(_poll_metier._get_recent_polls(5));
		poll_model.setNumber_of_polls(_poll_metier._get_number_of_polls());
		req.setAttribute("user_model", user_model);
		req.setAttribute("poll_model", poll_model);
		req.setAttribute("poll_metier", _poll_metier);
		req.getRequestDispatcher("admin_dashboard.jsp").forward(req, resp);

	}
	else if(path.equals("/users.admin")) 
	{
		_user_model user_model = new _user_model();
		_poll_model poll_model = new _poll_model();
		user_model.setNumber_of_users(_user_metier._get_number_of_users());
		user_model.setAll_users(_user_metier._get_all_users());
		poll_model.setNumber_of_polls(_poll_metier._get_number_of_polls());
		req.setAttribute("user_model", user_model);
		req.setAttribute("poll_model", poll_model);
		req.setAttribute("poll_metier", _poll_metier);
		req.getRequestDispatcher("admin_users.jsp").forward(req, resp);

	}
	else if(path.equals("/polls.admin")) 
	{
		_user_model user_model = new _user_model();
		_poll_model poll_model = new _poll_model();
		user_model.setNumber_of_users(_user_metier._get_number_of_users());
		poll_model.setAll_polls(_poll_metier._get_all_polls());
		poll_model.setNumber_of_polls(_poll_metier._get_number_of_polls());
		req.setAttribute("user_model", user_model);
		req.setAttribute("poll_model", poll_model);
		req.setAttribute("poll_metier", _poll_metier);
		req.getRequestDispatcher("admin_polls.jsp").forward(req, resp);

	}
	else if(path.equals("/settings.admin")) 
	{
		_user_model user_model = new _user_model();
		_poll_model poll_model = new _poll_model();
		user_model.setNumber_of_users(_user_metier._get_number_of_users());
		//poll_model.setAll_polls(_poll_metier._get_all_polls());
		poll_model.setNumber_of_polls(_poll_metier._get_number_of_polls());
		req.setAttribute("user_model", user_model);
		req.setAttribute("poll_model", poll_model);
		req.setAttribute("poll_metier", _poll_metier);
		req.getRequestDispatcher("admin_setting.jsp").forward(req, resp);

	}
	else if(path.equals("/users_check.admin")) 
	{
		int _id = Integer.parseInt(req.getParameter("id"));
		_user_model user_model = new _user_model();
		_poll_model poll_model = new _poll_model(); 
		// get user to check out
		_user user = _user_metier._get_user_by_id(_id);
		System.out.println(user);
		user_model.setUser_id(_id);
		user_model.setNumber_of_users(_user_metier._get_number_of_users());
		user_model.setAll_votes_of_users(_user_metier._get_vote_of_user(user));
		user_model.setAll_polls_of_user(_user_metier._get_poll_of_user(user));
		user_model.setUser(user);
		poll_model.setNumber_of_polls(_poll_metier._get_number_of_polls());
		req.setAttribute("user_model", user_model);
		req.setAttribute("poll_model", poll_model);
		req.setAttribute("poll_metier", _poll_metier);
		req.getRequestDispatcher("admin_users_display.jsp").forward(req, resp);

	}
	else if(path.equals("/users_delete.admin")) 
	{
		int _id = Integer.parseInt(req.getParameter("id"));
		
		// get user to delete
		_user user = _user_metier._get_user_by_id(_id);
		System.out.println(user);
		_user_metier._delete_user(user);
		
		_user_model user_model = new _user_model();
		_poll_model poll_model = new _poll_model();
		
		user_model.setNumber_of_users(_user_metier._get_number_of_users());
		poll_model.setNumber_of_polls(_poll_metier._get_number_of_polls());
		user_model.setAll_users(_user_metier._get_all_users());
		req.setAttribute("user_model", user_model);
		req.setAttribute("poll_model", poll_model);
		req.setAttribute("poll_metier", _poll_metier);
		resp.sendRedirect("users.admin");

	}
	
	else if(path.equals("/poll_check.admin")) 
	{
		int _poll_id = Integer.parseInt(req.getParameter("id"));
		_user_model user_model = new _user_model();
		_poll_model poll_model = new _poll_model();
		_poll poll = _poll_metier._get_poll_by_id(_poll_id);
		poll_model.setPoll(poll);
		poll_model.setPoll_id(_poll_id);
		ArrayList<_choice> _choices_poll = _poll_metier._get_choice_for_poll(poll);
		poll_model.setAll_choices_of_poll(_choices_poll);
		int _choice_id =Integer.parseInt(req.getParameter("choice_id"));
		_choice choice = _choice_metier._get_choice_by_id(_choice_id);
		ArrayList<_user> voters =_choice_metier._list_of_voters(choice);
		System.out.println(voters);
		poll_model.setVoters(voters);
		// get user to check out
		
		user_model.setNumber_of_users(_user_metier._get_number_of_users());
		poll_model.setNumber_of_polls(_poll_metier._get_number_of_polls());
		req.setAttribute("user_model", user_model);
		req.setAttribute("poll_model", poll_model);
		req.setAttribute("poll_metier", _poll_metier);
		req.getRequestDispatcher("admin_poll_display.jsp").forward(req, resp);

	}
	
		/*
		 * else if(path.equals("/poll_delete.admin")) { int _id =
		 * Integer.parseInt(req.getParameter("id"));
		 * 
		 * // get user to delete _user user = _user_metier._get_user_by_id(_id);
		 * System.out.println(user); _user_metier._delete_user(user);
		 * 
		 * _user_model user_model = new _user_model(); _poll_model poll_model = new
		 * _poll_model();
		 * 
		 * user_model.setNumber_of_users(_user_metier._get_number_of_users());
		 * poll_model.setNumber_of_polls(_poll_metier._get_number_of_polls());
		 * user_model.setAll_users(_user_metier._get_all_users());
		 * req.setAttribute("user_model", user_model); req.setAttribute("poll_model",
		 * poll_model); req.setAttribute("poll_metier", _poll_metier);
		 * resp.sendRedirect("polls.admin");
		 * 
		 * }
		 */
	
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}
}
