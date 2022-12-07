package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    final String path = "TODO";
    String line = "";

    void run() throws IOException {
        readLine();
        printCharacterCount();
    }

    void printCharacterCount() {
        String slidingWindow = line.substring(0, 1);
        int slidingWindowMaxSize = 14;

        int i = 1;
        while (i < line.length()) {
            char newChar = line.charAt(i);

            int indexInSlidingWindow = slidingWindow.indexOf(newChar);
            slidingWindow += newChar;

            if (indexInSlidingWindow != -1) {
                slidingWindow = slidingWindow.substring(indexInSlidingWindow+1);
            }
            i++;

            if (slidingWindow.length() == slidingWindowMaxSize) {
                System.out.printf("Found at position: %s", i);
                break;
            }

        }

    }

    void readLine() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(this.path + "input.txt"))) {
            line = br.readLine();
        }
    }
}