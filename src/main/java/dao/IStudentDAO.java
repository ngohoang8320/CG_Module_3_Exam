package dao;

import model.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IStudentDAO {
    List<Student> getAll();

    void add(Student student);

    void edit();

    void delete(int studentId);

    void search();

    List<String> getClasses();

    Student chooseStudent(int id);

    void update(HttpServletRequest request);
}
