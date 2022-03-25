#include "Animal.h"

#include <string>

using namespace std;

int Animal::mood = 0;

//virtual function
void Animal::decreaseMood() {
	mood--;
}

int Animal::getMood() {
	return mood;
}

string Animal::getName() {
	return name;
}

string Animal::getSound() {
	return sound;
}

void Animal::increaseMood() {
	mood++;
}

//non-virtual functions
string Animal::getHappy() {
	return happy;
}

string Animal::getSad() {
	return sad;
}