package DAO;

import POJOs.Classes;
import POJOs.Course;
import POJOs.Dept;
import POJOs.YearAndTerm;
import java.util.List;

public interface ClassesMapper {
    public Classes getClassByID(int classesID);//按照ID查找Classes
    public List<Classes> getClassesByStudentID(int id);
    public List<Classes> getClassesByTeacherID(int id);
    public List<Classes> getClassesByYearAndTerm(YearAndTerm yearAndTerm);//获得某一年某学期的所有课程
    public List<Classes> getCurrentClasses();//获得某一年某学期的所有课程
    public List<Classes> getAvailableClassesByID(int id);//获得某学生的可选课程
    public void createClassesTable(Classes classes);
    public void createCourseTable(Course course);
    public void updateClassesTable(Classes classes);
    //public void deleteClasses(int classesID);

    public List<Dept> getAllDepts();
}
