package ru.inno.course.homework25;
import org.apache.commons.lang3.RandomStringUtils;
public class WordGenerator {
        public static String generatedWord() {
            String randomWord = RandomStringUtils.randomAlphabetic(10);
            return randomWord;
        }
    }