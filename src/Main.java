import com.greg.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        //Sélectionne un mot aléatoirement
        final var random = new Random();
        final var words = "Salut je m'appelle gregory".split(" ");
        final var wordToGuess = words[random.nextInt(words.length)];
        final var game = new GuessGame(wordToGuess, 10);

        //Lance la partie
        System.out.println("Début de la partie !");

        //Cours de la partie
        while (true) {
            System.out.println(game);
            System.out.println("Entrez une ligne :");
            final var letter = scanner.nextLine().charAt(0);

            //Vérifie la lettre que l'utilisateur entre
            game.guessLetter(letter);

            //Condition de victoire/défaite
            if(game.isLost()) {
                System.out.println(game);
                System.out.println("Perdu !");
                break;
            }

            if(game.isWon()) {
                System.out.println(game);
                System.out.println("Gagné !");
                break;
            }

        }
    }
}