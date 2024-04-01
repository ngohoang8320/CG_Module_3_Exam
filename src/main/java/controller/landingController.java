package controller;

import dao.StudentDAO;
import model.Student;
import service.AddStudent;
import service.DeleteStudent;
import service.EditStudent;
import service.ShowAll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "landingcontroller", value = "/home")
public class landingController extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = "";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        switch (action) {
            case "addition":
                StudentDAO studentDAO = new StudentDAO();
                List<String> classList = studentDAO.getClasses();
                request.setAttribute("classList",
                        classList);
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = "";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        StudentDAO studentDAO = new StudentDAO();
        switch (action) {
            case "addition":
                AddStudent addStudent = new AddStudent();
                addStudent.add(request);
                response.sendRedirect("home");
                break;
            case "delete":
                DeleteStudent deleteStudent = new DeleteStudent();
                deleteStudent.delete(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("home");
                break;
            case "edit":
                List<String> classList = studentDAO.getClasses();
                request.setAttribute("classList",
                        classList);
                EditStudent editStudent = new EditStudent();
                Student student = editStudent.findToEdit(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("student",
                        student);
                request.getRequestDispatcher("editPage.jsp").forward(request,
                        response);
                break;
            case "update":
                studentDAO.update(request);
                response.sendRedirect("home");
                break;
            default:

        }
    }
}