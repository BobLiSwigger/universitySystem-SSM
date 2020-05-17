package POJOs;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import java.util.List;

public class CardNumbers {
    public List<String> cardNumbers;
    public CardNumbers() {
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        ApplicationMapper applicationMapper = (ApplicationMapper) context.getBean("applicationMapper");
        this.cardNumbers = applicationMapper.getAllNumbers();
    }
}
