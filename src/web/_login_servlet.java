package web;

import com.sun.xml.internal.bind.v2.TODO;
import entities._admin;
import entities._user;
import metier._implAdmin;
import metier._user_dao;
import metier._user_dao_impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "_login_serv",urlPatterns = {"*.login"})
public class _login_servlet extends HttpServlet {

    _user_dao _new_user_dao;
    _implAdmin new_admin_dao;
    @Override
    public void init() throws ServletException {
        super.init();
        _new_user_dao = new _user_dao_impl();
        new_admin_dao= new _implAdmin();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses = req.getSession();
        _user _check_user = new _user();
        String path = req.getServletPath();
        System.out.println(path);

        //if the user is trying to login the servlet will take it from here

        if (path.equals("/user.login") || path.equals("/user/user.login")){
            String _email = req.getParameter("email");
            System.out.println("here is your email :"+_email);
            String _password = req.getParameter("password");
            _check_user.set_email(_email);
            _check_user.set_password(_password);
            _user _check_user2 = (_user) _new_user_dao._login(_check_user);
            //check if the user is valid
            if (_check_user2!=null){
                System.out.println("This is the right person");
                ses.setAttribute("_current_user",_check_user2);
                ses.setAttribute("user_id",_check_user2.get_id());
                if (path.equals("/user.login")) {
                    resp.sendRedirect("user/dashboard.jsp");
                }else resp.sendRedirect("dashboard.jsp");
            }else {
                //if the user is not valid we redirect the user to the login page
                System.out.println("this is a null one ");
                if (path.equals("/user.login")) {
                    resp.sendRedirect("index.jsp");
                }else resp.sendRedirect("login.jsp");
            }
        }else if (path.equals("/user/register.login")){ //this one if we have new user who's trying to register
            String _first_name = req.getParameter("firstname");
            String _last_name = req.getParameter("lastname");
            String _email = req.getParameter("email");
            String _password = req.getParameter("password");
            String _c_password = req.getParameter("cpassword");
            if (_password.equals(_c_password)){
                _check_user.set_first_name(_first_name);
                _check_user.set_last_name(_last_name);
                _check_user.set_email(_email);
                _check_user.set_password(_password);
                //add the new user
                _new_user_dao._add_user(_check_user);
            }
            _user _check_user2 = (_user) _new_user_dao._login(_check_user);
            if (_check_user2!=null){
                System.out.println("This is the right person");
                ses.setAttribute("_current_user",_check_user2);
                ses.setAttribute("user_id",_check_user2.get_id());
                resp.sendRedirect("dashboard.jsp");
                //PrintWriter out = resp.getWriter();
                //req.setAttribute("user",_check_user);
                //req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else {
                System.out.println("this is a null one ");
                resp.sendRedirect("register.jsp");
            }
        }else if (path.equals("/admin.login") || path.equals("/admin/admin.login")){
            _admin curr_admin=new _admin();
            String _email = req.getParameter("email");
            System.out.println("here is your email :"+_email);
            String _password = req.getParameter("password");
            curr_admin.set_email(_email);
            curr_admin.set_password(_password);
            _admin _check_admin2 = (_admin)new_admin_dao._login(curr_admin);
            System.out.println("this is your admin "+_check_admin2.toString());
            //check if the user is valid
            if (_check_admin2.get_email()!=null){
                System.out.println("This is the right person");
                ses.setAttribute("_current_admin",_check_admin2);
                ses.setAttribute("admin_id",_check_admin2.get_id());
                resp.sendRedirect("../dashboard.admin");
            }else {
                resp.sendRedirect("login.jsp");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
