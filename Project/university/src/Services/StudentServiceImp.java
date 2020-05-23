package Services;

import DAO.ClassesMapper;
import DAO.StudentMapper;
import POJOs.ClassAndUser;
import POJOs.Classes;
import POJOs.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import java.util.*;

public class StudentServiceImp implements StudentService {
    ApplicationContext context;
    StudentMapper studentMapper;
    ClassesMapper classesMapper;
    Student student;
    //Initialize
    StudentServiceImp(){
        this.context = ContextLoader.getCurrentWebApplicationContext();
        this.studentMapper = (StudentMapper)context.getBean("studentMapper");
        classesMapper = (ClassesMapper)context.getBean("classesMapper");

        this.student = (Student)context.getBean("logInStudent");
    }

    @Override
    public String chooseClass(int studentID, int classID) {
        ClassAndUser classAndUser = new ClassAndUser();
        classAndUser.setUserID(studentID);
        classAndUser.setClassID(classID);
        try {
            studentMapper.chooseClassProcedure(classAndUser);
        }catch (Exception e){
            return "Exception";
        }
        List<Classes> classes = classesMapper.getClassesByStudentID(studentID);
        boolean haveTaken = false;
        for (Classes a : classes){
            if (a.getClassID() == classID){
                return "success";
            }
        }
        return "选课失败！";
    }

    //退课操作
    @Override
    public boolean dropOutClass(int studentID, int classID) {
        ClassAndUser classAndUser = new ClassAndUser();
        classAndUser.setClassID(classID);
        classAndUser.setUserID(studentID);
        try {
            studentMapper.dropOutClass(classAndUser);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Classes> fetchTakenClasses(int id) {
        return classesMapper.getClassesByStudentID(id);
    }
}
