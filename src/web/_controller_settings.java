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
		int _dis_user_id = (int) request.getSession(false).getAttribute("user_id");
		_model_settings model1 = new _model_settings();
		request.setAttribute("model1", model1);

		String action =request.getParameter("update");
		_user_dao_impl impl = new _user_dao_impl();
		// todo hna tu dois ajouter la variable de session f blast 1
		_user user1 =impl._get_user_by_id(_dis_user_id);
		request.setAttribute("user",user1);
		String firstname1=user1.get_first_name();
		request.setAttribute("firstname1",firstname1);
		String lastname1=user1.get_last_name();
		request.setAttribute("lastname1",lastname1);
		String gender1=user1.get_gender();
		request.setAttribute("gender1",gender1);
		String birth1=user1.get_birth_date();
		request.setAttribute("birth1",birth1);
		String email1=user1.get_email();
		request.setAttribute("email1",email1);
		String nationality1=user1.get_nationality();
		request.setAttribute("nationality1",nationality1);
		String password1=user1.get_password();
		request.setAttribute("password1",password1);
		String img1=user1.get_profile_img();
		request.setAttribute("img1",img1);
		model1.setUser(user1);
		_user user =model1.getUser();
		request.setAttribute("user1", user1);
		request.setAttribute("model1", model1);

		_user_dao_impl userimpl =new _user_dao_impl();
		userimpl._modify_user(model1.getUser());




		System.out.println(action);
		if(action!=null) {
			System.out.println("aaaaaaaaaaaaaaaaaaa31");
			if(action.equals("up")) {
				System.out.println("aaaaaaaaaaaaaaaaaaa3");
				//_user user =new _user();
				model1.setUser(user1);
				model1.getUser().set_first_name( request.getParameter("firstname"));
				model1.getUser().set_last_name(request.getParameter("lastname"));
				model1.getUser().set_birth_date(request.getParameter("birthdate"));
				model1.getUser().set_gender(request.getParameter("gender"));
				model1.getUser().set_nationality(request.getParameter("nationality"));
				model1.getUser().set_profile_img(request.getParameter("image"));
				model1.getUser().set_email(request.getParameter("email"));
				model1.getUser().set_password(request.getParameter("password"));
				// todo ici tu dois ajouter hadik la variable de session f blast 1 hit had wa7ed ghir tantesti bih
				model1.getUser().set_id(_dis_user_id);
				// todo had isactive nsit wach kandirouha 0 oula 1 ze3ma achnahia la valeur par defaut
				model1.getUser().set_is_active(1);
				System.out.println(request.getParameter("password"));
				System.out.println(request.getParameter("firstname"));
				request.setAttribute("user1", user1);
				//_user_dao_impl userimpl =new _user_dao_impl();
				userimpl._modify_user(model1.getUser());
			}

		}

		request.getRequestDispatcher("settings.jsp").forward(request, response);

	}

}
