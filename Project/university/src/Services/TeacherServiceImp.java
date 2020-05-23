package Services;

import DAO.ClassesMapper;
import DAO.TeacherMapper;
import POJOs.Classes;
import POJOs.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

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
        try{
            classesMapper.createCourseTable(course);
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
