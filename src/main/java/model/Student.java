package model;

import java.time.LocalDate;

public class Student {
    private int studentId;
    private String studentName;
    private LocalDate birth;
    private String email;
    private String address;
    private String phone;
    private String className;

    public Student(int studentId,
                   String studentName,
                   LocalDate birth,
                   String email,
                   String address,
                   String phone,
                   String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birth = birth;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.className = className;
    }

    public Student(String studentName,
                   LocalDate birth,
                   String email,
                   String address,
                   String phone,
                   String className) {
        this.studentName = studentName;
        this.birth = birth;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.className = className;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
