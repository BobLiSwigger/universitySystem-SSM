package Controller;

import POJOs.Student;
import POJOs.Teacher;
import POJOs.User;
import Services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class logIn implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /************************必要的临时对象************************/
        ModelAndView modelAndView;
        int id;
        String password = request.getParameter("password");
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        UserService userService = (UserService)context.getBean("userService");
        Student logInStudent = (Student)context.getBean("logInStudent");
        Teacher logInTeacher = (Teacher)context.getBean("logInTeacher");
        User logInUser = (User)context.getBean("logInUser");
        /*-------------------------------页面控制-------------------------------*/

        //已经登录
        if (logInStudent.getlogInStatus()){
            modelAndView = new ModelAndView("WEB-INF/JSP/studentWelcome.jsp");
            modelAndView.addObject("student",logInStudent);
            return modelAndView;
        }
        if (logInTeacher.getlogInStatus()){
            modelAndView = new ModelAndView("WEB-INF/JSP/teacherWelcome.jsp");
            modelAndView.addObject("teacher",logInTeacher);
            return modelAndView;
        }
        if (logInUser.getlogInStatus()) {
            modelAndView = new ModelAndView("WEB-INF/JSP/welcome.jsp");
            modelAndView.addObject("user", logInUser);
            return modelAndView;
        }
        //没有登录
        try{
            id = Integer.parseInt(request.getParameter("id"));
        }catch (Exception e){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason", "用户名非法");
            return modelAndView;
        }
        String isPassword = "\\w*";
        if (!password.matches(isPassword)){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason", "密码含有非法字符！");
            return modelAndView;
        }
        String logInResult = userService.logIn(id, password);
        //登录失败-用户不存在
        if (logInResult.equals("failure")){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason", "用户不存在");
            return modelAndView;
        }


        if (logInResult.equals("student")){
            if (!logInStudent.getPassword().equals(password)){
                modelAndView = new ModelAndView("error.jsp");
                modelAndView.addObject("reason", "密码错误");
                return modelAndView;
            }
            logInStudent.setlogInStatus(true);
            modelAndView = new ModelAndView("WEB-INF/JSP/studentWelcome.jsp");
            modelAndView.addObject("student",logInStudent);
            return modelAndView;
        }
        if (logInResult.equals("teacher")){
            if (!logInTeacher.getPassword().equals(password)){
                modelAndView = new ModelAndView("error.jsp");
                modelAndView.addObject("reason", "密码错误");
                return modelAndView;
            }
            logInTeacher.setlogInStatus(true);
            modelAndView = new ModelAndView("WEB-INF/JSP/teacherWelcome.jsp");
            modelAndView.addObject("teacher",logInTeacher);
            return modelAndView;
        }
        if (logInResult.equals("user")) {
            if (!logInUser.getPassword().equals(password)) {
                modelAndView = new ModelAndView("error.jsp");
                modelAndView.addObject("reason", "密码错误");
                return modelAndView;
            }
            modelAndView = new ModelAndView("WEB-INF/JSP/welcome.jsp");
            modelAndView.addObject("user", logInUser);
            return modelAndView;
        }
        modelAndView = new ModelAndView("index.jsp");
        return modelAndView;
    }
}
