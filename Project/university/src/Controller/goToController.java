package Controller;


import POJOs.Classes;
import POJOs.Student;
import POJOs.Teacher;
import Services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class goToController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*-------------------------------必要的临时对象-------------------------------*/
        ModelAndView modelAndView = new ModelAndView("index.jsp");
        String url = request.getParameter("url");
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        /*-------------------------------页面控制-------------------------------*/
        if (url.equals("选课")){
            Student student = (Student) context.getBean("logInStudent");
            if (student.getlogInStatus()){
                ClassService classService = (ClassServiceImp)context.getBean("classesService");
                List<Classes> classes = classService.getAvailableClassesByID(student.getId());
                modelAndView = new ModelAndView("WEB-INF/JSP/chooseClass.jsp");
                modelAndView.addObject("availableClasses", classes);
                return modelAndView;
            }
        }
        if (url.equals("我修的课程")){
            Student student = (Student) context.getBean("logInStudent");
            if (student.getlogInStatus()){
                StudentService studentService = (StudentServiceImp)context.getBean("studentService");
                student.setTakenclasses(studentService.fetchTakenClasses(student.getId()));
                modelAndView = new ModelAndView("WEB-INF/JSP/myTakenClass.jsp");
                modelAndView.addObject("takenClasses",student.getTakenclasses());
                return modelAndView;
            }
        }
        if (url.equals("我教的课")){
            Teacher teacher = (Teacher) context.getBean("logInTeacher");
            if (teacher.getlogInStatus()){
                modelAndView = new ModelAndView("WEB-INF/JSP/openNewCourse.jsp");
                TeacherService teacherService = (TeacherServiceImp)context.getBean("teacherService");
                ClassService classService = (ClassServiceImp)context.getBean("classesService");
                teacher.setTeachClass(teacherService.fetchTaughtClasses(teacher.getId()));

                modelAndView.addObject("teachClasses", teacher.getTeachClass());
                List<Classes> classes = teacher.getTeachClass();
                modelAndView.addObject("depts", classService.getAllDepts());
                System.out.println("This is goToController(myTaughtClasses) running.");
                for (Classes a : classes){
                    System.out.println(a.getCourseID());
                }
                return modelAndView;
            }
        }

        return modelAndView;
    }
}
