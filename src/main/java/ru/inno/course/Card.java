package ru.inno.course;

public class Card {
    private String cardNumber;
    private String expiryDate;
    private int cvv;
    private int pinCode;

    public Card(String number, String expiryDate, int cvv, int pinCode) {
        this.cardNumber = number;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.pinCode = pinCode;
    }

    public String hiddenNumber(){
        int numberLength = cardNumber.replaceAll(" ", "").length();
        String replaceStars = "*".repeat(numberLength-4);
        return (replaceStars + cardNumber.substring(cardNumber.length() - 4)).replaceAll("(.{4})", "$1 ");
    }

    public String pinCodeChecker(int enteredPinCode) {
        String check = enteredPinCode == this.pinCode ? cardNumber : "Пин код не подходит";
        return check;
    }
}
