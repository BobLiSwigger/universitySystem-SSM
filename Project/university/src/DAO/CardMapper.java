package DAO;

import POJOs.Card;

public interface CardMapper {
    Card getCardByPhoneNumber(String phonenumber);
    void createCard(Card card);
    void updateCard(Card card);
}
