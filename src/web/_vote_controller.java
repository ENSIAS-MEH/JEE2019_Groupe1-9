package web;

import entities._vote;
import metier._implChoice;
import metier._implVote;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "_vote_controller",urlPatterns = {"*.vote"})
public class _vote_controller  extends HttpServlet {

    _implVote _vote_dao;
    _implChoice choice_dao;

    @Override
    public void init() throws ServletException {
        super.init();
        _vote_dao= new _implVote();
        choice_dao = new _implChoice();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        // todo add the new vote to the choice
        // todo display the poll results
        //
        // this servlet  will add new vote of the user and it will send the user to poll results where he can
        //see the final result of the poll and som statistics of the poll
        String path = request.getServletPath();
        System.out.println("this is the path :"+path);
        System.out.println("You are inside the vote controller ");
        String user_choice = request.getParameter("answer");
        int choice_id = Integer.parseInt(user_choice);
        HttpSession ses = request.getSession();
        int _dis_user_id = (int) request.getSession(false).getAttribute("user_id");
        int current_poll = (int) request.getSession(false).getAttribute("curr_poll");
        System.out.println("the poll id :"+current_poll);
        _vote new_vote = new _vote("default",1,choice_id);
        choice_dao._vote(choice_id);
        response.sendRedirect("/Azerf_Poll_war_exploded/"+current_poll+"/result.display");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
