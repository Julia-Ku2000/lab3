package by.mail.bookShop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Admin extends User {

    @Override
    public double buy(double amount, double discount) {
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
}
