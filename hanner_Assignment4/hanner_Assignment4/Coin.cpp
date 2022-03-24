#include "Coin.h"


Coin::Coin(double v) { 
	value = v;
	srand(time(0)); 
}

void Coin::toss() {
	int side;

	side = rand() % 2 + 1;

	if (side == 1) {
		sideUp = "HEADS";
		heads = true;
	}
	else {
		sideUp = "tails";
		heads = false;
	}
}

bool Coin::getHeads() {
	return heads;
}

double Coin::getValue() {
	return value;
}

string Coin::getSideUp() {
	return sideUp;
}