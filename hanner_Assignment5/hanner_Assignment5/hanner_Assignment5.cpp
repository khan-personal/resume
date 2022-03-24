//Kenneth Hanner, ITDEV185-900, Assignment 5

#include <iostream>
#include "SlotMachine.h"

int main()
{
    SlotMachine play;

    int counter = 0;
    //play until win
    while (!play.getWin()) { //exit logic in assignment instructions was unclear, but I did the while loop here
        counter++;
        play.Play();
    }
    //display on win
    cout << "\nWinner!!!!" << endl;
    cout << counter << " tries to win.";
}