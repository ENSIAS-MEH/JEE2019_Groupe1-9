package web;

import java.io.IOException;

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
 * Servlet implementation class ControllerCreatpoll
 */
@WebServlet("/ControllerCreatpoll")
public class _controller_creat_poll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _controller_creat_poll() {
        super(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo1");
		//request.getRequestDispatcher("CreatePoll.jsp").forward(request, response);
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo2");
		//doGet(request, response);
		//System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo3");
		_model_create_poll model1 = new _model_create_poll();
		request.setAttribute("model1", model1);
		//System.out.println("helloooo1");
		
		String action =request.getParameter("actionn");
		//System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo4");
		if(action!=null) {
			//System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo5");
		if(action.equals("create")) {
			//poll
			//System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo6");
		model1.getPoll().set_category(request.getParameter("category"));
		model1.getPoll().set_description(request.getParameter("description"));
		//System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo7");
		model1.getPoll().set_duration(Integer.parseInt(request.getParameter("duration")));
		model1.getPoll().set_type(request.getParameter("type"));
		model1.getPoll().set_user_id(1);
		model1.setPoll(model1.getPoll());
		_implPoll pp=new _implPoll();
		pp._create_poll(model1.getPoll());
		//metier.interfacePoll._create_poll(model1.getPoll());
		//metier.interfacePoll._create_poll(new Poll(8,request.getParameter("description"),Integer.parseInt(request.getParameter("duration")),request.getParameter("category"),1,request.getParameter("type")));
		//System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo8");
		System.out.println(request.getParameter("description"));
		//choice
		model1.getChoice().set_description(request.getParameter("option[]"));
		model1.getChoice().set_number_of_voters(0);
		model1.getChoice().set_pollId(pp._last_poll_for_user(model1.getPoll().get_user_id()).get_pollId());
		model1.getChoice().set_choiceId(1);
		_implChoice oo=new _implChoice();
		oo._add_choice(model1.getChoice());
		
		//pp._last_poll_for_user(model1.getPoll().getUserId()).getPollId();
		//System.out.println(model1.getPoll().getPollId());
		//metier.interfaceChoice._add_choice(model1.getChoice());
		
		
		
		
		
		//request.getRequestDispatcher("CreatePoll.jsp").forward(request, response);
		}
		}	
		request.getRequestDispatcher("CreatePoll.jsp").forward(request, response);
	}

}
