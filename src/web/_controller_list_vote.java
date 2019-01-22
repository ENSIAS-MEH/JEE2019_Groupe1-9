package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities._poll;
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
		String action =request.getParameter("action");
		if(action!=null) {
			
		if(action.equals("search")) {
			model2.setType(request.getParameter("type"));
			_implPoll pollimplement=new _implPoll();
			model2.setListepoll(pollimplement._search_vote_by_Type(model2.getType()));
			ArrayList<_poll> listepoll = model2.getListepoll();
			request.setAttribute("listepoll", listepoll);
		
		
		
		
		
		
		
		
		}
		}
		request.getRequestDispatcher("pollListAndVote.jsp").forward(request, response);
	}

}
