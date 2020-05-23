package Services;

import DAO.ClassesMapper;
import DAO.TeacherMapper;
import POJOs.ClassAndUser;
import POJOs.Classes;
import POJOs.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import java.time.Year;
import java.util.List;

public class TeacherServiceImp implements TeacherService {
    ApplicationContext context;
    TeacherMapper teacherMapper;
    ClassesMapper classesMapper;

    TeacherServiceImp(){
        this.context = ContextLoader.getCurrentWebApplicationContext();
        this.teacherMapper = (TeacherMapper)context.getBean("teacherMapper");
        this.classesMapper = (ClassesMapper)context.getBean("classesMapper");
    }
    //开课操作
    @Override
    public boolean openNewCourse(Course course, int teacherID) {
        Classes classes = new Classes();
        classes.setCourseID(course.getCourseID());
        classes.setYear(Year.now());
        classes.setTerm(false);
        classes.setSize((short) 0);
        classes.setMaxSize((short) 60);
        ClassAndUser classAndUser = new ClassAndUser();
        classAndUser.setUserID(teacherID);
        try{
            classesMapper.createCourseTable(course);
            classesMapper.createClassesTable(classes);
            System.out.println(classes.getClassID());
            classAndUser.setClassID(classes.getClassID());
            teacherMapper.teachClass(classAndUser);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Classes> fetchTaughtClasses(int id) {
        List<Classes> classes = classesMapper.getClassesByTeacherID(id);
        for (Classes a : classes){
            System.out.println(a.getClassID());
        }
        return classes;
    }
}
