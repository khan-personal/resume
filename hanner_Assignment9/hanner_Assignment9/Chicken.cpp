#include "Chicken.h"

using namespace std;

#include <string>

int Chicken::mood = 0;

string Chicken::getName() {
	return name;
}

void Chicken::increaseMood() {
	mood++;
}

void Chicken::decreaseMood() {
	mood--;
}

string Chicken::getSound() {
	return sound;
}

int Chicken::getMood() {
	return mood;
}