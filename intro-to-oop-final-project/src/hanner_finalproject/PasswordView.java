/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL PROJECT
 */
package hanner_finalproject;

import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

public class PasswordView 
{
    Scanner keyboard = new Scanner(System.in);
    Random random = new Random();
    SoundUtils beep = new SoundUtils();
    
//word bank
    String[] wordBank = {"DEMONSTRATION", "CONTRADICTION", "UNDERSTANDING", "QUALIFICATION",
                         "COMPREHENSIVE", "COMMUNICATION", "PREOCCUPATION", "CONSCIOUSNESS",
                         "CONSTELLATION", "CONFRONTATION", "EMBARRASSMENT", "INVESTIGATION",
                         "REVOLUTIONARY", "STRIKEBREAKER", "SUPPLEMENTARY", "CONCENTRATION", 
                         "INAPPROPRIATE", "ENTERTAINMENT", "CONSIDERATION", "ENVIRONMENTAL"};
    
    char guess, guessUC;
    String choice;
    
    public void begin()
    {//asks user to initialize game
        System.out.println("\nWould you like to begin? YES or NO");
        choice = keyboard.nextLine().toUpperCase();
    }
    
    public void currentGuesses()
    {//displays _ _ _ _ for secretWord
        System.out.println("\n************************************************************"
                + "\nMystery Word: ");
    }
    
    public void incorrectGuesses()
    {//displays arraylist of incorrect guesses
        System.out.println("\nIncorrect letters:");
    }
    
    public void triesLeft()
    {//display header for lives left/filled hearts
        System.out.println("\n\nLives: ");
    }
    
    public void guess()
    {//prompt user for guess
        System.out.println("\n\nGuess a single letter: ");
        guess = keyboard.nextLine().charAt(0);
        guessUC = Character.toUpperCase(guess);
    }
    
    public void correctGuess() throws LineUnavailableException, InterruptedException
    {//notify user of correct guess
        beep.high();
        System.out.println("\tCorrect!");
        Thread.sleep(500);
    }
    
    public void incorrectGuess() throws LineUnavailableException, InterruptedException
    {//notify user of incorrect guess
        beep.low();
        System.out.println("\tIncorrect");
        Thread.sleep(500);
    }
    
    public void winGame() throws LineUnavailableException
    {//notify user they won the game
        beep.correct();
        System.out.println("\tCongratulations! You guessed all the letters\n\tand won the game."
                + "\n\nThe secret word was: ");
    }
    
    public void noMoreGuesses() throws LineUnavailableException
    {//notify user no more guesses
        beep.error();
        System.out.println("\nGuesses:"
                + "\n!!!!!!!"
                + "\n\t\u2620 YOU HAVE ATTRACTED TOO MUCH ATTENTION \u2620");
    }
    
    public void restart()
    {//request program restart
        System.out.println("\nWould you like to try again? YES or NO");
        choice = keyboard.nextLine().toUpperCase();
    }
    
    public void gameOverMan() throws LineUnavailableException
    {////notify user game over
        beep.error();
        System.out.println("Game over!");
    }
    
    public void invalid() throws InterruptedException
    {//notify user of invalid input
        System.out.println("\tInvalid input, try again...\n");
        Thread.sleep(500);
    }
    
    public void alreadyGuessed() throws LineUnavailableException, InterruptedException
    {//notify user this char has already been guessed
        beep.error();
        System.out.println("\t...but you have already guessed that letter.");
        Thread.sleep(1500);
    }
}