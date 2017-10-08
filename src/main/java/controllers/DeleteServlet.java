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

@WebServlet("delete")
public class DeleteServlet extends HttpServlet {
    private final String DELETE = "\\deleteuser.jsp";
    private UserService userService;

    public DeleteServlet() {
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String varId = request.getParameter("id");
        int id = Integer.parseInt(varId);

        User user = userService.getUserByIdService(id);
        String varName = user.getName();
        Integer varAge = user.getAge();
        String varEmail = user.getEmail();
        String varRole = user.getRole();

        request.setAttribute("uId", varId);
        request.setAttribute("uName", varName);
        request.setAttribute("uAge", varAge);
        request.setAttribute("uEmail", varEmail);
        request.setAttribute("uRole", varRole);

        RequestDispatcher dispatcher = request.getRequestDispatcher(DELETE);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        userService.deleteUserService(id);
        response.sendRedirect("view");
    }
}

