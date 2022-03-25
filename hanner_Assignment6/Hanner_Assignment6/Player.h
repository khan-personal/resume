#ifndef PLAYER_H
#define PLAYER_H

class Player
{
private:
	//an array of 20 dice
	int dice[20];
	//an integer playerNumber that will hold the integer value that identifies the player
	int playerNumber;
	//sumOfDice that will hold the sum of all 20 dice rolled
	int sumOfDice;
public:
	Player();
	void play();
	void setPlayerNumber(int n);
	int getNumberOfDice();
	int getPlayerNumber();
	int getSingleDieValue(int i);
	int getSumOfDice();	
};
#endif
