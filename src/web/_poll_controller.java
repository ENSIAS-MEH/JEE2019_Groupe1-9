package web;

//import com.mysql.cj.Session;

import entities._choice;
import entities._poll;
import entities._user;
import metier._implChoice;
import metier._implPoll;
import metier._interfaceChoice;
import metier._interfacePoll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "_poll_controller",urlPatterns = {"*.poll"})

//the path is /user/[the thing you search for].poll

public class _poll_controller extends HttpServlet {

    _implPoll _new_poll_imp;
    _implChoice _new_choice;

    @Override
    public void init() throws ServletException {
        super.init();
        _new_poll_imp = new _implPoll();
        _new_choice = new _implChoice();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        HttpSession ses = request.getSession();
        int _dis_user_id = (int) request.getSession(false).getAttribute("user_id");
//        System.out.println("here is teh id "+_dis_user_id);
        String path = request.getServletPath();

        //the user is trying to create a poll
        if (path.equals("/user/create.poll")){

            // get the Poll data from the JSP
            _poll _new_poll = new _poll();
            _new_poll.set_userId(_dis_user_id);
            _new_poll.set_description(request.getParameter("question"));
            java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
            _new_poll.set_date(sqlDate);
            String expires = request.getParameter("expires");
            long _expires_date = 0;
            try {
                _expires_date=  new SimpleDateFormat("MM/dd/yyyy").parse(expires).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date  _sql_date_eaxpires  = new java.sql.Date(_expires_date);
            _new_poll.set_expires(_sql_date_eaxpires);
            _new_poll.set_category("No category chosen");

            String [] options = request.getParameterValues("option[]");


            //add the new poll to the database and get it id of the poll
            System.out.println("this is the poll infos :  "+_new_poll.toString());
            _new_poll_imp._create_poll(_new_poll);
            int _the_poll = _new_poll_imp._last_poll_for_user(_new_poll.get_userId());
            System.out.println("this is after creating the account :"+_the_poll);
            ses.setAttribute("last_poll_id",_the_poll);

            // this is the poll options you add it to the choice table
            _choice _the_answer = new _choice();
            _the_answer.set_pollId(_the_poll);
            for(String option : options){
                _the_answer.set_description(option);
                _new_choice._add_choice(_the_answer);
            }

            //send to display the poll already created

            response.sendRedirect("/Azerf_Poll_war_exploded/"+_the_poll+"/poll.display");


        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }




}
