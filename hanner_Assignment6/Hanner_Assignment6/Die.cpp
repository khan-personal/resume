#include "Die.h"
#include <iostream>
#include <iomanip>

Die::Die() {
	
}

//roll that will use a random object to generate and return a random number between 1 and 6
void Die::roll() {
	//select rand num 1-6
	dieValue = (rand() % 6) + 1;
}

int Die::getValue() {
	return dieValue;
}