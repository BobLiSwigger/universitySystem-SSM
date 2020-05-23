package Controller;


import POJOs.Classes;
import POJOs.Student;
import Services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class dropOutClass implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*-------------------------------必要的临时对象-------------------------------*/
        ModelAndView modelAndView;
        String[] chosenClasses = request.getParameterValues("chosenClass");
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        Student student = (Student)context.getBean("logInStudent");
        StudentService studentService = (StudentService)context.getBean("studentService");
        /*-------------------------------页面控制-------------------------------*/
        if (!student.getlogInStatus()){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason", "您未登录，请重新登录！");
            return modelAndView;
        }
        for (int i=0;i<chosenClasses.length;i++){
            if (!studentService.dropOutClass(student.getId(), Integer.parseInt(chosenClasses[i]))){
                modelAndView = new ModelAndView("error.jsp");
                modelAndView.addObject("reason", "退课失败!");
                return modelAndView;
            }
        }
        modelAndView = new ModelAndView("success.jsp");
        modelAndView.addObject("tip", "退课成功！");
        return modelAndView;
    }
}
