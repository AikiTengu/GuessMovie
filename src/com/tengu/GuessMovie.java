package com.tengu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessMovie {


    public static void main(String[] args) {
        try {
            Game game1 = new Game();
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < game1.getNumberOfTries(); i++) {
               // System.out.println("Guessed title: " + game1.movie.getTitle());
                System.out.println("Hidden title: " + game1.movie.getUnderscoredtitle());
                System.out.println("You have " + game1.getUserTries() + " tries left.");
                System.out.println("Your previous tries: " + game1.showTries(i));
                System.out.println("Try to guess a letter: ");
                game1.addStringUserGuesses(scanner.nextLine(), i);
                if (game1.movie.getUnderscoredtitle().equals(game1.movie.getTitle())) {
                    System.out.println("You won!");
                    System.out.println("Press any key to continue...");
                    scanner.nextLine();
                    return;
                }
                game1.setUserTries(game1.getUserTries()-1);
                System.out.flush();
            }
            System.out.println("You lost!");
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
    }
    }


}
