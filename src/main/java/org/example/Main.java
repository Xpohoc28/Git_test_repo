package org.example;

public class Main {
    public static void main(String[] args) {

        Cat firstCat = new Cat("Boris", "Bejeviy", 2);
        Cat secondCat = new Cat("Murlock", "Zeleniy", 3);

        System.out.println("Данные первого кота: " + firstCat.getName() +
                ", " + firstCat.getAge() + ", " + firstCat.getColor());

        System.out.println("Данные второго кота: " + secondCat.getName() +
                ", " + secondCat.getAge() + ", " + secondCat.getColor());

    }
}

//Goida