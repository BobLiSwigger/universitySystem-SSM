package DAO;

import POJOs.Classes;
import POJOs.Teacher;

import java.util.List;

public interface TeacherMapper {
    Teacher getTeacherById(int id);
    void createTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    List<Classes> getTeachClasses(int id);
    void teachClass(int classID, int teacherID);
    //void deleteTeacher(int id);
}
