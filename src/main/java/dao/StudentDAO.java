package dao;

import model.Student;

import javax.servlet.http.HttpServletRequest;
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
    public void update(HttpServletRequest request) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("update student set studentName = ?, birth = ?,"
                                                                       + " email = ?, address = ?, phoneNumber = ?, className = ?"
                                                                       + "where studentId = ?;")) {
            statement.setString(1,
                    request.getParameter("newName"));
            String birth = request.getParameter("newBirth");
            String birthFormatted = birth.split("-")[0] + "-" + birth.split("-")[1] + "-" + birth.split("-")[2];
            statement.setString(2,
                    birthFormatted);
            statement.setString(3,
                    request.getParameter("newEmail"));
            statement.setString(4,
                    request.getParameter("newAddress"));
            statement.setString(5,
                    request.getParameter("newPhone"));
            statement.setString(6,
                    request.getParameter("newClass"));
            statement.setInt(7,
                    Integer.parseInt(request.getParameter("id")));

            int count = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getClasses() {
        List<String> classList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("select className from classroom")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                classList.add(rs.getString("className"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classList;
    }

    @Override
    public Student chooseStudent(int id) {
        Student student = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from student where studentId = ?;")) {
            statement.setInt(1,
                    id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("studentId");
                String name = rs.getString("studentName");
                String birth = rs.getString("birth");
                LocalDate birthFormatted = LocalDate.parse(birth);
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phoneNumber");
                String className = rs.getString("className");

                student = new Student(id,
                        name,
                        birthFormatted,
                        email,
                        address,
                        phone,
                        className);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
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
    public List<Student> search(String sWords) {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from student where studentName like ?;")) {
            sWords = "%" + sWords + "%";
            statement.setString(1,
                    sWords);
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
}
