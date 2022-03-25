/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL EXAM
 */
package hanner_finalexam;

import javax.sound.sampled.LineUnavailableException;

public class Hanner_FinalExam 
{
    public static void main(String[] args) throws LineUnavailableException 
    {
        Admin admin = new Admin();
        Controller control = new Controller();
        admin.welcome();
        control.initialize();
    }   
}


//I really enjoyed class this semester, thanks for everything!