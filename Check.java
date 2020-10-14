package by.mail.bookShop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Check implements Delivery,  UserCode {
    Book book;

    public static double countFromFile() {
        double[] array = null;
        try (BufferedReader in = new BufferedReader(new FileReader("D:\\02_Study\\java-project\\variables\\src\\by\\mail\\bookShop\\file")))
        {
            array = in.lines().mapToDouble(Double::parseDouble).toArray();
        }
        catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        double summa = 0;
        if (array != null)
        {

            for (int i = 0; i < array.length; i++)
            {
                summa +=array[i];
            }

        }
        return summa;
    }


    @Override
    public double calculateDelivery(double amount, int delivery) {

        if (amount < amountWithPayDelivery) {
            return delivery;
        }
        if (amount > amountWithPayDelivery && amount < amountWithFreeDelivery) {
            return delivery / 2;
        }
        return 0;
    }



    @Override
    public String generateCode(String email) {
        Integer buffer = (100 + (int) Math.random() * 999);
        String code = buffer.toString();
        return code;
    }

}
