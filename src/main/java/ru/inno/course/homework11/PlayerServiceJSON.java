package ru.inno.course.homework11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PlayerServiceJSON implements PlayerService{

    public static Collection<Player> players = new ArrayList<>();
    public static Collection<Player> playersFromJSON = new ArrayList<>();
    static Path filePath = Path.of("src/resources/players.json");
    @Override
    public Player getPlayerById(int id) {
        Player targetPlayer = null;
        try {
            for (Player player : readFromFile()) {
                if (player.getId() == id) {
                    targetPlayer = player;
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (targetPlayer == null) {
            throw new NoSuchElementException("No player with this id");
        }
        return targetPlayer;
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public int createPlayer(String nickname) {
        int i = 0;
        try {
            deleteEmptyFile(filePath, nickname);
            if (Files.notExists(filePath))
            {
                Files.createFile(Path.of(String.valueOf(filePath)));
                readyPlayerOne(nickname);
                return i = 1;
            }
            else if (Files.size(filePath) == 0) {
                try {
                    readyPlayerOne(nickname);
                    return i = 1;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                try {
                    if (uniqueNick(nickname)){
                        players = readFromFile();
                        players.add(new Player(nextID(), nickname, 0));
                        writeToFile(players);
                        return i = nextID();
                    }
                    else {
                        System.out.println("Nick \"" + nickname + "\" is already exist. Please, try another one.");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    @Override
    public Player deletePlayer(int id) {
        Collection<Player> players = null;
        Player deletedPlayer = null;
        try {
            players = readFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Player player : players) {
            if (player.getId() == id) {
                deletedPlayer = player;
                players.remove(player);
                try {
                    writeToFile(players);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        if (deletedPlayer == null) {
            throw new NoSuchElementException("No player with this id to delete");
        }
        return deletedPlayer;
    }

    @Override
    public int addPoints(int playerId, int points) {
        Collection<Player> allPlayers;
        try {
            allPlayers = readFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Player player : allPlayers) {
            if (player.getId() == playerId) {
                player.setPoints(points);
                try {
                    writeToFile(allPlayers);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            } else System.out.println("No player with target id");
        }
        return playerId;
    }

    public static void writeToFile(Collection<Player> playersList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(filePath.toFile(), playersList);
    }

    public static Collection<Player> readFromFile() throws IOException {
        if (Files.exists(filePath)) {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<Collection<Player>> typeReference = new TypeReference<>() {
            };
            playersFromJSON = mapper.readValue(filePath.toFile(), typeReference);
            return playersFromJSON;
        }
        else System.out.println("Target file is not exist");
        return null;
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


    public int nextID() throws IOException {
        Collection<Player> players = readFromFile();
        ArrayList<Integer> maxI = new ArrayList<>();

        for (Player player : players) {
            maxI.add(player.getId());
        }
        maxI.sort(Comparator.reverseOrder());
        return maxI.get(0)+1;

    }
    public static int deleteEmptyFile(Path filePath, String nickname) throws IOException {
        int i = 0;
        if (Files.exists(filePath)) {
            byte[] target = Files.readAllBytes(filePath);
            String fileContent = new String(target, StandardCharsets.UTF_8);
            if (fileContent.equals("[]")) Files.delete(filePath);
        }
        else {
            Files.createFile(Path.of(String.valueOf(filePath)));
            readyPlayerOne(nickname);
            return i = 1;
        }
        return i;
    }

    public static void readyPlayerOne (String nickname) throws IOException {
        int i = 1;
        players.add(new Player(i, nickname, 0));
        writeToFile(players);
    }
}
