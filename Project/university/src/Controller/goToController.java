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
                List<Classes> classes = student.getTakenclasses();
                modelAndView.addObject("takenClasses",classes);
                return modelAndView;
            }
        }
        if (url.equals("我要申请开课")){
            Teacher teacher = (Teacher) context.getBean("logInTeacher");
            if (teacher.getlogInStatus()){
                modelAndView = new ModelAndView("WEB-INF/JSP/openNewCourse.jsp");
                return modelAndView;
            }
        }

        return modelAndView;
    }
}
