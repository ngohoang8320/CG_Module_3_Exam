package dao;

import model.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> getAll();

    void add(Student student);

    void edit();

    void delete();

    void search();
}