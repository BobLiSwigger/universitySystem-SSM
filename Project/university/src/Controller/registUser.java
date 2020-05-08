package Controller;

import POJOs.Card;
import Services.CardService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class registUser implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("WEB-INF/JSP/registResult.jsp");
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        CardService cardService = (CardService)context.getBean("cardService");
        //正则匹配表达式
        String isInt = "\\d+";
        String legal = "\\w+";
        String isDouble = "\\d+\\.\\d+|\\d+";
        //表单信息
        String phonenumber = request.getParameter("phonenumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int pack = Integer.parseInt(request.getParameter("pack"));
        String money = request.getParameter("money");

        //业务控制逻辑
        if (!username.matches(legal)){
            modelAndView.addObject("result","用户名非法！");
            return modelAndView;
        }
        if (!password.matches(legal)){
            modelAndView.addObject("result","密码格式非法！");
            return modelAndView;
        }
        if (!money.matches(isDouble)){
            modelAndView.addObject("result","预存金额格式错误！");
            return modelAndView;
        }
        modelAndView.addObject("result","注册成功！");
        double restmoney = Double.parseDouble(money);
        Card card = new Card();
        card.setPhonenumber(phonenumber);
        card.setUsername(username);
        card.setPassword(password);
        card.setPack(pack);
        card.setRestmoney(restmoney);

        //调用Service，再数据库里面注册用户
        cardService.createCard(card);
        return modelAndView;
    }
}
