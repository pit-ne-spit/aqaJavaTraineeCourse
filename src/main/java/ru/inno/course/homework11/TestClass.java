package ru.inno.course.homework11;

import java.util.Collection;

public class TestClass {

    public static void main(String[] args) {
        PlayerService service = new PlayerServiceJSON();

        int playerId = service.createPlayer("WinMaster_7977");
        service.createPlayer("WinM7");
        service.createPlayer("WinewM7");
        service.createPlayer("WinewM7");
        System.out.println(playerId);
        service.addPoints(playerId, 100);



        Collection<Player> players = service.getPlayers();
        for (Player player : players) {
            System.out.println(player);
        }


    }
}