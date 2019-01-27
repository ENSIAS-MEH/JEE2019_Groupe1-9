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
@WebServlet(name="Controllerdashboard",urlPatterns = "*.user")
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
		//doPost(request,response);
		_model_dashboard model1= new _model_dashboard();
		request.setAttribute("model1", model1);
		
		
		String path = request.getServletPath();
		System.out.println(path);
		if (path.equals("/delete.user")) {
			System.out.println("1");
			String _id1 =request.getParameter("id");	
			int _id = Integer.parseInt(_id1);
			System.out.println(_id);
			_implPoll implpoll=new _implPoll();
			implpoll.delete_poll(_id);
			System.out.println("3");
			//response.sendRedirect("delete.user");
			
		}
		
		String action =request.getParameter("action"); 
		if(path.equals("/activepoll.user")) {
			
				_implPoll pollimplement=new _implPoll();
				//hna tu dois passer la variable de session 3la hsab achnou smitiha mais dirha f blast 1 had 1 tantesti bih
				model1.setListepoll(pollimplement._search_vote_by_userid(1));
				ArrayList<_poll> listepoll = model1.getListepoll();
				//request.setAttribute("listepoll", listepoll);
				model1.setMylist(listepoll);
				ArrayList<_number_of_voters> listepoll1 = model1.getMylist();
				request.setAttribute("listepoll1", listepoll1);
					
				
				
			
			
			
		}
		if (path.equals("/settings.user")) {
			System.out.println("22");
			request.getRequestDispatcher("settings.jsp").forward(request, response);
			
			
		}
		
		
		
		
		
		
		
	
	
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
