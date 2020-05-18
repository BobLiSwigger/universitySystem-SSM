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


public class goToController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*-------------------------------必要的临时对象-------------------------------*/
        ModelAndView modelAndView = new ModelAndView("index.jsp");
        String url = request.getParameter("url");

        /*-------------------------------页面控制-------------------------------*/
        if (url.equals("选课")){
            modelAndView = new ModelAndView("WEB-INF/JSP/chooseClass.jsp");
        }

        return modelAndView;
    }
}
