package ru.inno.course;

public class Flat {

    int roomsCount;
    int flatNumber;
    float flatArea;
    int flatLevel;
    String flatDiscription;
    boolean isNew;
    FlatChars flatChars;
    public Flat(int roomsCount, int flatNumber, float flatArea, int flatLevel,
                String flatDiscription, boolean isNew, FlatChars flatChars) {
        this.roomsCount = roomsCount;
        this.flatNumber = flatNumber;
        this.flatArea = flatArea;
        this.flatLevel = flatLevel;
        this.flatDiscription = flatDiscription;
        this.isNew = isNew;
        this.flatChars = flatChars;

    }
}
