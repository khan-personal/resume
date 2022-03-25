/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL PROJECT
 */
package hanner_finalproject;

import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

public class BesterController 
{   //variables
    int roll0;
    int roll1;
    int roll2;
    int roll3;
    int roll4;
    String play;
    String toss;
    String restart;
    int sum;
    int sumCompu;
    int sumHuman;
    int wager;//gold bet
    int multiplier = 2;//multiplier if won
    int result;//amount to be added/taken from gold
    boolean win = false;
    
    //declare array
    int[][] compuRoll = new int[5][6];
    int[][] humanRoll = new int[5][6];
    
    //keyboard scanner
    Scanner keyboard = new Scanner(System.in);
    
    Admin admin = new Admin();
    SoundUtils beeps = new SoundUtils();
    
    public void game() throws InterruptedException, LineUnavailableException
    {
        
        
        //ADD RULES        
        System.out.println("\nWould Yousir like to begin? [Yes] or [No]");
        play = keyboard.next().toUpperCase();
        
        if ("YES".equals(play))
        {
            sum = 0;
            sumCompu = 0;
            sumHuman = 0;
            win = false;
            result = 0;
            wager = 0;
            
            System.out.println("\nHow much gold would Yousir like to bet?");
            wager = keyboard.nextInt();
            
            System.out.println("\n----ROUND ONE----");
            rollComputer1();
            rollHuman1();
            System.out.println("Would Yousir like to roll again? [Yes] or [No]");
            play = keyboard.next().toUpperCase();
            if ("YES".equals(play))
            {
                System.out.println("\n----ROUND TWO----");
                rollComputer2();
                rollHuman2();
                multiplier = 1;
            }
            else if ("NO".equals(play))
            {
                System.out.println("\n----ROUND TWO----");
                rollComputer2();
            }
            else
            {
                System.out.println("I don't understand, can you try again?.");
                game();
            }              
        }
        else if ("NO".equals(play))
        {
            terminateProgram();
        }
        else
        {
            System.out.println("I don't understand, can you try again?.");
            game();
        }        
        if (sumCompu > sumHuman)
        {
            System.out.println("\n\n----SCORES----"
                   + "\nGAMBLER: " + sumCompu
                   + "\nYOUSIR: " + sumHuman);
            beeps.error();
            result = wager - (wager * 2);
            System.out.println("\nThe Gambler rolled a higher score than Yousir. Yousir lost " + wager + " gold.");
        }
        else if (sumHuman > sumCompu)
        {
            System.out.println("\n\n----SCORES----"
                   + "\nGAMBLER: " + sumCompu
                   + "\nYOUSIR: " + sumHuman);            
            beeps.correct();
            result = wager * multiplier;
            System.out.println("\nYousir scored higher than the Gambler. Yousir won " + result + " gold!");
            win = true;
        }            
    }
    
    public void restart() throws InterruptedException, LineUnavailableException
    {
        System.out.println("Would Yousir like to restart the game? Y or N");
        restart = keyboard.next().toUpperCase();
        if ("Y".equals(restart))
        {
            game();
        }
        else if ("N".equals(restart))
        {
            terminateProgram();
        }
        else
        {
            System.out.println("Invalid input...");
            restart();
        }
    }
    
    public void rollComputer1() throws InterruptedException, LineUnavailableException
    {
        beeps.low();
        System.out.println("\nThe Gambler is rolling their dice...");
        Thread.sleep(2000);
        //roll dice, calculate sum
        roll0 = (int)(Math.random() * (6) + 1);
        roll1 = (int)(Math.random() * (6) + 1);
        roll2 = (int)(Math.random() * (6) + 1);
        roll3 = (int)(Math.random() * (6) + 1);
        roll4 = (int)(Math.random() * (6) + 1);
        sum = roll0 + roll1 + roll2 + roll3 + roll4;
        System.out.println("\tThe Gambler rolled a " + roll0 + ", " + roll1 + ", "
                           + roll2 + ", " + roll3 + ", and " + roll4 + "."
                           + "\n\tThe Gambler's score this turn is: " + sum);
        
        //set rolls and sum to array
        compuRoll[0][0] = roll0;
        compuRoll[0][1] = roll1;
        compuRoll[0][2] = roll2;
        compuRoll[0][3] = roll3;
        compuRoll[0][4] = roll4;
        compuRoll[0][5] = sum;
        
        //set total sum
        sumCompu = compuRoll[0][5];        
        System.out.println("\tThe Gambler's total score is: " + sumCompu);
        
    }
    
    public void rollComputer2() throws InterruptedException, LineUnavailableException
    {
        beeps.low();
        System.out.println("\nThe Gambler is rolling their dice...");
        Thread.sleep(3000);
        //roll dice, calculate sum
        roll0 = (int)(Math.random() * (6) + 1);
        roll1 = (int)(Math.random() * (6) + 1);
        roll2 = (int)(Math.random() * (6) + 1);
        roll3 = (int)(Math.random() * (6) + 1);
        roll4 = (int)(Math.random() * (6) + 1);
        sum = roll0 + roll1 + roll2 + roll3 + roll4;
        System.out.println("\tThe Gambler rolled a " + roll0 + ", " + roll1 + ", "
                           + roll2 + ", " + roll3 + ", and " + roll4 + "."
                           + "\n\tThe Gambler's score this turn is: " + sum);        
                
        //set rolls and sum to array
        compuRoll[1][0] = roll0;
        compuRoll[1][1] = roll1;
        compuRoll[1][2] = roll2;
        compuRoll[1][3] = roll3;
        compuRoll[1][4] = roll4;
        compuRoll[1][5] = sum;
        
        //set total sum
        sumCompu = compuRoll[0][5] + compuRoll[1][5];
        System.out.println("\tThe Gambler's total score is: " + sumCompu);
    }
  
    
    public void rollHuman1() throws LineUnavailableException
    {
        beeps.high();
        System.out.println("\nYoursir needs to roll the dice, enter [R] to roll.");
        toss = keyboard.next().toUpperCase();
        //response loop
        if ("R".equals(toss))
        {   //roll dice
            roll0 = (int)(Math.random() * (6) + 1);
            roll1 = (int)(Math.random() * (6) + 1);
            roll2 = (int)(Math.random() * (6) + 1);
            roll3 = (int)(Math.random() * (6) + 1);
            roll4 = (int)(Math.random() * (6) + 1);
            sum = roll0 + roll1 + roll2 + roll3 + roll4;
            //set rolls to array
            humanRoll[0][0] = roll0;
            humanRoll[0][1] = roll1;
            humanRoll[0][2] = roll2;
            humanRoll[0][3] = roll3;
            humanRoll[0][4] = roll4;
            humanRoll[0][5] = sum;
            //set total sum
            sumHuman = humanRoll[0][5];
            //display roll info
            System.out.println("\tYousir rolled a " + roll0 + ", " + roll1 + ", "
                               + roll2 + ", " + roll3 + ", and " + roll4 + "."
                               + "\n\tYousir score this turn is: " + sum);
            System.out.println("\tYousir total score is: " + sumHuman);
            //update user of scores
            System.out.println("\n\n----SCORES----"
                               + "\nGAMBLER: " + sumCompu
                               + "\nYOUSIR: " + sumHuman);
            
            
        }
        else
        {
            admin.error();
            rollHuman1();
        }
    }

    public void rollHuman2() throws LineUnavailableException
    {
        beeps.high();
        System.out.println("\nEnter [R] for Yousir to roll the dice.");
        toss = keyboard.next().toUpperCase();
        //response loop
        if ("R".equals(toss))
        {   //roll dice
            roll0 = (int)(Math.random() * (6) + 1);
            roll1 = (int)(Math.random() * (6) + 1);
            roll2 = (int)(Math.random() * (6) + 1);
            roll3 = (int)(Math.random() * (6) + 1);
            roll4 = (int)(Math.random() * (6) + 1);
            sum = roll0 + roll1 + roll2 + roll3 + roll4;
            //set rolls to array
            humanRoll[1][0] = roll0;
            humanRoll[1][1] = roll1;
            humanRoll[1][2] = roll2;
            humanRoll[1][3] = roll3;
            humanRoll[1][4] = roll4;
            humanRoll[1][5] = sum;
            //set total sum
            sumHuman = humanRoll[0][5] + humanRoll[1][5];   
            //display roll info
            System.out.println("\tYousir rolled a " + roll0 + ", " + roll1 + ", "
                               + roll2 + ", " + roll3 + ", and " + roll4 + "."
                               + "\n\tYousir score this turn is: " + sum);
            System.out.println("\tYousir total score is: " + sumHuman);
        }
        else
        {
            admin.error();
            rollHuman2();
        }
    }

    
    public void terminateProgram() throws LineUnavailableException
    {   //exit program
        admin.goodbye();
    }
}