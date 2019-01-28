package web;

import entities._choice;
import entities._poll;
import metier._implChoice;
import metier._implPoll;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "poll_display",urlPatterns = {"*.display"})

public class poll_display  extends HttpServlet {

    _implPoll poll_dao;
    _implChoice choice_dao;

    @Override
    public void init() throws ServletException {
        super.init();
        poll_dao= new _implPoll();
        choice_dao= new _implChoice();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // todo check if the user did vote before showing them the poll
        //this servlet is to display the poll so the user can vote or the poll after the user did vote
        // so he can see the result of the poll
        HttpSession ses = request.getSession();
        String path = request.getServletPath();
        System.out.println(path);
        String[] da_splited_path = path.split("/");
        //get all the needed info to display in the poll
        int da_id = Integer.parseInt(da_splited_path[1]);
        ses.setAttribute("curr_poll",da_id);
        _poll da_poll = poll_dao._get_poll_by_id(da_id);
        if(da_poll.get_expires().getTime() >= System.currentTimeMillis()){
            System.out.println(""+da_poll.get_expires());
            System.out.println("you can use the poll ok");
            String poll_url ="http://localhost:8080/Azerf_Poll_war_exploded"+da_splited_path[1]+"/poll.display";
            ArrayList<_choice> list_choices= choice_dao.get_choices_by_poll_id(da_poll.get_pollId());
            request.setAttribute("question",da_poll);
            request.setAttribute("choices",list_choices);
            request.setAttribute("urlPoll",poll_url);
            //
            if(da_splited_path[2].equals("poll.display")){
                request.getRequestDispatcher("../user/display_poll.jsp").forward(request, response);
            }else if (da_splited_path[2].equals("result.display")){
                int total_voters=0;
                for (_choice choice :list_choices) {
                    total_voters+= choice.get_number_of_voters();
                }
                request.setAttribute("total_voters",total_voters);
                request.getRequestDispatcher("../user/result_display.jsp").forward(request, response);
            }



        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
    }


}
