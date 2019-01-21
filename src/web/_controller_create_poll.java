package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
//@WebServlet(name = "_controller_create_poll",urlPatterns = {"*.poll"})

public class _controller_create_poll extends HttpServlet {

   /* @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //todo create new poll and get it's id
        //todo create the choices
        //todo modify database to control the theme of the poll
        String path = request.getServletPath();
        System.out.println(path);
        System.out.println("I'm here tho");
        String [] options = request.getParameterValues("option[]");
        for(String option : options){
            System.out.println(option);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        super.init();
    }*/
}
