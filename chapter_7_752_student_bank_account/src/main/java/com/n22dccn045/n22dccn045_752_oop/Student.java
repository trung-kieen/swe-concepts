/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n22dccn045.n22dccn045_752_oop;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Student {
    // Thuộc tính
    private String studentID;
    private String name;
    private double gpa;
    private List<String> enrolledCourses;

    // Constructor
    public Student(String studentID, String name, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
    }

    // Getter và Setter
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Phương thức hiển thị thông tin sinh viên
    public void displayInfo() {
        System.out.println("Thông tin sinh viên:");
        System.out.println("Mã sinh viên: " + studentID);
        System.out.println("Họ và tên: " + name);
        System.out.println("Điểm GPA: " + gpa);
        System.out.println("Danh sách khóa học đã đăng ký: " + 
                          (enrolledCourses.isEmpty() ? "Chưa đăng ký khóa học" : enrolledCourses));
    }

    // Phương thức cập nhật GPA
    public void updateGPA(double newGPA) {
        if (newGPA >= 0 && newGPA <= 4.0) {
            this.gpa = newGPA;
            System.out.println("Đã cập nhật GPA thành: " + newGPA);
        } else {
            System.out.println("GPA không hợp lệ! GPA phải nằm trong khoảng từ 0.0 đến 4.0");
        }
    }

    // Phương thức thêm khóa học
    public void enrollCourse(String courseName) {
        if (courseName != null && !courseName.trim().isEmpty()) {
            if (!enrolledCourses.contains(courseName)) {
                enrolledCourses.add(courseName);
                System.out.println("Đã thêm khóa học: " + courseName);
            } else {
                System.out.println("Khóa học " + courseName + " đã được đăng ký trước đó!");
            }
        } else {
            System.out.println("Tên khóa học không hợp lệ!");
        }
    }

    // Phương thức kiểm tra điều kiện học bổng
    public boolean isEligibleForScholarship() {
        return gpa >= 3.5;
    }

    // Phương thức so sánh GPA với sinh viên khác
    public int compareGPA(Student otherStudent) {
        if (otherStudent == null) {
            throw new IllegalArgumentException("Sinh viên so sánh không được null");
        }
        return Double.compare(this.gpa, otherStudent.getGpa());
    }

    // Phương thức xóa khóa học
    public void dropCourse(String courseName) {
        if (enrolledCourses.contains(courseName)) {
            enrolledCourses.remove(courseName);
            System.out.println(name + " đã hủy khóa học: " + courseName);
        } else {
            System.out.println("Khóa học không tồn tại trong danh sách!");
        }
    }
}