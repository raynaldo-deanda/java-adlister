package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
//import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        // TODO: show the registration form
        if(request.getSession().getAttribute("user") != null)
        {
            response.sendRedirect("/profile");
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/ads/register.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // TODO: ensure the submitted information is valid
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(username == null || email == null || password == null)  {
            response.sendRedirect("/register");
            return;
        }
        if(username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("/register");
            return;
        }



        // TODO: create a new user based off of the submitted information
        DaoFactory.getUsersDao().insert(new User(username, email, password));



        // TODO: if a user was successfully created, send them to their profile

        response.sendRedirect("/login");

    }
}