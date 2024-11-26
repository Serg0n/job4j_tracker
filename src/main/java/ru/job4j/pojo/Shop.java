package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int i = -1;
        for (int index = 0; index < products.length - 1; index++) {
        Product product = products[index];
        if (product == null) {
            i = index;
            break;
        }
        }
        return i;
    }
}