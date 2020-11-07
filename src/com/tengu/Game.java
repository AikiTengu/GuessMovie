package com.tengu;

import java.io.FileNotFoundException;

public class Game {

    private int numberOfTries;
    private int userTries;
    private String stringUserGuesses[];
    public Movie movie;
    public boolean isWon;

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(int numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    public int getUserTries() {
        return userTries;
    }

    public void setUserTries(int userTries) {
        this.userTries = userTries;
    }

    public String[] getStringUserGuesses() {
        return stringUserGuesses;
    }
//adding a symbol to the array of tries and checking if it is valid. Unhiding the title
    public void addStringUserGuesses(String string,int index) {
            stringUserGuesses[index] = string;
            char tempChar = string.charAt(0);
            int guessedSymbolPosition = -1;
                for (int i = 0; i < movie.getTitle().length(); i++)
                 if (movie.getTitle().charAt(i) == string.charAt(0)) {//guessedSymbolPosition = movie.getTitle().indexOf(string.charAt(0), 0);
                //if (guessedSymbolPosition != -1) {
                    guessedSymbolPosition = i;
                    String tempString = movie.getUnderscoredtitle();
                    char[] tempStringChar = tempString.toCharArray();
                    tempStringChar[guessedSymbolPosition] = string.charAt(0);
                    tempString = String.valueOf(tempStringChar);
                    movie.setUnderscoredtitle(tempString);
                }
    }

//Printing out the array of user tries
    public String showTries(int index) {
        String stringResult = "";
        for (int i = 0; i < index; i++) {
            stringResult += stringUserGuesses[i];
        }
        return stringResult;
    }

//Working around FNF exception
    public Game() throws FileNotFoundException {
        this.numberOfTries = 20;
        this.userTries = numberOfTries;
        stringUserGuesses = new String[100];
        movie = new Movie();
        movie.readTitleFromFile("Movies.txt");
    }
}
