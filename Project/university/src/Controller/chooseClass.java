package Controller;


import POJOs.Student;
import Services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class chooseClass implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
        for (String chosenClass : chosenClasses) {
            String result = studentService.chooseClass(student.getId(), Integer.parseInt(chosenClass));
            if (result.equals("Exception")) {
                modelAndView = new ModelAndView("error.jsp");
                modelAndView.addObject("reason", "异常错误！");
                return modelAndView;
            }
            if (!result.equals("success")){
                modelAndView = new ModelAndView("error.jsp");
                modelAndView.addObject("reason", result);
                return modelAndView;
            }
        }
        modelAndView = new ModelAndView("success.jsp");
        modelAndView.addObject("tip","选课成功！");
        return modelAndView;
    }
}
