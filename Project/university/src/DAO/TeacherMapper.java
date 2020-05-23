package DAO;

import POJOs.ClassAndUser;
import POJOs.Classes;
import POJOs.Teacher;

import java.util.List;

public interface TeacherMapper {
    Teacher getTeacherById(int id);
    void createTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    List<Classes> getTeachClasses(int id);
    void teachClass(ClassAndUser classAndUser);
    //void deleteTeacher(int id);
}
