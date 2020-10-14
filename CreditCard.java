package by.mail.bookShop;

import java.util.Date;

public class CreditCard {
    String cardNumber;
    String term;
    String instanceCard;
    int CVC;


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getInstanceCard() {
        return instanceCard;
    }

    public void setInstanceCard(String instanceCard) {
        this.instanceCard = instanceCard;
    }

    public int getCVC() {
        return CVC;
    }

    public void setCVC(int CVC) {
        this.CVC = CVC;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;
}
