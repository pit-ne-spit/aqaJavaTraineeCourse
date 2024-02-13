package ru.inno.course.homework9;

import java.util.Objects;

public class Player {
     private int id;
     private String nickname;
     private boolean isOnline;

    public Player(int id, String nickname, boolean isOnline) {
        this.id = id;
        this.nickname = nickname;
        this.isOnline = isOnline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && isOnline == player.isOnline && Objects.equals(nickname, player.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, isOnline);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", isOnline=" + isOnline +
                '}';
    }
}
