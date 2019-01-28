package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities._user;
import metier._user_dao_impl;

/**
 * Servlet implementation class _controller_settings
 */
@WebServlet("/user/_controller_settings")
public class _controller_settings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _controller_settings() {
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
		_model_settings model1 = new _model_settings();
		request.setAttribute("model1", model1);
		
		String action =request.getParameter("update");
		
		
		
		System.out.println(action);
		if(action!=null) {
			System.out.println("aaaaaaaaaaaaaaaaaaa31");
			if(action.equals("up")) {
				System.out.println("aaaaaaaaaaaaaaaaaaa3");
			_user user =new _user();
			model1.setUser(user);  
			model1.getUser().set_first_name( request.getParameter("firstname"));
			model1.getUser().set_last_name(request.getParameter("lastname"));
			model1.getUser().set_birth_date(request.getParameter("birthdate"));
			model1.getUser().set_gender(request.getParameter("gender"));
			model1.getUser().set_nationality(request.getParameter("nationality"));
			model1.getUser().set_profile_img(request.getParameter("image"));
			model1.getUser().set_email(request.getParameter("email"));
			model1.getUser().set_password(request.getParameter("password"));
			// todo ici tu dois ajouter hadik la variable de session f blast 1 hit had wa7ed ghir tantesti bih
			model1.getUser().set_id(1);
			// todo had isactive nsit wach kandirouha 0 oula 1 ze3ma achnahia la valeur par defaut
			model1.getUser().set_is_active(1);
			System.out.println(request.getParameter("password"));
			System.out.println(request.getParameter("firstname"));
			request.setAttribute("user", user);
			_user_dao_impl userimpl =new _user_dao_impl();
			userimpl._modify_user(model1.getUser());
			}	
		
		}
		
		request.getRequestDispatcher("settings.jsp").forward(request, response);
		
	}

}
