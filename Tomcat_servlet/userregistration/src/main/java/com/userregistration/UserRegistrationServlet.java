package com.userregistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/register-user")
public class UserRegistrationServlet extends HttpServlet {
    private static final ArrayList<User> users = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(Arrays.toString(users.toArray()));
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            out.println("<h1>error: invalid inputs</h1>");
            out.close();
            return;
        }
        users.add(new User(username, email, password));
        request.setAttribute("username", username);
        request.setAttribute("email", email);

        request.getRequestDispatcher("success.jsp").forward(request, response);
    }
}