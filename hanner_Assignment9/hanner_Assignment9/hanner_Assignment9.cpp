//Kenneth Hanner, ITDEV185-900, Assignment 9

#include <iostream>
#include "Animal.h"
#include "Cow.h"
#include "Pig.h"
#include "Chicken.h"

using namespace std;

//ABSTRACT CLASS// see: Animal.h
Animal * ptr;

//DERIVED OBJECTS// : Animal
Cow cow;
Pig pig;
Chicken chicken;

void mainMenu();
void animalMenu(Animal * ptr);

int main() {
    //display intro message and identify the application
    cout << "Hi fellow students! This is an Petting Zoo Application for your review." << endl;
    cout << "You can feed animals food to make them happy." << endl;
    cout << "If they are happy they will respond accordingly when you try to talk to them." << endl;
    cout << "They will remember you, so be nice!" << endl;
    system("pause");
    system("cls");

    //access mainMenu
    mainMenu();
}

void mainMenu() {
    
    //game loop
    while (true) {
        int animalChoice;
        //display menu
        cout << "---===WHICH ANIMAL WOULD YOU LIKE TO SEE===---" << endl;
        cout << "(1) COW" << endl;
        cout << "(2) PIG" << endl;
        cout << "(3) CHICKEN" << endl;
        cout << "\n(5) EXIT PROGRAM" << endl;
        cin >> animalChoice;
        //execute code based on user input
        switch (animalChoice) {
            case 1://cow                
                //point to derived cow object
                ptr = &cow;
                //now we can call functions from the DERIVED object via the pointer from the ABSTRACT class
                cout << "You selected " << ptr->getName() << endl;
                system("pause");
                system("cls");
                //call cow menu
                animalMenu(ptr);            
                break;//break from switch
            case 2://pig
                //point to derived pig object
                ptr = &pig;
                //now we can call functions from the DERIVED object via the pointer from the ABSTRACT class
                //**THESE ARE EXAMPLES OF POLYMORPHISM**, specifically runtime polymorphism, and you will see many like it below!
                //**THESE (and below) ARE ALSO EXAMPLES OF VIRTUAL FUNTIONS, because it is calling a virtual function from the base class
                cout << "You selected " << ptr->getName() << endl;
                system("pause");
                system("cls");
                //call pig menu
                animalMenu(ptr);
                break;//break from switch
            case 3://chicken
                //point to derived chicken object
                ptr = &chicken;
                //now we can call functions from the DERIVED object via the pointer from the ABSTRACT class
                cout << "You selected " << ptr->getName() << endl;
                system("pause");
                system("cls");
                //call chicken menu
                animalMenu(ptr);
                break;//break from switch
            case 5://exit program
                cout << "You have selected to exit, goodbye." << endl;
                system("pause");
                exit(0);//EXIT PROGRAM
                break;//break from switch
            default:
                cout << "Invalid selection... try again" << endl;
                system("pause");
                system("cls");
                cin.clear();//clear previous input
                cin.ignore(123, '\n');//discard previous input
                break;//break from switch
        }
    }
}

void animalMenu(Animal* animalPtr) {
    //bool to check while loop
    bool animalSelected = true;
    int actionChoice;
    int foodChoice;

    while (animalSelected) {
        cout << "---===THIS IS WHERE THE " << animalPtr->getName() << " IS == = -- - " << endl;
        cout << "select an action..." << endl;
        cout << "(1) FEED THE " << animalPtr->getName() << endl;
        cout << "(2) PET THE " << animalPtr->getName() << endl;
        cout << "(3) TALK TO THE " << animalPtr->getName() << endl;
        cout << "\n(5) BACK TO MAIN MENU" << endl;
        cout << "\n(7) EXIT PROGRAM" << endl;
        cin >> actionChoice;

        switch (actionChoice) {
            case 1://feed
                system("cls");
                cout << "WHAT WOULD YOU LIKE TO FEED THE " << animalPtr->getName() << "?" << endl;
                cout << "hint: each animal has a preferred food" << endl;
                cout << "(1) GRASS" << endl;
                cout << "(2) CORN" << endl;
                cout << "(3) GRAIN" << endl;
                cout << "(4) BACK TO ACTION MENU" << endl;
                cout << "(5) BACK TO MAIN MENU" << endl;
                cout << "\n(7) EXIT PROGRAM" << endl;
                cin >> foodChoice;
                switch (foodChoice) {
                    case 1://feed animal grass (cow likes)
                        cout << "YOU CHOSE GRASS" << endl;
                        if (animalPtr->getName() == "Cow") {//is cow, increase mood
                            cout << "the cow loves grass, yum!" << endl;
                            cout << animalPtr->getSound() << endl;
                            animalPtr->increaseMood();
                        }
                        else {//not cow, decrease mood
                            cout << "oh no! they did not like that as much as their preferred food..." << endl;
                            animalPtr->decreaseMood();
                        }
                        break;
                    case 2://feed animal corn (pig likes)
                        cout << "YOU CHOSE CORN" << endl;
                        if (animalPtr->getName() == "Pig") {//is chicken, increase mood
                            cout << "the pig loves corn, yum!" << endl;
                            cout << animalPtr->getSound() << endl;
                            animalPtr->increaseMood();
                        }
                        else {//not chicken, decrease mood
                            cout << "oh no! they did not like that as much as their preferred food..." << endl;
                            animalPtr->decreaseMood();
                        }
                        break;
                    case 3://feed animal grain (chicken likes)
                        cout << "YOU CHOSE GRAIN" << endl;
                        if (animalPtr->getName() == "Chicken") {//is chicken, increase mood
                            cout << "the chicken loves grain, yum!" << endl;
                            cout << animalPtr->getSound() << endl;
                            animalPtr->increaseMood();
                        }
                        else {//not chicken, decrease mood
                            cout << "oh no! they did not like that as much as their preferred food..." << endl;
                            animalPtr->decreaseMood();
                        }
                        break;
                    case 4://action menu
                        cout << "BACK TO THE ACTION MENU..." << endl;
                        break;
                    case 5://main menu
                        cout << "BACK TO THE MAIN MENU..." << endl;                        
                        animalSelected = false;//exit while loop                        
                        break;
                    case 7:
                        cout << "You have selected to exit, goodbye." << endl;
                        system("pause");
                        exit(0);
                        break;
                    default:
                        cout << "Invalid selection... try again" << endl;
                        cin.clear();//clear previous input
                        cin.ignore(123, '\n');//discard previous input
                        break;
                }
                system("pause");
                system("cls");
                break;
            case 2://pet
                system("cls");
                cout << "YOU CHOSE TO PET THE " << animalPtr->getName() << endl;
                system("pause");
                if (animalPtr->getMood() > 0 && animalPtr->getMood() <= 3) {//if mood is above 0, display happy message
                    cout << "The " << animalPtr->getName() << " is " << animalPtr->getHappy() << endl;
                    break;
                }
                else if (animalPtr->getMood() > 3) {//if mood is very high
                    cout << "The " << animalPtr->getName() << " is really, really " << animalPtr->getHappy() << "!" << endl;
                    cout << animalPtr->getSound() << endl;
                    break;
                }
                else if (animalPtr->getMood() <= 0 && animalPtr->getMood() > -3) {//if mood is equal to or less than 0, display sad message
                    cout << "\n\n...nothing happens...\n" << endl;
                    cout << "The " << animalPtr->getName() << " is " << animalPtr->getSad() << endl;
                    break;
                }
                else {//mood very poor
                    cout << "\n\nThe " << animalPtr->getName() << " bites you! It really must not like you." << endl;
                }
                system("pause");
                system("cls");
                break;
            case 3://talk
                cout << "YOU SPEAK TO THE " << animalPtr->getName() << endl;
                cout << "the " << animalPtr->getName() << " replies with: " << animalPtr->getSound() << endl;
                system("pause");
                system("cls");
                break;
            case 5://main menu
                cout << "BACK TO THE MAIN MENU..." << endl;
                system("pause");
                animalSelected = false;
                system("cls");
                break;
            case 7://exit program
                cout << "You have selected to exit, goodbye." << endl;
                system("pause");
                exit(0);
                break;
            default:
                cout << "Invalid selection... try again" << endl;
                system("pause");
                system("cls");
                cin.clear();//clear previous input
                cin.ignore(123, '\n');//discard previous input
                break;
        }
    }    
}


//I hope you enjoyed my application! It is simple, a little fun, and (hopefully) easy to understand!