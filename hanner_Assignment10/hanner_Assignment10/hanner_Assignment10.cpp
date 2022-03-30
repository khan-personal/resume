//Kenneth Hanner, ITDEV185-900, Assignment 10

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>

#include "Contact.h"

using namespace std;

const int contactSize = 10;

void readFromFile(Contact[]);
void searchContacts(Contact[], char[]);
void displayEntry(Contact&);
char menu();

int main()
{
    Contact contact[contactSize];

    //open txt file and put data into obj array
    cout << "Reading in data from file ContactList.txt..." << endl;
    system("pause"); 
    readFromFile(contact);
    system("pause");
    
    while (true) {
        system("cls");//wipe console        
        char menuChoice = menu();
        if (menuChoice == 'S') {
            system("cls");
            cin.ignore();
            //ask for search value
            cout << "ENTER LAST NAME TO SEARCH FOR: " << endl;
            char searchFor[40] = { 0 };
            cin.getline(searchFor, 40);

            //search through obj array for user input
            searchContacts(contact, searchFor);
            cin.ignore();
        }
        else if (menuChoice == 'E') {
            cout << "YOU SELECTED TO EXIT - GOODBYE" << endl;
            system("pause");
            exit(0);
        }
        else {
            cout << "INVALID SELECTION" << endl;
            system("pause");
            cin.ignore();
        }
    }
}


void readFromFile(Contact list[]) {

    ifstream infile;
    string fileName = "ContactList.txt";
    //we really only really need one string to pass data into, but this makes it clearer what is happening below
    string first;
    string last;
    string phone;
    string full;

    infile.open(fileName);//open ContactList

    //NOT USING EOF WHILE LOGIC because we have a predetermined num of contacts
    for (int i = 0; i < contactSize; i++) {
        //read last name
        getline(infile, last);
            //set last name
        list[i].setLastName(last);
        //read first name
        getline(infile, first);
            //set first name
        list[i].setFirstName(first);
        //read phone
        getline(infile, phone);
            //set phone
        list[i].setPhone(phone);
        //build FULL NAME (last name + "," + " " + first name)
        full = last + ", " + first;
            //set full name
        list[i].setFullName(full);

        cout << "Full name: " << list[i].getFullName() << endl;
        cout << "First name: " << list[i].getFirstName() << endl;
        cout << "Last name: " << list[i].getLastName() << endl;
        cout << "Phone number: " << list[i].getPhone() << endl;
        cout << endl;
    }
    
    infile.close();//close ContactList
    
    cout << "reading of file ContactList.txt is complete." << endl;
}

void searchContacts(Contact contact[], char searchFor[]) {
    cout << "\n\tsearching for ... " << searchFor << endl;
    bool found = false;


    for (int i = 0; i < contactSize; i++) {
        //create string of current last name to execute with find()
        string c = contact[i].getLastName();

        if (c.find(searchFor) != string::npos) {
            displayEntry(contact[i]);//send found object to displayEntry()
            found = true;
        }        
    }
    if (!found) {//nothing found
        cout << "SORRY, " << searchFor << " NOT FOUND IN CONTACT DIRECTORY" << endl;
    }
}

void displayEntry(Contact &contact) {
    //get name and phone of passed contact object
    cout << contact.getFullName() << endl;
    cout << contact.getFirstName() << endl;
    cout << contact.getLastName() << endl;
    cout << contact.getPhone() << endl;   
    cout << endl;
    cout << "press ENTER to continue..." << endl;
}

char menu() {
    cout << "______________________" << endl;
    cout << "(S)earch for name" << endl;
    cout << "(E)xit" << endl;
    cout << "______________________" << endl;
    char choice;
    cin >> choice;   
    char returnVal = toupper(choice);//give returnVal uppercase char for easier handling on return
    return returnVal;    
}