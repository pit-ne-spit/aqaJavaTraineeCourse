package ru.inno.course.homework9;

import java.util.HashSet;
import java.util.Set;

public class Players {


    public static void main(String[] args) {

        Player player1 = new Player(1,"Killa12", false);
        Player player2 = new Player(1,"Killa12", false);

        System.out.println(player1==player2);
        System.out.println(player1.equals(player2));

        Set<Player> playersListSet = new HashSet<>();
        playersListSet.add(new Player(1,"MegaKilla", false));
        playersListSet.add(new Player(2,"UltraKilla2", false));
        playersListSet.add(new Player(3,"SuperKilla_88", false));
        playersListSet.add(new Player(3,"SuperKilla_88", false));
        playersListSet.add(new Player(4,"K0teG12", false));
        playersListSet.add(new Player(5,"Dancing Potato", false));
        playersListSet.add(new Player(6,"Flying banana_b_boy", false));
        playersListSet.add(new Player(6,"Flying banana_b_boy", false));
        playersListSet.add(new Player(7,"Lonely_Stranger", false));
        playersListSet.add(new Player(8,"Spirit", false));
        playersListSet.add(new Player(8,"Spirit", false));
        playersListSet.add(new Player(9,"BroniBoy", false));
        playersListSet.add(new Player(10,"Here_I_am", false));
        playersListSet.add(new Player(10,"Here_I_am", false));

    }
}
