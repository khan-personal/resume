//Kenneth Hanner, ITDEV185-900, Assignment 8

#include <iostream>
#include <sstream>
#include <iomanip> 
#include "LinkedList.h"
#include "PersonNode.h"

using namespace std;

int mainMenu();
void addPerson();
void displayList();
void searchName();//*****EXTRA CREDIT*****
void removeName();//*****EXTRA CREDIT*****
int getSelection();
string displayPerson(PersonNode * thisPerson);

//initialize list
LinkedList list;
const string stars = "*************************************";


int main()
{    
    bool quit = false;

    while (!quit) {
        switch (mainMenu()) {
            case 1:
                //add
                addPerson();
                break;
            case 2:
                //display
                displayList();
                break;
            case 3:
                //search
                searchName();
                break;
            case 4:
                //delete
                removeName();
                break;
            case 5:
                //exit
                quit = true;
                cout << "YOU HAVE SELECTED TO EXIT, GOODBYE" << endl;
                system("pause");
                return 0;
        }
    }
}

int mainMenu() {
    int selection = 0;
    
DISPLAY_MENU:
    //wipe screen
    system("CLS");
    //display menu
    cout << stars << "\n"
        << "(1) Add to directory\n"
        << "(2) Display directory\n"
        << "(3) Search for name\n"
        << "(4) Remove from directory\n"
        << "(5) EXIT\n"
        << stars << endl;
    selection = getSelection();
    if (selection > 0 && selection < 6) {
        return selection;
    }
    else {
        system("CLS");//wipe screen
        cout << "INVALID SELECTION, TRY AGAIN" << endl;
        goto DISPLAY_MENU;
    }
}

//fetch user selection
int getSelection() {
    cout << "ENTER VALID CHOICE:" << endl;
    int choice = 0;
    cin >> choice;
    //clear buffer
    cin.ignore();
    return choice;
}

void addPerson() {
    //initialize members
    string firstName;
    string lastName;
    string address;
    string phone;

    //display and input
    cout << "YOU HAVE SELECTED TO ENTER A CONTACT" << endl;
    cout << "Enter first name:\t";
    getline(cin, firstName);
    cout << "Enter last name:\t";
    getline(cin, lastName);
    cout << "Enter address:\t\t";
    getline(cin, address);
    cout << "Enter phone number:\t";
    getline(cin, phone);    

    //this constructor already sets next to NULL
    PersonNode* newPerson = new PersonNode(firstName, lastName, address, phone);
    //add new person to the list
    list.addLink(newPerson);

    cout << displayPerson(newPerson) << endl;

    system("pause");
}

void displayList() {
    //cannot display empty list
    if (list.getHeadPtr() == NULL) {
        cout << "THE LIST IS EMPTY, RETURNING TO MAIN MENU..." << endl;
        system("pause"); 
        return;
    }
    PersonNode* temp;
    temp = list.getHeadPtr();
    cout << "\nDISPLAYING LIST OF CONTACTS..." << endl;
    while (temp != NULL)
    {
        cout << "\tFull Name: " << temp->getFullName() << endl;
        cout << "\tAddress:   " << temp->getAddress() << endl;
        cout << "\tPhone #:   " << temp->getPhone() << endl << endl;
        //traverse!
        temp = temp->getNext();
    }
    system("pause");
}

void searchName() {                         //*****EXTRA CREDIT*****
    //initialize input
    string input = "";
    //display query
    cout << "\nSEARCH FOR A LAST NAME: ";
    //get input from user
    getline(cin, input);

    //search list and
    PersonNode* searchFor = list.searchForPerson(input);
    //display results
    if ( searchFor == NULL) {//not found
        cout << "EITHER NO SUCH CONTACT OR LIST EXISTS, BACK TO THE MAIN MENU FOR YOU" << endl;
        system("pause");
    }
    else {//found
        cout << "PERSON FOUND..." << displayPerson(searchFor) << endl;
        system("pause");
    }
}

void removeName() {             //*****EXTRA CREDIT*****
    //initialize input
    string input = "";
    //display query
    cout << "\nSEARCH FOR A LAST NAME TO DELETE: ";
    //get input from user
    getline(cin, input);

    //search list and display message
    string display = list.removePerson(input);
    cout << display << endl;
    system("pause");
}

string displayPerson(PersonNode* thisPerson) {
    ostringstream oss;
    oss << "\nHERE IS YOUR PERSON:\n"
        << "\tFull Name: " << thisPerson->getFullName() << endl
        << "\tAddress:   " << thisPerson->getAddress() << endl
        << "\tPhone #:   " << thisPerson->getPhone();

    return oss.str();
}