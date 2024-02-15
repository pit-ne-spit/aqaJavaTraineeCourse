package ru.inno.course.homework11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class SandboxJSON implements PlayerService{

    @Override
    public Player getPlayerById(int id) {
        return null;
    }

    @Override
    public Collection<Player> getPlayers() {
        return null;
    }

    @Override
    public int createPlayer(String nickname) {
        int i = 0;
        if (draftList.size() == 0) {
            i = 1;
            draftList.add(new Player(i, nickname, 0));
            try {
                writeToFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return i;
        } else {
            try {
                if (uniqueNick(nickname)){
                    draftList.add(new Player(nextID(), nickname, 0));
                    writeToFile();
                }
                else {
                    System.out.println("Nick \"" + nickname + "\" is already exist. Please, try another one.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
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

    public static Set<Player> getDraftList() {
        return draftList;
    }

    public static Set<Player> draftList = new HashSet<>();
    public static List<Player> playersFromJSON = new ArrayList<>();
    Path filePath = Path.of("src/resources/players.json");

    public void writeToFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(filePath.toFile(), draftList);
    }
    public List<Player> readFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Player>> typeReference = new TypeReference<>() {};
        playersFromJSON = mapper.readValue(filePath.toFile(), typeReference);
        return playersFromJSON;
    }

    public boolean uniqueNick(String nickname) throws IOException {
        boolean isNickUnique = true;
        readFromFile();
        for (Player player : playersFromJSON) {
            if (player.getNick().equals(nickname)) {
                isNickUnique = false;
            }
        }
        return isNickUnique;
    }


    public int nextID() {
        Collection<Player> players = getDraftList();
        ArrayList<Integer> maxI = new ArrayList<>();

        for (Player player : players) {
            maxI.add(player.getId());
        }
        maxI.sort(Comparator.reverseOrder());
        return maxI.get(0)+1;

    }

    public static void main(String[] args) throws IOException {
        PlayerService service = new SandboxJSON();

        service.createPlayer("A");
        service.createPlayer("A");
        service.createPlayer("d");
        service.createPlayer("A");
        service.createPlayer("Aa");




    }

}
