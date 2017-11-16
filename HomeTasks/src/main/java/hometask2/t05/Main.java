package hometask2.t05;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        class Mathematics extends Discipline {
            Mathematics(Double highestScore) {
                super(highestScore);
            }
        }
        class Chemistry extends Discipline {
            Chemistry(Double highestScore) {
                super(highestScore);
            }
        }
        class Physics extends Discipline {
            Physics(Integer highestScore) {
                super(highestScore);
            }
        }
        Group group1 = new Group(new Mathematics(5.0));
        Group group2 = new Group(new Chemistry(5.0));
        Group group3 = new Group(new Physics(5));
        Random random = new Random();
        Random random2 = new Random();
        Student student1 = new Student("Mata, Juan");
        String[] array1 = {"De Gea, David", "Castro Pereira, Joel", "Romero, Sergio"};
        String[] array2 = {"Bailly, Eric", "Jones Phil", "Valencia, Antonio", "Smalling, Chris", "Blind, Daley", "Young, Ashley"};
        String[] array3 = {"Matic, Nemanja", "Ander Herrera", "Carrick, Michael"};
        for (int i = 0; i < array1.length; i++) {
            group1.addStudent(new Student(array1[i]));
            group1.setMark(array1[i], random.nextDouble() * 5.0);
        }
        for (int i = 0; i < array2.length; i++) {
            group2.addStudent(new Student(array2[i]));
            group2.setMark(array2[i], random.nextDouble() * 5.0);
        }
        for (int i = 0; i < array3.length; i++) {
            group3.addStudent(new Student(array3[i]));
            group3.setMark(array3[i], random2.nextInt(5));
        }
        group1.addStudent(student1);
        group3.addStudent(student1);
        group1.setMark(student1.getName(), 4.0);
        group3.setMark(student1.getName(), 4);
        System.out.println(student1);

    }

}
