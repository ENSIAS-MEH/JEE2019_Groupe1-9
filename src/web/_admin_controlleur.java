package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}
}
