package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Petr Arsentev");
        student.setGroup("Java Group");
        student.setAdmissionDate(new Date());
        System.out.println("Student - " + student.getName() + " in - " + student.getGroup() + " from - " + student.getAdmissionDate());
    }
}
