package Controller;

import POJOs.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class consumeController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("WEB-INF/JSP/consumeResult.jsp");
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        CardMapper cardMapper = (CardMapper)context.getBean("cardMapper");
        Card logInUser = (Card)context.getBean("logInUser");
        //消费数据
        String talkTime = request.getParameter("talkTime");
        String smsCount = request.getParameter("smsCount");
        String flowCount = request.getParameter("flowCount");
        //正则表达式
        String isInt = "\\d+";
        String isDouble = "\\d+\\.\\d+|\\d+";
        if (talkTime.matches(isInt) && smsCount.matches(isInt) && flowCount.matches(isDouble)){
            int talktime = Integer.parseInt(talkTime);
            int smscount = Integer.parseInt(smsCount);
            double flowcount = Double.parseDouble(flowCount);
            logInUser.consume_talk(talktime);
            logInUser.consume_sms(smscount);
            logInUser.consume_net(flowcount);
            cardMapper.updateCard(logInUser);

            modelAndView.addObject("logInUser",logInUser);
            if (logInUser.p instanceof TalkPackage) {
                modelAndView.addObject("restTalkTime", ((TalkPackage) logInUser.p).talkTime);
                modelAndView.addObject("restSmsCount", ((TalkPackage) logInUser.p).smsCount);
            }
            if (logInUser.p instanceof NetPackage){
                modelAndView.addObject("restFlowCount", ((NetPackage) logInUser.p).flowCount);
            }
            if (logInUser.p instanceof SuperPackage){
                modelAndView.addObject("restTalkTime", ((SuperPackage) logInUser.p).talkTime);
                modelAndView.addObject("restSmsCount", ((SuperPackage) logInUser.p).smsCount);
                modelAndView.addObject("restFlowCount", ((SuperPackage) logInUser.p).flowCount);
            }
        }
        else {
            modelAndView.addObject("result", "消费数据格式错误！");
        }

        return modelAndView;
    }
}
