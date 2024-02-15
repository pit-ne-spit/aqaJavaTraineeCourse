package ru.inno.course.homework11;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PlayerServiceJSON implements PlayerService{

    Set<Player> players = new HashSet<>();
    @Override
    public Player getPlayerById(int id) {
        return null;
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public int createPlayer(String nickname) {
        int i = 0;
        if (players.size() == 0) {
            i = 1;
            players.add(new Player(i, nickname, 0));
            return i;
        } else {
            if (uniqueNick(nickname)){
                Collection<Player> players = getPlayers();
                for (Player player : players) {
                    i = player.getId() + 1;
                }
                players.add(new Player(i, nickname, 0));
                return i;
            }
            else {
                System.out.println("Nick \"" + nickname + "\" is already exist. Please, try another one.");
            }
            return i;
        }
    }

    @Override
    public Player deletePlayer(int id) {
        return null;
    }

    @Override
    public int addPoints(int playerId, int points) {
        return 0;
    }

    public boolean uniqueNick(String nickname) {
        boolean isNickUnique = true;
        for (Player player : players) {
            if (player.getNick().equals(nickname)) {
                isNickUnique = false;
            }
        }
        return isNickUnique;
    }
}
