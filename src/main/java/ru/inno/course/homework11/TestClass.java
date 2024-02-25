package ru.inno.course.homework11;

import java.util.Collection;

public class TestClass {

    public static void main(String[] args) {
        PlayerService service = new PlayerServiceJSON();

        int playerId = service.createPlayer("WinMasfgdfgter_777");
        int playerId1 = service.createPlayer("WinMasdfgter_777");
        service.addPoints(1, 1500);
        System.out.println(service.getPlayerById(2));        ;

//        Collection<Player> players = service.getPlayers();
//        for (Player player : players) {
//            System.out.println(player);
//        }

    }
}