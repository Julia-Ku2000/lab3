package by.mail.bookShop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static by.mail.bookShop.Book.chooseItem;
import static by.mail.bookShop.Book.showCatalog;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Buyer buyer = new Buyer();
        showCatalog();
        System.out.println("Выберете товар");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            choice = scanner.nextInt();
            if (choice > 0 && choice <= 4) {
                try {
                    Files.write(Paths.get("D:\\02_Study\\java-project\\variables\\src\\by\\mail\\bookShop\\file")
                            , (String.valueOf(chooseItem(choice - 1)) + "\n").getBytes(),
                            StandardOpenOption.APPEND);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } while (choice != 0);

        System.out.println("К оплате: ");
        buyer.buy(buyer.getAmountSpend(), 2);
        System.out.println(readCheckFromFile());
        System.out.println("Выберете способ оплаты:");

        int wayOfPay;
        String cardInfo;
        int CVC;
        String date;
        System.out.println("1. Наличные");
        System.out.println("2. Карта");


        wayOfPay = scanner.nextInt();
        if (wayOfPay == 1) {
            System.out.println("Оплата будет совершена при получении");
        } else if (wayOfPay == 2) {
            System.out.println("Заполните данные банковской карты");
            CreditCard creditCard = new CreditCard();
            System.out.println("Номер банковской карты");
            while (scanner.hasNext()) {
                cardInfo = scanner.nextLine();
                creditCard.setCardNumber(cardInfo);
            }

            //date = scanner.nextLine();
            //SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            //Date date1 = s.parse(date);
            //scanner.close();
            //SimpleDateFormat smd = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
            ///creditCard.setTerm(smd.format(date1).toUpperCase());

        } else if (wayOfPay != 1 || wayOfPay != 2) {
            System.out.println("error");
        }


    }


    public static double readCheckFromFile() {
        double[] array = null;
        try (BufferedReader in = new BufferedReader(new FileReader("D:\\02_Study\\java-project\\variables\\src\\by\\mail\\bookShop\\fileCheck"))) {
            array = in.lines().mapToDouble(Double::parseDouble).toArray();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        double summa = 0;
        if (array != null) {

            for (int i = 0; i < array.length; i++) {
                summa += array[i];
            }

        }
        return summa;
    }

}


