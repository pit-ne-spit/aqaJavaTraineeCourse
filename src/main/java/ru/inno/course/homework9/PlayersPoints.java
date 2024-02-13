package ru.inno.course.homework9;

import java.util.*;

public class PlayersPoints {
    public static void main(String[] args) {
        Map<Player, Integer> points = new HashMap<>();

        Player player1 = (new Player(1, "Bonch", false));
        Player player2 = (new Player(2, "Bru", false));
        Player player3 = (new Player(3, "Bonch", false));
        Player player4 = (new Player(4, "Badb0y", false));
        Player player5 = (new Player(5, "K0nFeTkA12", false));
        Player player6 = (new Player(6, "UltraKilla14", false));
        Player player7 = (new Player(7, "Dead_Banana", false));
        Player player8 = (new Player(8, "Dancing Potato", false));
        Player player9 = (new Player(9, "to da left", false));
        Player player10 = (new Player(10, "Aladdin", false));

        points.put(player1, 0);
        points.put(player2, 0);
        points.put(player3, 0);
        points.put(player4, 0);
        points.put(player5, 0);
        points.put(player6, 0);
        points.put(player7, 0);
        points.put(player8, 0);
        points.put(player9, 0);
        points.put(player10, 0);

        points.replace(player4, 10);
        points.replace(player7, 12);
        points.replace(player8, 11);
        points.replace(player9, 13);
        points.replace(player10, 15);

        List<Map.Entry<Player, Integer>> listToSort = new ArrayList<>(points.entrySet());
        listToSort.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (int i = 0; i < 3; i++) {
            System.out.println(listToSort.get(i));
        }
    }
}
