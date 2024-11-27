package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book javaBook = new Book("Java", 500);
        Book cBook = new Book("C#", 450);
        Book pyBook = new Book("Python", 300);
        Book clBook = new Book("Clean code", 349);
        Book[] books = new Book[4];
        books[0] = javaBook;
        books[1] = cBook;
        books[2] = pyBook;
        books[3] = clBook;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getCount());
        }
        System.out.println("Replace Java and Python");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Shown only book.name == Clean code");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getCount());
            }
        }
    }
}