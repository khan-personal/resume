/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL EXAM
 */
package hanner_finalexam;

import java.util.Scanner;

public class View 
{
    String first;
    String last;
    char start;
    char mainChoice;
    char studentChoice;
    char searchChoice;
    String search;
    char foundChoice;
    char gradesChoice;
    int scoreEntry;
    int assignmentChoice;
    char gradeInputChoice;
    int examChoice;
    int viewAllChoice;
        
    Scanner keyboard = new Scanner(System.in);
    Admin admin = new Admin();
    
    
    public void begin()
    {
        System.out.println("\nShall we begin? [Y] [N]");
        start = keyboard.next().charAt(0);
        start = Character.toUpperCase(start);
    }
    
    public void noStudents()
    {
        System.out.println("\tThere are no students in your gradebook."
                       + "\n\tReturning to Main Menu...");
    }
    
    public void mainMenu()
    {
        System.out.println("***********MAIN MENU***********");
        System.out.println("[A] Enter New Student");
        System.out.println("[B] Search for Existing Student");
        System.out.println("[C] View All Students");
        System.out.println("[D] QUIT");
        mainChoice = keyboard.next().charAt(0);
        mainChoice = Character.toUpperCase(mainChoice);
    }
    
    public void enterStudent()
    {
        System.out.println("Enter First Name:");
        first = keyboard.next().toUpperCase();
        System.out.println("Enter Last Name:");
        last = keyboard.next().toUpperCase();
        System.out.println("Would you like to enter another student? [Y] [N]");
        studentChoice = keyboard.next().charAt(0);
        studentChoice = Character.toUpperCase(studentChoice);
        System.out.println("PREVIOUS ENTRY:");
    }
    
    public void searchMethod()
    {
        System.out.println("\nSelect searching mechanism:"
                      + "\n[A] FIRST NAME"
                      + "\n[B] LAST NAME"
                      + "\n[C] ID NUMBER"
                      + "\n[D] RETURN TO MAIN MENU");
        searchChoice = keyboard.next().charAt(0);
        searchChoice = Character.toUpperCase(searchChoice);
    }
    
    public void searchValue()
    {
        System.out.println("Enter search value:");
        search = keyboard.next().toUpperCase();
    }
    
    public void foundStudent()
    {
        System.out.println("Records have identified this student from your search:");
    }
    
    public void foundStudentChoice()
    {
        System.out.println("\nSelect action:"
                       + "\n[A] VIEW STUDENT GRADES"
                       + "\n[B] PERFORM ANOTHER SEARCH"
                       + "\n[C] RETURN TO MAIN MENU");
        foundChoice = keyboard.next().charAt(0);
        foundChoice = Character.toUpperCase(foundChoice);
    }
    
    public void setGrades()
    {
        System.out.println("Select action:"
                + "\n[A] CHANGE PROJECT SCORE"
                + "\n[B] CHANGE EXAM SCORES"
                + "\n[C] CHANGE ASSIGNMENT SCORES"
                + "\n[D] AUTO-SET FINAL GRADE LETTER"
                + "\n[E] RETURN TO MAIN MENU");
        gradesChoice = keyboard.next().charAt(0);
        gradesChoice = Character.toUpperCase(gradesChoice);
    }
    
    public void setScore()
    {
        System.out.println("\nEnter new score:");
        scoreEntry = keyboard.nextInt();
    }
    
    public void selectAssignment()
    {
        System.out.println("Select assignment score to edit:"
                + "\n[1]  ASSIGNMENT 1"
                + "\n[2]  ASSIGNMENT 2"
                + "\n[3]  ASSIGNMENT 3"
                + "\n[4]  ASSIGNMENT 4"
                + "\n[5]  ASSIGNMENT 5"
                + "\n[6]  ASSIGNMENT 6"
                + "\n[7]  ASSIGNMENT 7"
                + "\n[8]  ASSIGNMENT 8"
                + "\n[9]  ASSIGNMENT 9"
                + "\n[10] ASSIGNMENT 10"
                + "\n[99] RETURN TO MAIN MENU");
        assignmentChoice = keyboard.nextInt();
    }
    
    public void selectExam()
    {
        System.out.println("Select exam to edit:"
                + "\n[1]  EXAM 1"
                + "\n[2]  EXAM 2"
                + "\n[99] RETURN TO MAIN MENU");
        examChoice = keyboard.nextInt();
    }
    
    public void afterGradeInput()
    {
        System.out.println("Select action:"
                + "\n[A] BACK TO STUDENT GRADES"
                + "\n[B] BACK TO MAIN MENU");
        gradeInputChoice = keyboard.next().charAt(0);
        gradeInputChoice = Character.toUpperCase(gradeInputChoice);
    }
    
    public void selectStudent()
    {
        System.out.println("Choose student by ID or [99] for MAIN MENU:");
        viewAllChoice = keyboard.nextInt();
    }
}
