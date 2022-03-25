/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL EXAM
 */
package hanner_finalexam;

import javax.sound.sampled.LineUnavailableException;

public class Admin 
{
    SoundUtils beep = new SoundUtils();
    
    public void welcome() throws LineUnavailableException
    {
        beep.correct();
        System.out.println("Welcome to...\n"+
"   _____  _____             _____   ______   ____    ____    ____   _  __\n" +
"  / ____||  __ \\     /\\    |  __ \\ |  ____| |  _ \\  / __ \\  / __ \\ | |/ /\n" +
" | |  __ | |__) |   /  \\   | |  | || |__    | |_) || |  | || |  | || ' / \n" +
" | | |_ ||  _  /   / /\\ \\  | |  | ||  __|   |  _ < | |  | || |  | ||  <  \n" +
" | |__| || | \\ \\  / ____ \\ | |__| || |____  | |_) || |__| || |__| || . \\ \n" +
"  \\_____||_|  \\_\\/_/    \\_\\|_____/ |______| |____/  \\____/  \\____/ |_|\\_\\\n" +
"                                                                         \n" +
"                                                                         ");
        instructions();
    }
    
    public void instructions()
    {
        System.out.println("In this app you can enter students and edit their"
                       + "\ngrades for their class. You can look up students by"
                       + "\ntheir first name, last name, or student ID which is"
                       + "\nassigned to them when they are created. When you have"
                       + "\nfinished inputting grades for a student, select to"
                       + "\nupdate their final grade. You can do this as many"
                       + "\ntimes as you like.");
    }
    
    public void invalidInput() throws LineUnavailableException
    {
        beep.error();
        System.out.println("\tInvalid input\n");
    }
    
    public void badSearch() throws LineUnavailableException
    {
        beep.error();
        System.out.println("\tUnsuccessful search, try again\n");
    }
    
    public void invalidExamInput() throws LineUnavailableException
    {
        beep.error();
        System.out.println("\tExam scores must be between 0-150 points");
    }
    
    public void invalidAssignInput() throws LineUnavailableException
    {
        beep.error();
        System.out.println("\tAssignment scores must be between 0-50 points");
    }
    
    public void invalidProjectInput() throws LineUnavailableException
    {
        beep.error();
        System.out.println("\tIndividual Project scores must be between 0-200 points");
    }
    
    public void goodbye() throws LineUnavailableException
    {
        System.out.println("\tThank you, goodbye.\n");
        beep.flea();
    }
}
