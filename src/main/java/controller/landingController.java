package controller;

import service.AddStudent;
import service.ShowAll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "landingcontroller", value = "/home")
public class landingController extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        String action = "";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        switch (action) {
            case "addition":
                request.getRequestDispatcher("addPage.jsp").forward(request,
                        response);
                break;
            default:
                ShowAll showAll = new ShowAll();
                showAll.showAll(request);
                request.getRequestDispatcher("landingPage.jsp").forward(request,
                        response);
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        String action = "";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        switch (action) {
            case "addition":
                AddStudent addStudent = new AddStudent();
                addStudent.add(request);
                response.sendRedirect("home");
                break;
            default:

        }
    }
}