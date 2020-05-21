package Controller;


import DAO.ClassesMapper;
import POJOs.*;
import Services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class openNewCourse implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*-------------------------------必要的临时对象-------------------------------*/
        ModelAndView modelAndView = new ModelAndView("success.jsp");
        Course course = new Course();

        String courseID = request.getParameter("courseID");
        String name = request.getParameter("name");
        String courseDescription = request.getParameter("courseDescription");
        String deptID = request.getParameter("deptID");
        String credit = request.getParameter("credit");

        course.setCourseID(courseID);
        course.setCourseName(name);
        course.setCourseDescription(courseDescription);
        course.setDept(new Dept(deptID));
        course.setCredit(Float.parseFloat(credit));

        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        Teacher teacher = (Teacher)context.getBean("logInTeacher");
        TeacherService teacherService = (TeacherServiceImp)context.getBean("teacherService");
        /*-------------------------------页面控制-------------------------------*/
        if (!teacher.getlogInStatus()){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason", "您未登录，请重新登录！");
            return modelAndView;
        }
        if (!teacherService.openNewCourse(course, teacher.getId())){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason","开课失败！");
            return modelAndView;
        }
        modelAndView.addObject("tip","开课成功！");
        return modelAndView;
    }
}
