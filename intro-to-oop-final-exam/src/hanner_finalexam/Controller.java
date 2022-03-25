/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL EXAM
 */
package hanner_finalexam;

import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.LineUnavailableException;

public class Controller
{    
    boolean emptyRoster = true;
    int index;
    int chooserIndex;  
    int rollingId = 307;  
    
    List<List> studentRoster = new ArrayList<List>();
    List<String> studentFirst = new ArrayList<String>();
    List<String> studentLast = new ArrayList<String>();
    List<String> studentId = new ArrayList<String>();
        
    View input = new View();
    Admin admin = new Admin();
    
    
    
    public void initialize() throws LineUnavailableException
    {
        input.begin();//ask to begin
        
        switch (input.start) 
        {
            case 'Y'://if yes go to main menu
                mainMenu();
                break;
            case 'N'://if no, quit
                admin.goodbye();
                System.exit(0);
            default://else invalid input, repeat question
                admin.invalidInput();
                initialize();
                break;
        }
    }
    
    public void mainMenu() throws LineUnavailableException
    {
        input.mainMenu();//present main options
        
        switch (input.mainChoice)
        {
            case 'A'://enter a new student
                enterStudent();
                break;
            case 'B'://search for existing student
                search();
                break;
            case 'C'://view entire class
                viewAllStudents();
                break;
            case 'D':
                admin.goodbye();
                System.exit(0);
            default:
                admin.invalidInput();
                mainMenu();
                break;
        }
    }
    
    public void enterStudent() throws LineUnavailableException//main menu choice A
    {
        if (emptyRoster)//new student menu entrance fails empty roster
        {
            emptyRoster = false;
        }
        
        input.enterStudent();
        ArrayList student = new ArrayList<List>();
        student.add(0);
        student.add(1);
        student.add(2);
        student.add("TBD");//3 finalGrade
        student.add(0);//4 scoreSum
        student.add(0);//5 pScore
        student.add(0);//6 eSum
        student.add(0);//7 eOne
        student.add(0);//8 eTwo
        student.add(0);//9 aSum
        student.add(0);//10 aOne
        student.add(0);//11 aTwo
        student.add(0);//12 aThree
        student.add(0);//13 aFour
        student.add(0);//14 aFive
        student.add(0);//15 aSix
        student.add(0);//16 aSeven
        student.add(0);//17 aEight
        student.add(0);//18 aNine
        student.add(0);//19 aTen        
        student.set(0, input.first);//add first name to 0 index
        student.set(1, input.last);//add last name to 1 index
        student.set(2, rollingId);//add id to 2 index
        System.out.println("\t" + input.first + " " + input.last);
        System.out.println("\tID: " + rollingId + "\n");
        studentRoster.add(student);//add student info to studentRoster
        studentFirst.add(input.first);//add to search first index
        studentLast.add(input.last);//add to search last index
        String id = String.valueOf(rollingId);
        studentId.add(id);//add to search id index
        rollingId++;
        
        if (input.studentChoice == 'Y')
        {            
            enterStudent();            
        }
        else
        {
            mainMenu();
        }
    }
    
    public void search() throws LineUnavailableException//main menu choice B
    {
        if (emptyRoster)
        {
            input.noStudents();
        }
        else
        {
            input.searchMethod();
            switch (input.searchChoice)
            {
                case 'A'://search by first name
                    searchFirst();
                    break;
                case 'B'://search by last name
                    searchLast();
                    break;
                case 'C'://search by id
                    searchId();
                    break;
                case 'D'://main menu
                    mainMenu();
                    break;
                default://else
                    admin.invalidInput();
                    search();
                    break;                    
            }
        }
    }
    
    public void searchFirst() throws LineUnavailableException
    {
        try
        {
            input.searchValue();        
            index = studentFirst.indexOf(input.search);
            System.out.println(studentFirst.get(index));
            if (index >= 0)
            {
                foundStudent();
            }
            else if (index < 0)
            {
                admin.badSearch();
                search();
            }
            {
                admin.badSearch();
                search();
            }
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            admin.badSearch();
            search();
        }
    }
    
    public void searchLast() throws LineUnavailableException
    {
        try
        {
            input.searchValue();
            index = studentLast.indexOf(input.search);
            System.out.println(studentLast.get(index));
            if (index >= 0)
            {
                foundStudent();
            }
            else if (index < 0)
            {
                admin.badSearch();
                search();
            }
            else
            {
                admin.invalidInput();
                search();
            }        
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            admin.badSearch();
            search();
        }
    }
    
    public void searchId() throws LineUnavailableException
    {
        try
        {
            input.searchValue();
            index = studentId.indexOf(input.search);
            System.out.println(studentId.get(index));
            if (index >= 0)
            {
                foundStudent();
            }
            else if (index < 0)
            {
                admin.badSearch();
                search();
            }
            else
            {
                admin.invalidInput();
                search();
            }
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            admin.badSearch();
            search();
        }
    }
    
    public void foundStudent() throws LineUnavailableException
    {
        input.foundStudent();
        System.out.println("\tFIRST NAME:\t" + studentRoster.get(index).get(0));
        System.out.println("\tLAST NAME: \t" + studentRoster.get(index).get(1));
        System.out.println("\tSTUDENT ID:\t" + studentRoster.get(index).get(2));
        input.foundStudentChoice();
        switch (input.foundChoice) {
            case 'A'://view student grades
                viewGrades();
                break;
            case 'B'://do another search
                search();
                break;
            case 'C'://return to main menu
                mainMenu();
                break;
            default:
                admin.invalidInput();
                foundStudent();
                break;
        }
    }
    
    public void viewGrades() throws LineUnavailableException
    {
        setGradeSums();
        System.out.println("\tFIRST NAME:\t" + studentRoster.get(index).get(0));
        System.out.println("\tLAST NAME: \t" + studentRoster.get(index).get(1));
        System.out.println("\tSTUDENT ID:\t" + studentRoster.get(index).get(2));
        System.out.println("\n\tFINAL GRADE:     \t" + studentRoster.get(index).get(3));
        System.out.println("\tFINAL SCORE:     \t" + studentRoster.get(index).get(4));
        System.out.println("\tPROJECT SCORE:   \t" + studentRoster.get(index).get(5));
        System.out.println("\tEXAM SCORE:      \t" + studentRoster.get(index).get(6));
        System.out.println("\tASSIGNMENT SCORE:\t" + studentRoster.get(index).get(9));
        input.setGrades();
        switch (input.gradesChoice) {
            case 'A'://set project score
                setProject();
                break;
            case 'B'://set exam scores
                setExams();
                break;
            case 'C'://set assignment scores
                setAssignments();
                break;
            case 'D'://auto set final grade
                setFinalGrade();
                break;
            case 'E':
                mainMenu();
                break;
            default:
                admin.invalidInput();
                viewGrades();
                break;
        }
    }
    
    public void setProject() throws LineUnavailableException
    {
        System.out.println(studentRoster.get(index).get(0) + " " 
                + studentRoster.get(index).get(1));
        System.out.println("INDIVIDUAL PROJECT");
        System.out.println("CURRENT SCORE: " + studentRoster.get(index).get(5));
        input.setScore();
        if (input.scoreEntry > 200 || input.scoreEntry < 0)
        {
            admin.invalidProjectInput();
            setProject();
        }
        else
        {
            studentRoster.get(index).set(5, input.scoreEntry);
            System.out.println("\tNEW PROJECT SCORE: " 
                    + studentRoster.get(index).get(5));
            afterGradeInput();
        }   
    }
    
    public void setExams() throws LineUnavailableException
    {
        input.selectExam();
        if (input.examChoice == 99)
        {
            mainMenu();
        }
        else if (input.examChoice > 0 && input.examChoice < 3)
        {
            findSetExamScore();
        }
        else
        {
            admin.invalidInput();
            setExams();
        }
    }
    
    public void setAssignments() throws LineUnavailableException
    {
        input.selectAssignment();
        if (input.assignmentChoice == 99)
        {
            mainMenu();
        }
        else if (input.assignmentChoice > 0 && input.assignmentChoice < 11)
        {
            findSetAssignmentScore();
        }
        else
        {
            admin.invalidInput();
            setAssignments();
        }
    }
    
    public void findSetAssignmentScore() throws LineUnavailableException
    {
        chooserIndex = input.assignmentChoice + 9;
        System.out.println(studentRoster.get(index).get(0) + " " 
                + studentRoster.get(index).get(1));
        System.out.println("ASSIGNMENT " + (input.assignmentChoice));
        System.out.println("CURRENT SCORE: " + studentRoster.get(index).get(chooserIndex));
        input.setScore();
        if (input.scoreEntry > 50 || input.scoreEntry < 0)
        {
            admin.invalidAssignInput();
            findSetAssignmentScore();
        }
        else
        {
            studentRoster.get(index).set(chooserIndex, input.scoreEntry);
            System.out.println("\tNEW ASSIGNMET " + input.assignmentChoice + " SCORE: " 
                + studentRoster.get(index).get(chooserIndex));
            afterGradeInput();
        }        
    }
    
    public void findSetExamScore() throws LineUnavailableException
    {
        chooserIndex = input.examChoice + 6;
        System.out.println(studentRoster.get(index).get(0) + " " 
                + studentRoster.get(index).get(1));
        System.out.println("EXAM " + (input.examChoice));
        System.out.println("CURRENT SCORE: " + studentRoster.get(index).get(chooserIndex));
        input.setScore();
        if (input.scoreEntry > 150 || input.scoreEntry < 0)
        {
            admin.invalidExamInput();
            findSetExamScore();
        }
        else
        {
            studentRoster.get(index).set(chooserIndex, input.scoreEntry);
            System.out.println("\tNEW EXAM " + input.examChoice + " SCORE: " 
                    + studentRoster.get(index).get(chooserIndex));
            afterGradeInput();
        }
    }
    
    public void afterGradeInput() throws LineUnavailableException
    {
        input.afterGradeInput();
        switch (input.gradeInputChoice) 
        {
            case 'A':
                viewGrades();
                break;
            case 'B':
                mainMenu();
                break;
            default:
                admin.invalidInput();
                afterGradeInput();
                break;
        }
    }
    
    public void setGradeSums()
    {   
        int aSum = (int) studentRoster.get(index).get(10) + //aOne
                   (int) studentRoster.get(index).get(11) + //aTwo
                   (int) studentRoster.get(index).get(12) + //aThree
                   (int) studentRoster.get(index).get(13) + //aFour
                   (int) studentRoster.get(index).get(14) + //aFive
                   (int) studentRoster.get(index).get(15) + //aSix
                   (int) studentRoster.get(index).get(16) + //aSeven
                   (int) studentRoster.get(index).get(17) + //aEight
                   (int) studentRoster.get(index).get(18) + //aNine
                   (int) studentRoster.get(index).get(19);  //aTen
        studentRoster.get(index).set(9,  aSum); //set (index)(9) to sum of assignments
        
        //set sum of exams
        int examSum = (int) studentRoster.get(index).get(7) +
                      (int) studentRoster.get(index).get(8);
        studentRoster.get(index).set(6, examSum); //set (index)(6) to sum of assignments

        //set sum of all scores
        int scoreSum = (int) studentRoster.get(index).get(5) + //project score NO SUM PROJECT NEEDED
                       (int) studentRoster.get(index).get(6) +//exam sum
                       (int) studentRoster.get(index).get(9);//assignment sum
        studentRoster.get(index).set(4, scoreSum); //set (index)(3) to sum of assignments
    }
    
    public void setFinalGrade() throws LineUnavailableException
    {
        int scoreSum = ((int) studentRoster.get(index).get(4));//clean up language below
        
        if (scoreSum > 949)
        {
            studentRoster.get(index).set(3, "A");
        }
        else if (scoreSum > 899 && scoreSum < 950)
        {
            studentRoster.get(index).set(3, "A-");
        }
        else if (scoreSum > 849 && scoreSum < 900)
        {
            studentRoster.get(index).set(3, "B+");
        }
        else if (scoreSum > 799 && scoreSum < 850)
        {
            studentRoster.get(index).set(3, "B");
        }
        else if (scoreSum > 749 && scoreSum < 800)
        {
            studentRoster.get(index).set(3, "B-");
        }
        else if (scoreSum > 699 && scoreSum < 750)
        {
            studentRoster.get(index).set(3, "C+");
        }
        else if (scoreSum > 649 && scoreSum < 700)
        {
            studentRoster.get(index).set(3, "C");
        }
        else if (scoreSum > 699 && scoreSum < 650)
        {
            studentRoster.get(index).set(3, "D");
        }
        else
        {
            studentRoster.get(index).set(3, "F");
        }
        viewGrades();
    }
    
    public void viewAllStudents() throws LineUnavailableException//main menu choice C
    {
        for (int i = 0; i < studentRoster.size(); i++)
        {
            System.out.println("**************************************");
            System.out.println(studentRoster.get(i).get(2) + "....." + studentRoster.get(i).get(0));
            System.out.println("        " + studentRoster.get(i).get(1));
            System.out.println("        Final Grade: " + studentRoster.get(i).get(3));
        }
        input.selectStudent();
        if (input.viewAllChoice == 99)
        {
            mainMenu();
        }
        else
        {
            index = input.viewAllChoice - 307;
            foundStudent();
        }
    }
}
