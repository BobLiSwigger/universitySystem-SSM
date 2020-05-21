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
        try{
            id = Integer.parseInt(request.getParameter("id"));
        }catch (Exception e){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason", "用户名非法");
            return modelAndView;
        }

        String password = request.getParameter("password");
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        UserService userService = (UserService)context.getBean("userService");
        User user = (Student)context.getBean("logInStudent");

        /*-------------------------------页面控制-------------------------------*/
        String isPassword = "\\w*";
        if (!password.matches(isPassword)){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason", "密码含有非法字符！");
            return modelAndView;
        }
        User temp = userService.logIn(id, password);
        //登录失败-用户不存在
        if (temp.getName().equals("")){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason", "用户不存在");
            user.setlogInStatus(false);
            return modelAndView;
        }
        //登录失败-密码错误
        if (!password.equals(temp.getPassword())){
            modelAndView = new ModelAndView("error.jsp");
            modelAndView.addObject("reason", "密码错误！");
            user.setlogInStatus(false);
            return modelAndView;
        }

        //登录成功
        user.setlogInStatus(true);
        if (temp instanceof Student){
            user.setAllAttributes(temp);
            modelAndView = new ModelAndView("WEB-INF/JSP/studentWelcome.jsp");
            Student student = (Student) temp;
            modelAndView.addObject("student",student);
        }
        else {
            if (temp instanceof Teacher){
                Teacher teacher = (Teacher)temp;
                user = (Teacher)context.getBean("logInTeacher");
                user.setAllAttributes(temp);
                modelAndView = new ModelAndView("WEB-INF/JSP/teacherWelcome.jsp");
                modelAndView.addObject("teacher",teacher);
            }
            else {
                user = (User)context.getBean("logInUser");
                user.setAllAttributes(temp);
                modelAndView = new ModelAndView("WEB-INF/JSP/welcome.jsp");
                modelAndView.addObject("user",user);
            }
        }
        user.setlogInStatus(true);
        return modelAndView;
    }
}
