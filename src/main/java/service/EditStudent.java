package service;

import dao.StudentDAO;
import model.Student;

public class EditStudent {
    public Student findToEdit(int id) {
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.chooseStudent(id);
        return student;
    }
}
