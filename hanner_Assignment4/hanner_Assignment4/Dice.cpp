#include "Dice.h"

Dice::Dice() { srand(time(0)); }
int Dice::roll() {
	value = rand() % 6 + 1;
	return value;
}