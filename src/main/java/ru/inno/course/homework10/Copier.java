package ru.inno.course.homework10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Copier {
    private String inputPath;
    private String outputPath;

    public static void copyFile(String inputPath, String outputPath) throws IOException {

        Path inputFile = Path.of(inputPath);
        Path outputFile = Path.of(outputPath);
        Files.copy(inputFile, outputFile, StandardCopyOption.REPLACE_EXISTING);

    }
    public static boolean isExistCopyFile(String outputPath) {
        Path outputFile = Path.of(outputPath);
        boolean fileExists = Files.exists(outputFile);
        return fileExists;
    }

    public static Integer copyCounter () throws IOException {
        Path filePath = Path.of("src/resources/counterFile.txt");

        if (Files.exists(filePath)) {
            String stringCount = Files.readString(filePath);
            int numberOfCopy;
            try {
                numberOfCopy = Integer.parseInt(stringCount);
            } catch (Exception e) {
                numberOfCopy = 1;
            }
            numberOfCopy++;
            Files.writeString(filePath, Integer.toString(numberOfCopy));
            return numberOfCopy;
        }
        else {
            Files.writeString(Path.of("src/resources/counterFile.txt"), "0");

        }
        return null;
    }




}
