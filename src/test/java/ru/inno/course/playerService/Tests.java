package ru.inno.course.playerService;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.inno.course.homework11.Player;
import ru.inno.course.homework11.PlayerService;
import ru.inno.course.homework11.PlayerServiceJSON;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;

public class Tests {
    static Path filePath = Path.of("src/resources/players.json");
    private PlayerService service;
    private ObjectMapper mapper;
    @BeforeEach
    public void setUp() throws IOException {
        service = new PlayerServiceJSON();
        mapper = new ObjectMapper();
        Files.deleteIfExists(filePath);
    }
    @AfterEach
    public void tearDown() throws IOException {
        Files.delete(filePath);
    }
    @Test
    //Проверяем, что игрок добавляется, если файла нет
    public void noFile() throws IOException {
        int noFilePlayer = service.createPlayer("noFilePlayer");
        List<Player> playerFromFile = mapper.readValue(filePath.toFile(), new TypeReference<List<Player>>(){});
        System.out.println(service.getPlayerById(noFilePlayer).equals(playerFromFile.get(0)));

    }

    @Test
    //Проверяем, что игрок добавляется, если файл пустой
    public void emptyFile() throws IOException {
        Files.createFile(filePath);
        int playerInEmptyFile = service.createPlayer("playerInEmptyFile");
        List<Player> playerFromEmptyFile = mapper.readValue(filePath.toFile(), new TypeReference<List<Player>>(){});
        System.out.println(service.getPlayerById(playerInEmptyFile).equals(playerFromEmptyFile.get(0)));
        System.out.println(service.getPlayerById(playerInEmptyFile));
        System.out.println(playerFromEmptyFile.get(0));
    }

    @Test
    //Проверяем, что игрок добавляется, если файл уже содержит записи с другими игроками
    public void notAlone () throws IOException {
        int playerOne = service.createPlayer("playerOne");
        int playerTwo = service.createPlayer("playerTwo");
        List<Player> playersFromFile = mapper.readValue(filePath.toFile(), new TypeReference<List<Player>>(){});
        System.out.println(service.getPlayerById(playerTwo).equals(playersFromFile.get(1)));

    }
    @Test
    //Проверяем, что нельзя добавить игрока с таким же ником
    public void nickUnique() throws IOException {
        int playerOne = service.createPlayer("playerOne");
        int playerTwo = service.createPlayer("playerOne");
        List<Player> playersFromFile = mapper.readValue(filePath.toFile(), new TypeReference<List<Player>>(){});
        System.out.println(playersFromFile.size() == 1);

    }

    @Test
    //Проверяем, что игрок удаляется по id
    public void deletePlayerById() throws IOException {
        int playerOne = service.createPlayer("playerOne");
        int playerTwo = service.createPlayer("playerTwo");
        List<Player> playersFromFileBeforeDelete = mapper.readValue(filePath.toFile(), new TypeReference<List<Player>>(){});
        System.out.println(playersFromFileBeforeDelete.size() == 2);
        service.deletePlayer(playerOne);
        List<Player> playersFromFileAfterDelete = mapper.readValue(filePath.toFile(), new TypeReference<List<Player>>(){});
        System.out.println(playersFromFileAfterDelete.size() == 1);
    }
    @Test
    //Проверяем, что игрок удаляется если он последний
    public void deleteAlnePlayer() throws IOException {
        int playerOne = service.createPlayer("playerOne");
        List<Player> playersFromFileBeforeDelete = mapper.readValue(filePath.toFile(), new TypeReference<List<Player>>(){});
        System.out.println(playersFromFileBeforeDelete.size() == 1);
        service.deletePlayer(playerOne);
        List<Player> playersFromFileAfterDelete = mapper.readValue(filePath.toFile(), new TypeReference<List<Player>>(){});
        System.out.println(playersFromFileAfterDelete.size() == 0);

    }
    @Test
    //Удалить несуществующего игрока
    public void deleteNotExistsPlayer() throws IOException {
        int playerOne = service.createPlayer("playerOne");
        int playerTwo = 3;
            List<Player> playersFromFileBeforeDelete = mapper.readValue(filePath.toFile(), new TypeReference<List<Player>>() {});
            System.out.println(playersFromFileBeforeDelete.size() == 1);
            // Перехватываем NoSuchElementException
            try {
                new Exception(String.valueOf(service.deletePlayer(playerTwo)));
            } catch (NoSuchElementException e) {
                System.out.println("Исключение NoSuchElementException: " + e.getMessage());
                // Другие действия по обработке исключения здесь
            }
    }

}
