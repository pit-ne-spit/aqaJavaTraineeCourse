package ru.inno.course;

public class Room {

    String roomName;
    float roomArea;
    boolean isWarmFloor;
    int roomWeight;
    float wallHeight;


    public Room(String roomName, float roomArea, boolean isWarmFloor, int roomWeight) {
        this.roomName = roomName;
        this.roomArea = roomArea;
        this.isWarmFloor = isWarmFloor;
        this.roomWeight = roomWeight;
    }


}
