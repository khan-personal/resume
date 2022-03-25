#include "Cow.h"

using namespace std;

#include <string>

int Cow::mood = 0;

string Cow::getName() {
	return name;
}

void Cow::increaseMood() {
	mood++;
}

void Cow::decreaseMood() {
	mood--;
}

string Cow::getSound() {
	return sound;
}

int Cow::getMood() {
	return mood;
}