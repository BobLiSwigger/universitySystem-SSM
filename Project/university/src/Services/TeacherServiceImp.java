package Services;

import DAO.ClassesMapper;
import DAO.TeacherMapper;
import POJOs.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

public class TeacherServiceImp implements TeacherService {
    ApplicationContext context;
    TeacherMapper teacherMapper;
    ClassesMapper classesMapper;

    TeacherServiceImp(){
        this.context = ContextLoader.getCurrentWebApplicationContext();
        this.teacherMapper = (TeacherMapper)context.getBean("teacherMapper");
        this.classesMapper = (ClassesMapper)context.getBean("classesMapper");
    }
    @Override
    public boolean openNewCourse(Course course, int teacherID) {
        try{
            classesMapper.createCourseTable(course);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
