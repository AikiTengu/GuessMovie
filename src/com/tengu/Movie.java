package com.tengu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movie {

    private String title;
    private String underscoredtitle;

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getUnderscoredtitle() {
        return underscoredtitle;
    }

    public void setUnderscoredtitle(String underscoredtitle) {
        this.underscoredtitle = underscoredtitle;
    }

    //reading title from file
    public void readTitleFromFile(String fileName)throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        Scanner scanner2 = new Scanner(file);
        //Counting titles

        int titleCount = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            titleCount++;
        }

        //Randomly picking up a title
        int pickedTitleIndex = (int) ((Math.random() * titleCount) + 1);

        titleCount = 0;

        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            titleCount++;
            if (titleCount == pickedTitleIndex) {
                this.setTitle(line);
                break;
            }
        }
        //Hiding the title
        this.underscoredtitle = this.getTitle().replaceAll("[a-zA-Z]", "_");
        }
    }

