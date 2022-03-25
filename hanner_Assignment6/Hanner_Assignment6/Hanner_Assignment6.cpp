//Kenneth Hanner, ITDEV185-900, Assignment 6

#include <iostream>
#include <iomanip>
#include <sstream>
#include "Player.h"
#include "Hanner_Assignment6.h"

using namespace std;

const int PLAYER_NUM = 100;

void namePlayers(Player p[]);
Player *playerPointer(Player p[]);
void displayContents(Player *p);

int main()
{
    /*all insertions/retrievals are within the bounds of the array */

    //create array of players
    Player playerArray[PLAYER_NUM];

    //function that sets the playerNumber for each player 0-99
    namePlayers(playerArray);

    //have each player play
    for (int i = 0; i < PLAYER_NUM; i++) {
        playerArray[i].play();
    }
    
    //function that is passed pointer and returns nothing, displays all contents of the player field.
                    //function that returns Player pointer
    displayContents(playerPointer(playerArray));
}



//function that sets the playerNumber for each player 0-99
void namePlayers(Player p[]) {

    for (int i = 0; i < PLAYER_NUM; i++) {
        //name each player "i"
        p[i].setPlayerNumber(i);
    }
}

//function that returns Player pointer
Player * playerPointer(Player p[]) {

    Player * pointer;

    //initialize high score/pointer
    int highScore = p[0].getSumOfDice();
    pointer = &p[0];
    //look for higher score than index 0
    for (int i = 1; i < PLAYER_NUM; i++) {
        if (highScore < p[i].getSumOfDice()) {
            highScore = p[i].getSumOfDice();
            pointer = &p[i];
        }
    }
    return pointer;
}

void displayContents(Player *winner) {
    Player winningPlayer = *winner;
    
    //cout << fixed << setprecision(2);

    //winner message
    cout << "The winning player is player" << winningPlayer.getPlayerNumber()
        << " amount = " << winningPlayer.getSumOfDice() << "\n" << endl;

    for (int i = 0; i < winningPlayer.getNumberOfDice(); i++) {
        //format prefix using string stream
        ostringstream oss;
        oss << "dice" << i << ":";
        
        cout << left
            << setw(10) << oss.str()
            << setw(10) << winningPlayer.getSingleDieValue(i);
    }
}