/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL PROJECT
 */
package hanner_finalproject;

import javax.sound.sampled.LineUnavailableException;

public class Hanner_FinalProject 
{
    public static void main(String[] args) throws LineUnavailableException, InterruptedException 
    {
        Admin admin = new Admin();
        GameController game = new GameController();
        admin.welcome();
        game.initialize();
    }
    
}
