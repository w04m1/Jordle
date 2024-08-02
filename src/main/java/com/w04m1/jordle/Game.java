package com.w04m1.jordle;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private int attempts = 6;
    private boolean win;
    private final int wordLength;
    private final Word word;
    private final Renderer renderer = new Renderer();
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        this(5);
    }

    public Game(int wordLength) {
        this.wordLength = wordLength;
        this.word = new Word(this.wordLength);
        setUpGame();
    }

    private void resetStat() {
        attempts = 6;
        win = false;
    }

    private void playRound() {
        renderer.sendGuessMessage();
        String guess = scanner.next();
        if (guess.length() != wordLength) {
            renderer.sendErrorMessage(wordLength);
            return;
        }
        try {
            word.compare(guess);
        } catch (WrongLengthException e) {
            // nothing to handle
        }
        win = Arrays.stream(word.getStatus()).allMatch(status -> status == Status.CORRECT);
        renderer.drawGuess(guess.toCharArray(), word.getStatus());
        if (!win) attempts--;
    }

    private boolean promptContinue() {
        renderer.sendContinueMessage();
        String input = scanner.next();
        while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
            renderer.sendInvalidInputMessage();
            input = scanner.next();
        }
        return input.equalsIgnoreCase("y");
    }

    public void startGame() {
        do {
            resetStat();
            while (attempts > 0 && !win) {
                playRound();
                if (win) break;
            }
            renderer.displayEndGameMessage(win);
            if (promptContinue()) {
                this.word.changeWord();
            } else {
                renderer.sendByeMessage();
                break;
            }
        } while (true);
    }

    private void setUpGame() {
        renderer.sendWelcomeMessage();
    }
}
