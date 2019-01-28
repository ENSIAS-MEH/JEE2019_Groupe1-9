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
 * Servlet implementation class _controller_vote
 */
@WebServlet("/user/_controller_vote")
public class _controller_vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _controller_vote() {
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
		String i=request.getParameter("type");
		//String action=request.getParameter("action");
		//if(action!=null) {
			
			//if(action.equals("search")) {
		System.out.println("dkhelna l search");
		System.out.println(i);
		 _model_dashboard model1= new _model_dashboard();
		request.setAttribute("model1", model1);
		model1.setType(request.getParameter("type"));
		System.out.println(request.getParameter("type"));
		_implPoll pollimplement=new _implPoll();
		//model1.setListepoll2(pollimplement._search_vote_by_Type(model1.getType()));
		model1.setListepoll2(pollimplement._search_vote_by_Type(i));
		ArrayList<_poll> listepoll2 = model1.getListepoll2();
		request.setAttribute("listepoll2", listepoll2);
		//System.out.println(listepoll2.get(0).get_description());
		
	//}
		//}
		request.getRequestDispatcher("vote.jsp").forward(request, response);}

}
