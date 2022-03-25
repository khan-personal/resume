/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL PROJECT
 */
package hanner_finalproject;

import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;

public class PasswordController 
{
    PasswordView input = new PasswordView();
    Admin admin = new Admin();
    Random random = new Random();
    boolean win = false;
    boolean fail = false;
    boolean choice = false;
    
    public void initialize() throws LineUnavailableException, InterruptedException
    {
        input.begin();
        if ("YES".equals(input.choice))
        {
            game();
        }
        else if ("NO".equals(input.choice))
        {
            System.out.println("\nYousir decides not to play.");
            choice = true;
        }
        else
        {
            input.invalid();
            initialize();
        }
    }
    
    public void game() throws LineUnavailableException, InterruptedException
    {
        boolean play = true;
        boolean wordIsGuessed = false;
        int tries = 7;//aka hearts
        
        while (play)
        {
            int chooser = random.nextInt(input.wordBank.length);//selects random number
            char[] secretWord = input.wordBank[chooser].toCharArray();//breaks word in to chars
            int missingLetters = secretWord.length; //total tries to guess a word
            char playerGuess[] = new char[missingLetters]; // "_ _ _ _ _"
            ArrayList<Character> incGuesses = new ArrayList<>();
            char separatorChar = ' ';
            String separator = String.valueOf(separatorChar);
            boolean contains = false;//char finder loop
            
            for (int i = 0; i < playerGuess.length; i++)//assign _ for char array
            {
                playerGuess[i] = '_';
            }
            
            //the game
            while (!wordIsGuessed && tries > 0)
            {
                //build secretWord word as _ char with spaces
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < playerGuess.length - 1; i++)
                {
                    stringBuilder.append(playerGuess[i]);
                    stringBuilder.append(separator);
                }            
                stringBuilder.append(playerGuess[playerGuess.length - 1]);
                String joined = stringBuilder.toString();
                
//    System.out.println(secretWord);//to troubleshoot
                
                input.currentGuesses();
                System.out.println(joined);
                
                input.incorrectGuesses();
                for (int i = 0; i < incGuesses.size(); i++) 
                {
                    System.out.print(incGuesses.get(i));
                }
            
            //displays full/empty hearts to convey tries left    
                input.triesLeft();
                //print x full ?
                for (int i = 0; i < tries; i++)
                {
                    System.out.print("?");
                }
                //print 7 - x !
                for (int i = 0; i < (7 - tries); i++)
                {
                    System.out.print("!");
                }
            
            //guess logic, if correct replace '_' with guess. if incorrect add to incGuesses arraylist    
                try //solves no input error
                {
                    input.guess(); //displays guess prompt, collects input.guess and sets to uppercase at inpunt.guessUC                
                    if (input.guess == '-') //exit char
                    {
                        wordIsGuessed = true;
                        play = false;
                    }
                    else if (Character.isLetter(input.guess) == true)//checks to make sure input is valid
                    {
                        for (char c : secretWord)
                        {
                            contains = false; //incorrect guess escapes next loop

                            if (c == input.guessUC)
                            {
                                contains = true;
                                input.correctGuess();//displays correct message
                                for (int i = 0; i < secretWord.length; i++)
                                {
                                    if (playerGuess[i] == input.guessUC)
                                    {
                                        input.alreadyGuessed();  
                                        break;
                                    }
                                    else if (secretWord[i] == input.guessUC)
                                    {
                                        
                                        playerGuess[i] = input.guessUC; //fills in correct guess in place of _ for secretWord                                   
                                    }
                                }
                                break;
                            }
                        }
                        if (!contains)
                        {
                            if (incGuesses.contains(input.guessUC))
                            {
                                input.incorrectGuess();
                                input.alreadyGuessed();
                            }
                            else 
                            {
                                tries--;
                                input.incorrectGuess();//displays incorrect message
                                incGuesses.add(input.guessUC);
                                incGuesses.add(' ');                                
                            }
                        }
                        if (isTheWordGuessed(playerGuess))
                        {
                            wordIsGuessed = true;
                            input.winGame();
                            System.out.println(secretWord);
                            win = true;
                            return;
                        }
                    }
                    else
                    {
                        input.invalid();
                    }
                }
                catch (StringIndexOutOfBoundsException e)//solves no input error
                {
                    input.invalid();
                }
            }//end of game
        
            if (!wordIsGuessed)
            {
                input.noMoreGuesses();
                fail = true;
                break;
            }
//            
//            input.restart();
//            
//            if (input.choice.equals("YES"))
//            {
//                game();
//            }
//            
//            if(input.choice.equals("NO"))
//            {
//                play = false;
//            }  
        }       
    }
    
//    public void endGame() throws LineUnavailableException
//    {
//        input.gameOverMan();
//        System.exit(0);
//    }
    
    
    public static boolean isTheWordGuessed(char[] array)
    {
        boolean condition = true;
        for(int i = 0; i < array.length; i++)
        {
            if (array[i] == '_')
            {
                condition = false;
            }
        }
        return condition;
    }
    
//    public void terminateProgram() throws LineUnavailableException
//    {
//        admin.goodbye();
//        System.exit(0);
//    }
    
}
