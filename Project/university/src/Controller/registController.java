package Controller;

import POJOs.CardNumbers;
import Services.ApplicationService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionManager;
import java.util.List;



public class registController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("WEB-INF/JSP/regist.jsp");
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        CardNumbers existingNumbers = (CardNumbers) context.getBean("cardNumbers");
        ApplicationService applicationService = (ApplicationService) context.getBean("applicationService");
        List<String> useableNumbers = applicationService.generateNonRepeatingNumbers(existingNumbers);
        modelAndView.addObject("useableNumbers", useableNumbers);
        TransactionManager tx = (TransactionManager) context.getBean("txManager");

        return modelAndView;
    }
}
