package Services;

import DAO.ClassesMapper;
import DAO.StudentMapper;
import POJOs.Classes;
import POJOs.Student;
import POJOs.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public boolean chooseClass(int studentID, int classID) {
        return false;
    }

    @Override
    public List<Classes> fetchTakenClasses(int id) {
        return classesMapper.getClassesByStudentID(id);
    }
}
