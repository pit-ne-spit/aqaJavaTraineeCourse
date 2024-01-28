package ru.inno.course;

public class Race {
    public static void main(String[] args) {
        Car newCar = new Car("ZAZ");

        System.out.println(newCar.getCurrentSpeed());

        newCar.speedUp(25);
        System.out.println(newCar.getCurrentSpeed());

        newCar.breakDown();
        System.out.println(newCar.getCurrentSpeed());

        newCar.breakDown();
        System.out.println(newCar.getCurrentSpeed());

        newCar.breakDown();
        System.out.println(newCar.getCurrentSpeed());

    }
}
