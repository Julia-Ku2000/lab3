package by.mail.bookShop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static by.mail.bookShop.Book.chooseItem;
import static by.mail.bookShop.Check.countFromFile;
import static by.mail.bookShop.Delivery.delivery;

public class Buyer extends User implements  SaveCard {
    private String phoneNumber;
    CreditCard personalCard;
    double amountOnSaveCard = 0;
    double amountSpend = 0;
    public final double coefficientt = 0.05;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CreditCard getPersonalCard() {
        return personalCard;
    }

    public double getAmountOnSaveCard() {
        return amountOnSaveCard;
    }

    public double getAmountSpend() {
        return (amountSpend + countFromFile());
    }


    public double countAmountOfDiscount(double amount, double coefficient) {
        return (getAmountSpend() -  getAmountSpend() * coefficient);
    }

    @Override
    public double buy(double amount, double discount) {
        double countAmountOfDiscount = countAmountOfDiscount(getAmountSpend(), coefficientt);
        try  {
            Files.write(Paths.get("D:\\02_Study\\java-project\\variables\\src\\by\\mail\\bookShop\\fileCheck")
                    ,(String.valueOf(countAmountOfDiscount)+"\n").getBytes() ,
                    StandardOpenOption.APPEND);
        }
        catch (IOException e )
        {
            e.printStackTrace();
        }
       // countAmountOfDiscount = +calculateDelivery(amount, delivery);
        return countAmountOfDiscount;
    }

    @Override
    public void addPercent(String email) {
        double buyAmount = buy(getAmountSpend(), discount);
        amountOnSaveCard = buyAmount * accumulation;
    }


}
