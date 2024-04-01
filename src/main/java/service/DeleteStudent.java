package service;

import dao.StudentDAO;

public class DeleteStudent {
    StudentDAO studentDAO = new StudentDAO();

    public void delete(int studentId) {
        studentDAO.delete();
    }
}
