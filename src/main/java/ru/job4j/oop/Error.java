package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
        active = true;
        status = 404;
        message = "not found";
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        System.out.println();
        Error error1 = new Error(true, 400, "Bad Request");
        error1.printInfo();
        System.out.println();
        Error error2 = new Error(false, 0, "Yes");
        error2.printInfo();
    }

}
