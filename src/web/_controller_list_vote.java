package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities._choice;
import entities._poll;
import entities._vote;
import metier._implChoice;
import metier._implPoll;
import metier._implVote;

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
		//HttpSession session =request.getSession();
		//int idpoll = (int) session.getAttribute("myid");
		//request.setAttribute("idpoll", idpoll);
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
		String action1 =request.getParameter("action");
		String action2 =request.getParameter("action2");
		if(action!=null) {
			
		if(action.equals("search")) {
			model2.setType(request.getParameter("type"));
			_implPoll pollimplement=new _implPoll();
			model2.setListepoll(pollimplement._search_vote_by_Type(model2.getType()));
			ArrayList<_poll> listepoll = model2.getListepoll();
			request.setAttribute("listepoll", listepoll);
		}
	//////////////////////////	
			else if(action.equals("mypolls")) {
				//model2.setType(request.getParameter("type"));
				_implPoll pollimplement=new _implPoll();
				//hna tu dois passer la variable de session 3la hsab achnou smitiha mais dirha f blast 1 had 1 tantesti bih
				model2.setListepoll1(pollimplement._search_vote_by_userid(1));
				ArrayList<_poll> listepoll1 = model2.getListepoll1();
				request.setAttribute("listepoll1", listepoll1);
				
				
			}
		
	///////////////////////////	
		
		else
		{
		//a
			String myid1;
			
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1");
			 myid1 =request.getParameter("actionn");
			 //ici pour récupérer la valeur d l id a partir du button cliqué 
			 int i=0;
				char lettre;
				String lettre1="";
				while(true) {
				 lettre= myid1.charAt(i);
				 if(Character.isDigit(lettre)) {
				 lettre1=lettre1+lettre;
				 i++;
				 }
				 else break; 
				}
				int myid = Integer.parseInt(lettre1);
			 ////////
			 
			 
			 model2.setId(myid);
			 model2.setPoll(new _poll(myid));
			 _poll poll =model2.getPoll();
			 System.out.println(model2.getPoll().get_pollId());
			_implChoice choiceimplement=new _implChoice();
			model2.setListechoice(choiceimplement._search_choice_for_poll(myid));
			ArrayList<_choice> listechoice = model2.getListechoice();
			request.setAttribute("listechoice", listechoice);
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2");
			request.setAttribute("poll", poll);
			request.setAttribute("model2", model2);
			
			
			HttpSession session =request.getSession();
			session.setAttribute("myid", myid);
		
		
		}	
		
		}
		
		if(action2!=null) {
			//had la partie pour récupérer l id dial poll hit f submit kaybda b * ou be3dou description dial poll...
			//anas ila knti 9aditi deja l fct li tatrje3 wach kayn vote li 3endou hadak l id d user ou id d poll zid test hna fhad la partie
			String idstring1= request.getParameter("action2");
			
			int i=0;
			char lettre;
			String lettre1="";
			while(true) {
			 lettre= idstring1.charAt(i);
			 if(Character.isDigit(lettre)) {
			 lettre1=lettre1+lettre;
			 i++;
			 }
			 else break; 
			}
			int idpoll = Integer.parseInt(lettre1);
			_implPoll implpoll=new _implPoll();
			implpoll.delete_poll(idpoll);
			
	
			
			
			
			
			
			
		}
		
		System.out.println(model2.getPoll().get_pollId());
		if(action1!=null) {
			HttpSession session =request.getSession();
			int idpoll = (int) session.getAttribute("myid");
			request.setAttribute("idpoll", idpoll);
			System.out.println(idpoll);
			String description= request.getParameter("action");
			char lettre = description.charAt(0);
			
				System.out.println("yeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah");
				
				String type=request.getParameter("typee");
				System.out.println(type);
				String descriptionchoice=description.substring(1);
				//String descriptionchoice=descriptionchoice1.substring(1);
				System.out.println(descriptionchoice);
				_implChoice choiceimplement=new _implChoice();
				System.out.println("aaaaaaaaaaaaaaaaaaaaa");
				System.out.println(model2.getPoll().get_pollId());
				model2.setChoice(choiceimplement._get_choice_bydescription_andpollid(idpoll, descriptionchoice));
				choiceimplement._vote(model2.getChoice());
				_implVote voteimplement=new _implVote();				
				model2.setVote(new _vote(type,1,model2.getChoice().get_choiceId()));
				//h,a je dois ajouter traitement 3la wach kayna deja f la table ou nn bach mayvotich 3la nefs lhaja ktar mn mera
				voteimplement._add_vote(model2.getVote());
				request.setAttribute("model2", model2);
			 
			
		
			
			
			
			
		}
		request.getRequestDispatcher("pollListAndVote.jsp").forward(request, response);
		
	}

}
//ps: hadchi kaaaaaaaaaaaaaaaaaaaaaaaaaaaml hit je savais pas bli submit ta t reloadi la page so les informations tidi3ou donc khas nkhdem b session ou voila le prob résolu
