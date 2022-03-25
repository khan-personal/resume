#include "Pig.h"

using namespace std;

#include <string>

int Pig::mood = 0;

string Pig::getName() {
	return name;
}

void Pig::increaseMood() {
	mood++;
}

void Pig::decreaseMood() {
	mood--;
}

string Pig::getSound() {
	return sound;
}

int Pig::getMood() {
	return mood;
}