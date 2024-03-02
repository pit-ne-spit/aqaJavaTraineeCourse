package ru.inno.course.homework11;

import java.util.Collection;

public class TestClass {

    public static void main(String[] args) {
        PlayerService service = new PlayerServiceJSON();

        int playerId = service.createPlayer("WinMaster_777");
        service.addPoints(playerId, 1500);


        Collection<Player> players = service.getPlayers();
        for (Player player : players) {
            System.out.println(player);
        }



    }
}