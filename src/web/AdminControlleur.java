package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.*;
@WebServlet(name="Cadmin" ,urlPatterns="*.admin")
public class AdminControlleur extends HttpServlet{
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
	
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}
}
