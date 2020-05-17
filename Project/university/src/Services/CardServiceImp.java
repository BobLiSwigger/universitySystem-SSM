package Services;

import POJOs.Card;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

public class CardServiceImp implements CardService {
    ApplicationContext context;
    CardMapper cardMapper;
    public CardServiceImp(){
        this.context = ContextLoader.getCurrentWebApplicationContext();
        this.cardMapper = (CardMapper) context.getBean("cardMapper");
    }
    @Override
    public boolean passwordMatch(String phonenumber, String password) {
        Card card = cardMapper.getCardByPhoneNumber(phonenumber);
        return card.getPassword().equals(password);
    }
    @Override
    public Card getCardByPhoneNumber(String phonenumber){
        Card card = cardMapper.getCardByPhoneNumber(phonenumber);
        return card;
    }

    @Override
    public void createCard(Card card) {
        cardMapper.createCard(card);
    }
}
