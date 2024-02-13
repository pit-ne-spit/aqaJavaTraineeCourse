package ru.inno.course.homework10;

import java.io.IOException;

public class CopyText {

    public static void main(String[] args) throws IOException {

        String fileToCopy = "src/resources/inputFile.pdf";
        String fileToCreate = "src/resources/outputFile.pdf";
        String fileToCreateIfExist = "src/resources/outputFile (" + Copier.copyCounter() + ").pdf";


        if (Copier.isExistCopyFile(fileToCreate)) {
            try {
            Copier.copyFile(fileToCopy, fileToCreateIfExist);
        } catch (IOException e) {
                System.out.println(e + "Ошибка на этапе проверки экземпляра output файла");
            }
        }
        else {
            try {
            Copier.copyCounter();
            Copier.copyFile(fileToCopy, fileToCreate);
        } catch (IOException e) {
                System.out.println((e + "Ошибка на этапе создания экземпляра output файла"));
            }
        }
    }

}
