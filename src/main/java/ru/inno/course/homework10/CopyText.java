package ru.inno.course.homework10;

import java.io.IOException;

public class CopyText {

    public static void main(String[] args) throws IOException {

        String fileToCopy = "src/resources/inputFile.pdf";
        String fileToCreate = "src/resources/outputFile.pdf";
        String fileToCreateIfExist = "src/resources/outputFile (" + Copier.copyCounter() + ").pdf";

        if (Copier.isExistCopyFile(fileToCreate)) {
            Copier.copyFile(fileToCopy, fileToCreateIfExist);
        }
        else {
            Copier.copyCounter();
            Copier.copyFile(fileToCopy, fileToCreate);
        }
    }

}
