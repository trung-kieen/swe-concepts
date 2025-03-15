/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.n22dccn045.n22dccn045_752_oop;

import com.n22dccn045.n22dccn045_752_oop.Student;
 import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author trungkieen
 */
public class N22DCCN045_752_OOP {


    private List<Student> students;

    // Constructor
    public N22DCCN045_752_OOP() {
        this.students = new ArrayList<>();
    }

    // Thêm sinh viên vào danh sách
    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
            System.out.println("Đã thêm sinh viên: " + student.getName());
        } else {
            System.out.println("Sinh viên không hợp lệ!");
        }
    }

    // Tìm sinh viên theo mã sinh viên
    public Student findStudentById(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    // Đăng ký khóa học cho sinh viên
    public void enrollCourseForStudent(String studentID, String courseName) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.enrollCourse(courseName);
        } else {
            System.out.println("Không tìm thấy sinh viên với mã: " + studentID);
        }
    }

    // Hủy khóa học cho sinh viên
    public void dropCourseForStudent(String studentID, String courseName) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.dropCourse(courseName);
        } else {
            System.out.println("Không tìm thấy sinh viên với mã: " + studentID);
        }
    }

    // Cập nhật GPA cho sinh viên
    public void updateGPAForStudent(String studentID, double newGPA) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.updateGPA(newGPA);
        } else {
            System.out.println("Không tìm thấy sinh viên với mã: " + studentID);
        }
    }

    // Kiểm tra học bổng cho sinh viên
    public void checkScholarshipForStudent(String studentID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            boolean eligible = student.isEligibleForScholarship();
            System.out.println(student.getName() + " " + 
                             (eligible ? "đủ điều kiện nhận học bổng." : 
                                       "không đủ điều kiện nhận học bổng."));
        } else {
            System.out.println("Không tìm thấy sinh viên với mã: " + studentID);
        }
    }

    // So sánh GPA của hai sinh viên
    public void compareGPAOfStudents(String studentID1, String studentID2) {
        Student student1 = findStudentById(studentID1);
        Student student2 = findStudentById(studentID2);

        if (student1 == null) {
            System.out.println("Không tìm thấy sinh viên với mã: " + studentID1);
            return;
        }
        if (student2 == null) {
            System.out.println("Không tìm thấy sinh viên với mã: " + studentID2);
            return;
        }

        int comparison = student1.compareGPA(student2);
        if (comparison > 0) {
            System.out.println(student1.getName() + " có GPA cao hơn " + student2.getName());
        } else if (comparison < 0) {
            System.out.println(student1.getName() + " có GPA thấp hơn " + student2.getName());
        } else {
            System.out.println(student1.getName() + " và " + student2.getName() + " có GPA bằng nhau");
        }
    }

    // Hiển thị thông tin tất cả sinh viên
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
        } else {
            System.out.println("=== Danh sách sinh viên ===");
            for (Student student : students) {
                student.displayInfo();
                System.out.println("------------------------");
            }
        }
    }

    // Main method để test hệ thống
    public static void main(String[] args) {
        N22DCCN045_752_OOP system = new N22DCCN045_752_OOP();

        // Tạo danh sách sinh viên
        Student student1 = new Student("SV001", "Nguyễn Văn A", 3.7);
        Student student2 = new Student("SV002", "Trần Thị B", 3.2);
        Student student3 = new Student("SV003", "Lê Văn C", 3.9);

        // Thêm sinh viên vào hệ thống
        system.addStudent(student1);
        system.addStudent(student2);
        system.addStudent(student3);

        // Hiển thị danh sách sinh viên ban đầu
        system.displayAllStudents();

        // Đăng ký khóa học
        System.out.println("\n=== Đăng ký khóa học ===");
        system.enrollCourseForStudent("SV001", "Lập trình Java");
        system.enrollCourseForStudent("SV001", "Cấu trúc dữ liệu");
        system.enrollCourseForStudent("SV002", "Toán cao cấp");

        // Hủy khóa học
        System.out.println("\n=== Hủy khóa học ===");
        system.dropCourseForStudent("SV001", "Lập trình Java");
        system.dropCourseForStudent("SV002", "Vật lý đại cương"); // Thử hủy khóa học không có

        // Cập nhật GPA
        System.out.println("\n=== Cập nhật GPA ===");
        system.updateGPAForStudent("SV001", 3.8);
        system.updateGPAForStudent("SV003", 2.5);

        // Kiểm tra học bổng
        System.out.println("\n=== Kiểm tra học bổng ===");
        system.checkScholarshipForStudent("SV001");
        system.checkScholarshipForStudent("SV002");
        system.checkScholarshipForStudent("SV003");

        // So sánh GPA
        System.out.println("\n=== So sánh GPA ===");
        system.compareGPAOfStudents("SV001", "SV002");
        system.compareGPAOfStudents("SV002", "SV003");
        system.compareGPAOfStudents("SV001", "SV004"); // Thử so sánh với sinh viên không tồn tại

        // Hiển thị danh sách sinh viên cuối cùng
        System.out.println("\n=== Danh sách sinh viên cuối cùng ===");
        system.displayAllStudents();
    }
}