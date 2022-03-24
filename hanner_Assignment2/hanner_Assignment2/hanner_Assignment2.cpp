//Kenneth Hanner, ITDEV185-900, Assignment 2

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main()
{
	
	ifstream infile;
	string studentName, firstStudent, lastStudent;
	const int MAX = 20;
	int numStudents = 0;
	char choice;

	//welcome user
	cout << "---Welcome to the Student Line Up App---\n\tYou can use the last student file you have" <<
		"\n\tor you can overwrite it and make a new one." << endl;

	//ask if using file or manual input
	cout << "Would you like to import your students.txt file or would you like to input manually?"
		<< "\n\t(A) Import from students.txt"
		<< "\n\t(B) Input manually and overwrite students.txt" << endl;
	cin >> choice;
	
	//validate answer
	while (choice != 'A' && choice != 'a' && choice != 'B' && choice != 'b') {
		cout << "Choose A or B...\n\t";
		cin >> choice;
	}

						//***EXTRA CREDIT***
	//if import...
	if (choice == 'A' || choice == 'a') {
		//inform user of selection
		cout << "\n---IMPORT SELECTED---" << endl;
		//initialize first student
		firstStudent = "zzzz";
		
		//open file
		infile.open("students.txt");
		if (!infile) {
			cout << "Error finding and opening students.txt";
		}
		//order students
		else {			
			while (getline(infile, studentName)) {
				cout << studentName << endl;
				if (studentName < firstStudent) {
					firstStudent = studentName;
				}
				if (studentName > lastStudent) {
					lastStudent = studentName;
				}
			}
			cout << endl;
		}
		infile.close();
		//closed

		//results statement
		cout << endl << firstStudent << " is at the front of the line." << endl;
		cout << lastStudent << " is at the back of the line." << endl;
		return 0;
	}
	//if manual input...
	else if (choice == 'B' || choice == 'b') {
		//inform user of selection
		cout << "\n---MANUAL INPUT SELECTED---" << endl;
		cout << "Note that this will overwrite your current students.txt file..." << endl;
		cout << "Please enter the number of students in your class between 1 and 20:" << endl;
		cin >> numStudents;

		//validate number of students
		while (numStudents < 1 || numStudents > MAX) {
			cout << "ERROR!\nChoose student number between 1 and " << MAX << ": ";
			cin >> numStudents;
		}

		cin.get();

		//initialize first and last student
		cout << "\nEnter name of student #1: ";
		getline(cin, studentName);
		firstStudent = lastStudent = studentName;
						//***EXTRA CREDIT***
		//export to student1 to students.txt
		ofstream outfile("students.txt");
		outfile << studentName << endl;


		//accept input for rest of student names and alphabetize on the go
		for (int studentNum = 2; studentNum <= numStudents; studentNum++)
		{
			cout << "\nEnter name of student #" << studentNum << ": ";
			getline(cin, studentName);

			//export to student1 to students.txt
			outfile << studentName << endl;

			//alphabetize
			if (studentName < firstStudent) {
				firstStudent = studentName;
			}
			else if (studentName > lastStudent) {
				lastStudent = studentName;
			}
		}

		outfile.close();		
		cout << "\n*Students saved to students.txt*" << endl;

		//results statement
		cout << endl << firstStudent << " is at the front of the line." << endl;
		cout << lastStudent << " is at the back of the line." << endl;
		return 0;
	}
}
