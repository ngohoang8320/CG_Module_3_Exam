package service;

import dao.StudentDAO;
import model.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAll {
    StudentDAO studentDAO = new StudentDAO();

    public void showAll(HttpServletRequest request) {
        List<Student> studentList = studentDAO.getAll();
        request.setAttribute("studentList",
                studentList);
    }
}
