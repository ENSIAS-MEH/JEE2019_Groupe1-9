package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier._user_dao_impl;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/**
 * Servlet implementation class _controler_forgot
 */
@WebServlet(name = "_controler_forgot",urlPatterns = {"*.forgot"})

public class _controler_forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _controler_forgot() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		_model_forgot model1 = new _model_forgot();
		request.setAttribute("model1", model1);
		
		String action =request.getParameter("token");
		
		if(action!=null) {
			if(action.equals("reset")) {
		model1.set_receiver_email_iD(request.getParameter("email"));
		String new_password=model1.generate(8);
		model1.set_email_body("voici votre nouveau mdp:  "+new_password);
		model1._send_email(model1.get_receiver_email_iD(), model1.get_email_subject(), model1.get_email_body());
		_user_dao_impl impl = new _user_dao_impl();
		impl._modify_password(new_password, request.getParameter("email"));
		
			}
		}
		//response.sendRedirect("user/forgot.jsp");
		request.getRequestDispatcher("forgot.jsp").forward(request, response);
	}

}
