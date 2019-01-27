package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities._number_of_voters;
import entities._poll;
import metier._implPoll;

/**
 * Servlet implementation class Controllerdashboard
 */
@WebServlet("/Controllerdashboard")
public class _controller_dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _controller_dashboard() {
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
		_model_dashboard model1= new _model_dashboard();
		request.setAttribute("model1", model1);
		String action =request.getParameter("action"); 
		if(action!=null) {
			if(action.equals("activepoll")) {
				_implPoll pollimplement=new _implPoll();
				//hna tu dois passer la variable de session 3la hsab achnou smitiha mais dirha f blast 1 had 1 tantesti bih
				model1.setListepoll(pollimplement._search_vote_by_userid(1));
				ArrayList<_poll> listepoll = model1.getListepoll();
				//request.setAttribute("listepoll", listepoll);
				model1.setMylist(listepoll);
				ArrayList<_number_of_voters> listepoll1 = model1.getMylist();
				request.setAttribute("listepoll1", listepoll1);
				
				
				
			}
			
			
		}
	
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

}
