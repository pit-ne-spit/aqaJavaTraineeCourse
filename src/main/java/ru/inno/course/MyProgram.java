package ru.inno.course;

public class MyProgram {

    public static void main(String[] args) {
        // Создаем объект класса Room
        Room livingRoom = new Room("Living room", 26.5F, true, 1);
        Room kitchen = new Room("Kitchen", 9F, false, 1);
        Room bedroom = new Room("Bedroom", 12.9F, false,1);

        // Создаем объект класса FlatChars
        FlatChars allFlatChars = new FlatChars("Bricks", 2.9F);

        // Создаем объект класса Flat, в который складываем общее кол-во комнат, номер квартиры, общую площадь, этаж,
        // описание квартиры, новая она или нет и объект класса с указанием материала стен и высоты потолков
        Flat flat33 = new Flat(livingRoom.roomWeight +kitchen.roomWeight +bedroom.roomWeight, 33,
                livingRoom.roomArea+ kitchen.roomArea+ bedroom.roomArea, 4,
                "Best flat ever", true, allFlatChars);

        System.out.println("Комнат в квартире: " + flat33.roomsCount + "\n" +
                            "Общая площадь квартиры составлят: " + flat33.flatArea + " кв.м." + "\n" +
                            "Высота потолков: " + flat33.flatChars.wallHeigth + " м" + "\n" +
                            "Материал стен в квартире: " + flat33.flatChars.wallMaterial);
    }
}
