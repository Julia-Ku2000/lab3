package by.mail.bookShop;

public interface Delivery {
    final int delivery = 5;
    int amountWithPayDelivery = 20;
    int amountWithFreeDelivery = 50;
    double calculateDelivery(double amount, int delivery);
}
