package service;

import dao.StudentDAO;
import model.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SearchStudent {
    public void foundStudents(HttpServletRequest request) {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.search(request.getParameter("searchWord"));
        request.setAttribute("studentList",
                studentList);
    }
}
