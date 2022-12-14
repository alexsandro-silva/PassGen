package com.arsilva.passgen.models;

import java.util.Random;

public class Generator {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%&*()-_=+~^";

    private int passwordLength;
    private boolean hasUppercaseLetters;
    private boolean hasLowercaseLetters;
    private boolean hasNumbers;
    private boolean hasSymbols;

    public Generator() {
        super();
    }

    public void configure(int passwordLength, boolean hasUppercaseLetters, boolean hasLowercaseLetters,
                          boolean hasNumbers, boolean hasSymbols) throws Exception{
        if (passwordLength == 0) {
            throw new Exception("Password length must be informed");
        }

        this.passwordLength = passwordLength;
        this.hasUppercaseLetters = hasUppercaseLetters;
        this.hasLowercaseLetters = hasLowercaseLetters;
        this.hasNumbers = hasNumbers;
        this.hasSymbols = hasSymbols;
    }

    private int getRandom(int upperbound) {
        var random = new Random();
        return random.nextInt(upperbound);
    }


    private char generateX() {
        String x = "";

        if (hasUppercaseLetters) {
            x += Generator.UPPERCASE_LETTERS;
        }
        if (hasLowercaseLetters) {
            x += Generator.LOWERCASE_LETTERS;
        }
        if(hasNumbers) {
            x += Generator.NUMBERS;
        }
        if (hasSymbols) {
            x += Generator.SYMBOLS;
        }

        return x.charAt(getRandom(x.length()));
    }

    public String generate() {
        String pwd = "";

        for (int i = 0; i < passwordLength; i++) {
            pwd += generateX();
        }

        return pwd;
    }
}
