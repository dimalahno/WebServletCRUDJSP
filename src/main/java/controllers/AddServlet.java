package controllers;

import entity.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private final String ADD_AND_SAVE = "\\adduser.jsp";
    private UserService userService;

    public AddServlet() {
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(ADD_AND_SAVE);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        User user = new User(name, age, email, role);
        userService.addUserService(user);
        response.sendRedirect("view");
    }
}
