#include "Player.h"
#include "Die.h"

#include <iostream>
#include <iomanip>
using namespace std;

Player::Player() {
	srand(time(NULL));
}

//play will roll each dice in the dice array and set the sumOfDice with the sum of all the dice rolled
void Player::play() {
	Die die;
	//roll for each array element in dice[]
	for (int i = 0; i < getNumberOfDice(); i++) {		
		die.roll();
		dice[i] = die.getValue();
	}
	//I don't think this is necessary but the instructions call for it with "set the sumOfDice with the sum of all the dice rolled"
	getSumOfDice();
}

void Player::setPlayerNumber(int n) {
	playerNumber = n;
}

//return the number of dice the player has
int Player::getNumberOfDice() {
	return sizeof(dice)/sizeof(*dice);
}

//return the number assigned to the player
int Player::getPlayerNumber() {
	return playerNumber;
}

//return the value of a single dice of the  dice array when passed in the data of which die is requested
int Player::getSingleDieValue(int i) {
	return dice[i];
}

//return the sum of all of the dice in the dice array
int Player::getSumOfDice() {
	sumOfDice = 0;
	for (int i = 0; i < getNumberOfDice(); i++) {
		sumOfDice += dice[i];
	}
	return sumOfDice;
}