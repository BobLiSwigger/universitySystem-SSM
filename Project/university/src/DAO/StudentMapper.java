package DAO;

import POJOs.Student;

public interface StudentMapper {
    Student getStudentById(int id);
    void createCard(Student student);
    void updateCard(Student student);
}
