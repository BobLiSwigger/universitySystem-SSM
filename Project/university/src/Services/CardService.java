package Services;

import POJOs.Card;

public interface CardService {
    boolean passwordMatch(String phonenumber, String password);
    Card getCardByPhoneNumber(String phonenumber);
    void createCard(Card card);
}
