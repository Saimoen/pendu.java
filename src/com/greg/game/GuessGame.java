package com.greg.game;

import java.util.ArrayList;
import java.util.List;

public class GuessGame {
    private final List<Character> secretWord = new ArrayList<>();
    private final List<Character> guessWord = new ArrayList<>();
    private int healthPoint;


    public GuessGame(String wordToGuess, int healthPoint) {
        for(char c : wordToGuess.toCharArray()) {
            this.secretWord.add(c);
        }
        this.healthPoint = healthPoint;
        for(int index = 0; index < secretWord.size(); index++) {
            this.guessWord.add('_');
        }
    }
    @Override
    public String toString() {
        return "GuessGame{" +
                "guessWord=" + guessWord +
                ", healthPoint=" + healthPoint +
                '}';
    }

    public void guessLetter(char letter) {
        if(secretWord.contains(letter) && !guessWord.contains(letter)) {
            var index = 0;
            //caractères bonne position
            for(char c : secretWord) {
                if(c == letter) {
                    //remplace _ par la lettre trouvée
                    guessWord.set(index, c);
                }
                index++;
            }
        } else {
            healthPoint -= 1;
        }
    }

    public boolean isLost() {
        return healthPoint <= 0;
    }

    public boolean isWon() {
        return !guessWord.contains('_');
    }
}
