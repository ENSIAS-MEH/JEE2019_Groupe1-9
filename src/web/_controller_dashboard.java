package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request,response);
		HttpSession ses = request.getSession();
		int _dis_user_id = (int) request.getSession(false).getAttribute("user_id");


		_model_dashboard model1= new _model_dashboard();
		request.setAttribute("model1", model1);
		String path = request.getServletPath();
		System.out.println(path);
		if (path.equals("/user/delete.user")) {
			System.out.println("1");
			String _id1 =request.getParameter("id");	
			int _id = Integer.parseInt(_id1);
			System.out.println(_id);
			_implPoll implpoll=new _implPoll();
			implpoll.delete_poll(_id);
			
			
		}
		
		
		if(path.equals("/user/activepoll.user")) {
				System.out.println("daba dkhelt l if dial /user/activepoll.user ");
				_implPoll pollimplement=new _implPoll();
				// todo hna tu dois passer la variable de session 3la hsab achnou smitiha mais dirha f blast 7 had 7 tantesti bih
				////////////////////
				Date todayDate = new Date();
				model1.setListepoll(pollimplement._search_activevote_by_userid(_dis_user_id,  todayDate));
				ArrayList<_poll> listepoll = model1.getListepoll();
				
				model1.setMylist(listepoll);
				ArrayList<_number_of_voters> listepoll1 = model1.getMylist();
				System.out.println("model m9ad");
				
				request.setAttribute("listepoll1", listepoll1);
				System.out.println("khrejt mn if");
				
	
		}
		
		
		if(path.equals("/user/expiredpoll.user")) {
			System.out.println("daba dkhelt l if dial /user/activepoll.user ");
			_implPoll pollimplement=new _implPoll();
			// todo hna tu dois passer la variable de session 3la hsab achnou smitiha mais dirha f blast 7 had 7 tantesti bih
			
			Date todayDate = new Date();
			model1.setListepoll(pollimplement._search_expiredvote_by_userid(_dis_user_id,  todayDate));
			ArrayList<_poll> listepoll = model1.getListepoll();
			
			model1.setMylist(listepoll);
			ArrayList<_number_of_voters> listepoll1 = model1.getMylist();
			System.out.println("model m9ad");
			
			request.setAttribute("listepoll1", listepoll1);
			System.out.println("khrejt mn if");
			

	}
		
		
		
		
		
		
		
		if(path.equals("/user/dashboard.user")) {
			System.out.println("daba dkhelt l if dial /user/activepoll.user ");
			_implPoll pollimplement=new _implPoll();
			// todo hna tu dois passer la variable de session 3la hsab achnou smitiha mais dirha f blast 7 had 7 tantesti bih
			
			model1.setListepoll(pollimplement._search_vote_by_userid(_dis_user_id));
			ArrayList<_poll> listepoll = model1.getListepoll();
			
			model1.setMylist(listepoll);
			ArrayList<_number_of_voters> listepoll1 = model1.getMylist();
			System.out.println("model m9ad");
			
			request.setAttribute("listepoll1", listepoll1);
			System.out.println("khrejt mn if");
			

	}

		
		
		if (path.equals("/user/settings.user")) {
			System.out.println("22");
//			response.sendRedirect("_controller_settings");
			request.getRequestDispatcher("_controller_settings").forward(request, response);
			
		}
		
		if (path.equals("/user/search.user")) {
			System.out.println("action");
		
			System.out.println("search");
			
			request.getRequestDispatcher("vote.jsp").forward(request, response);
		}
		

	
	
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	 
	 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
