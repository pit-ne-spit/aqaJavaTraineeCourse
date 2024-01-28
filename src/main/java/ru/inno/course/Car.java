package ru.inno.course;

public class Car {
    String model;
    int currentSpeed = 0;

    public Car(String model) {
        this.model = model;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void speedUp (int speedVolume) {
        this.currentSpeed = this.currentSpeed + speedVolume;
    }

    public void breakDown() {
        this.currentSpeed = this.currentSpeed - 10;
        if (currentSpeed <= 00) {
            this.currentSpeed = 0;
        }
    }




}

