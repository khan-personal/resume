#include "Coin.h"

//alphabetized functions as I have read this is standard

//add coin value to balance
void Coin::addBalance(double v) {
	balance += value;
}

//Coin constructor
Coin::Coin(double v) {
	srand(time(0));//set rand seed
	value = v;     //set value of coin
	heads = false; //set default
}

double Coin::getBalance() {
	return balance;
}

bool Coin::getHeads() {
	return heads;
}

string Coin::getSideUp() {
	return sideUp;
}

double Coin::getValue() {
	return value;
}

//random coin toss, for bool heads... coin face heads=true, coin face tails=false
void Coin::toss() {
	int side = rand() % 2;

	if (side == 0) {
		sideUp = "\ntails";
		heads = false;
	}
	else {
		sideUp = "\nHEADS";
		heads = true;
	}
}

//initialize balance:
double Coin::balance = 0.00;

		//CHILD CLASS CONSTRUCTORS
Quarter::Quarter() :Coin(0.25) {
	//default constructor
}

Dime::Dime() :Coin(0.10) {
	//default constructor
}

Nickel::Nickel() : Coin(0.05) {
	//default constructor
}