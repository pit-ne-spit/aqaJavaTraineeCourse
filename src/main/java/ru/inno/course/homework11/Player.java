package ru.inno.course.homework11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Player {

    private int id;
    private String nick;
    private int points;
//    private Set <Player> playersList;
//
//    public Set<Player> getPlayersList() {
//        return playersList;
//    }
//
//    public void setPlayersList(Set<Player> playersList) {
//        this.playersList = playersList;
//    }

    public Player(int id, String nick, int points) {
        this.id = id;
        this.nick = nick;
        this.points = points;
    }
    public Player() {}

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return getId() == player.getId() && getPoints() == player.getPoints() && Objects.equals(getNick(), player.getNick());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNick(), getPoints());
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", points=" + points +
                "}'";
    }
}