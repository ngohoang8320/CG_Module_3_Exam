package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private static final String SQL_ADD = "insert into student(studentName, birth, email, address, phoneNumber, className) values (?, ?, ?, ?, ?, ?);";
    private static final String SQL_ALL = "select * from student;";
    private static final String SQL_DELETE = "delete from student where studentId = ?;";

    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ALL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("studentId"));
                String name = rs.getString("studentName");
                String birth = rs.getString("birth");
                LocalDate birthFormatted = LocalDate.parse(birth);
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phoneNumber");
                String className = rs.getString("className");

                Student student = new Student(id,
                        name,
                        birthFormatted,
                        email,
                        address,
                        phone,
                        className);
                studentList.add(student);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void add(Student student) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD)) {
            statement.setString(1,
                    student.getStudentName());
            statement.setString(2,
                    student.getBirth().toString());
            statement.setString(3,
                    student.getEmail());
            statement.setString(4,
                    student.getAddress());
            statement.setString(5,
                    student.getPhone());
            statement.setString(6,
                    student.getClassName());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete(int studentId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {
            statement.setInt(1,
                    studentId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void search() {

    }
}
