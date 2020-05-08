package Controller;

import POJOs.Card;
import POJOs.CardNumbers;
import Services.CardService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class logInController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("我是【servlet】logInController");

        /************************必要的临时对象************************/
        ModelAndView modelAndView;
        String phonenumber = request.getParameter("phonenumber");
        String password = request.getParameter("password");
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        CardNumbers cardNumbers = (CardNumbers)context.getBean("cardNumbers");
        CardService cardService = (CardService) context.getBean("cardService");;
        Card logInUser = (Card)context.getBean("logInUser");
        /************************页面控制************************/
        if (phonenumber.equals("")){
            modelAndView = new ModelAndView("WEB-INF/JSP/logInFailure.jsp");
            modelAndView.addObject("reason", "卡号不能为空！");
        }
        else {
            //存在号码
            if (cardNumbers.cardNumbers.contains(phonenumber)) {
                //密码正确
                if (cardService.passwordMatch(phonenumber,password)){
                    modelAndView = new ModelAndView("WEB-INF/JSP/logInSuccess.jsp");
                    Card card = cardService.getCardByPhoneNumber(phonenumber);
                    logInUser.reSet(card);
                    modelAndView.addObject("username", card.username);
                    modelAndView.addObject("phonenumber", card.phonenumber);
                    modelAndView.addObject("restmoney", card.restmoney);
                    String packageName;
                    switch (card.pack){
                        case 1:
                            packageName = "话痨套餐";
                            break;
                        case 2:
                            packageName = "网虫套餐";
                            break;
                        case 3:
                            packageName = "超级套餐";
                            break;
                        default:
                            packageName = "您没有选择套餐！";
                    }
                    modelAndView.addObject("pack", packageName);
                }
                //密码错误
                else{
                    modelAndView = new ModelAndView("WEB-INF/JSP/logInFailure.jsp");
                    modelAndView.addObject("reason", "密码错误！");
                }
            }
            //数据库的卡号中不存在此号码
            else {
                modelAndView = new ModelAndView("WEB-INF/JSP/logInFailure.jsp");
                modelAndView.addObject("reason", "不存在此号码！");
            }
        }
        return modelAndView;
    }
}
