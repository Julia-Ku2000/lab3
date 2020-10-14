package by.mail.bookShop;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Book {
    private String name;
    private String author;
    private double price;
    private int count;

    static List<Book> books = new ArrayList<>();


    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }


    public static void showCatalog() {
        books.add(new Book("Война ии мир", "Лев Толстой", 25));
        books.add(new Book("Маленькая хозяйка большого дома", "Джек Лондон", 36));
        books.add(new Book("Палата №6", "Антон Чехов", 46));
        books.add(new Book("Великий Гетсби", "Френсис Скотт Фиджеральд", 54.6));
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + " " + books.get(i));
        }
    }

    public static double chooseItem(int userChoice) {
        return books.get(userChoice).getPrice();

    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                name + " " +
                        author + " " +
                        price;
    }
}