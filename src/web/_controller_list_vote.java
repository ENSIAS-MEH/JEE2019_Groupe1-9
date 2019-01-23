package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities._choice;
import entities._poll;
import metier._implChoice;
import metier._implPoll;

/**
 * Servlet implementation class _controller_list_vote
 */
@WebServlet("/_controller_list_vote")
public class _controller_list_vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _controller_list_vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		_model_list_vote model2 = new _model_list_vote();
		request.setAttribute("model2", model2);
		String action =request.getParameter("actionn");
		if(action!=null) {
			
		if(action.equals("search")) {
			model2.setType(request.getParameter("type"));
			_implPoll pollimplement=new _implPoll();
			model2.setListepoll(pollimplement._search_vote_by_Type(model2.getType()));
			ArrayList<_poll> listepoll = model2.getListepoll();
			request.setAttribute("listepoll", listepoll);
		
		
		
		
		
		
		
		
		}
		//else if(action.equals("choice"))
		else
		
		
		{
			//hna les choices derthoum taybdaw b '-' baxh nfere9 ma bine choice ou poll bach nfer9 traitement hit la kan choice
			//y9der yvoti ou ila kan poll ty3tih les choices dial hadak poll 
			//ou f jsp bdelt l value dial choice dertha bdarora tatbda b '-' ze3ma tanzidha l ga3 choices... xD
			String description= request.getParameter("actionn");
		char lettre = description.charAt(0);
		if(lettre=='-') {
			System.out.println("yeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah");
			
			
			
			
		}
		else {
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1");
			int myid =Integer.parseInt(request.getParameter("actionn"));
			//a
			//String id =request.getParameter("id");
			//System.out.println(id);
			//int numId = ((Integer) request.getAttribute("id"));
			System.out.println(myid);
			_implChoice choiceimplement=new _implChoice();
			model2.setListechoice(choiceimplement._search_choice_for_poll(myid));
			ArrayList<_choice> listechoice = model2.getListechoice();
			request.setAttribute("listechoice", listechoice);
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2");
			
			
			
		}
			
			
		}
		}
		request.getRequestDispatcher("pollListAndVote.jsp").forward(request, response);
	}

}
