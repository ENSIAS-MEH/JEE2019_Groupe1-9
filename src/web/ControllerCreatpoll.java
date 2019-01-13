package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Choice;
import entities.Poll;
import metier.implPoll;

/**
 * Servlet implementation class ControllerCreatpoll
 */
@WebServlet("/ControllerCreatpoll")
public class ControllerCreatpoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCreatpoll() {
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
		System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo2");
		//doGet(request, response);
		System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo3");
		Modelcreatepoll model1 = new Modelcreatepoll();
		request.setAttribute("model1", model1);
		System.out.println("helloooo1");
		
		String action =request.getParameter("actionn");
		System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo4");
		if(action!=null) {
			System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo5");
		if(action.equals("create")) {
			//poll
			System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo6");
		model1.getPoll().setCategory(request.getParameter("category"));
		model1.getPoll().setDescription(request.getParameter("description"));
		System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo7");
		model1.getPoll().setDuration(Integer.parseInt(request.getParameter("duration")));
		model1.getPoll().setType(request.getParameter("type"));
		model1.getPoll().setUserId(1);
		model1.setPoll(model1.getPoll());
		implPoll pp=new implPoll();
		pp._create_poll(model1.getPoll());
		metier.interfacePoll._create_poll(model1.getPoll());
		metier.interfacePoll._create_poll(new Poll(8,request.getParameter("description"),Integer.parseInt(request.getParameter("duration")),request.getParameter("category"),1,request.getParameter("type")));
		System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooooooooooo8");
		System.out.println(request.getParameter("description"));
		//choice
		model1.getChoice().setDescription(request.getParameter("option[]"));
		model1.getChoice().setNumberOfVoters(0);
		model1.getChoice().setPollId(model1.getPoll().getPollId());
		model1.getChoice().setChoiceId(1);
		metier.interfaceChoice._add_choice(model1.getChoice());
		
		
		
		
		
		//request.getRequestDispatcher("CreatePoll.jsp").forward(request, response);
		}
		}	
		request.getRequestDispatcher("CreatePoll.jsp").forward(request, response);
	}

}
