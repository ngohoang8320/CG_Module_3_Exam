package service;

import dao.StudentDAO;
import model.Student;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class AddStudent {
    StudentDAO studentDAO = new StudentDAO();

    public void add(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthBf = request.getParameter("birth");
        String birthAf = birthBf.split("/")[2] + "-" + birthBf.split("/")[1] + "-" + birthBf.split("/")[0];
        LocalDate birthFormatted = LocalDate.parse(birthAf);
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String className = request.getParameter("class");

        Student student = new Student(name,
                birthFormatted,
                email,
                address,
                phone,
                className);

        studentDAO.add(student);
    }
}
