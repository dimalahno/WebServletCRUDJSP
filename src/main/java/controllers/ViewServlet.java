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
import java.util.List;

@WebServlet("/view")
public class ViewServlet extends HttpServlet{
    private final String LIST_USER = "\\listuser.jsp";
    private UserService userService;

    public ViewServlet() {
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.getAllUsersService();
        request.setAttribute("users", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_USER);
        dispatcher.forward(request, response);
    }
}
