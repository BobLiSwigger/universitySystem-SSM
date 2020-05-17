package DAO;

import POJOs.Classes;
import POJOs.Student;
import POJOs.User;

import java.util.List;

public interface StudentMapper {
    Student getStudentById(int id);
    void createStudent(Student student);
    void updateStudent(Student student);
    List<Classes> getTakenClasses(int id);
    //void deleteStudent(int id);
}
