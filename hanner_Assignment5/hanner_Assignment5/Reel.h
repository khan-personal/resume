#ifndef REEL_H
#define REEL_H

#include <cstdlib>
#include <ctime>
#include <string>

using namespace std;

const int FACE_NUM = 20;//not in assignment instructions

class Reel
{
private:
	string faces[FACE_NUM] = { "lemon", "cherry", "banana", "seven", "diamond",
		"bell", "heart", "star", "strawberry", "grape", "bell", "horseshoe",
		"heart", "pear", "orange", "10", "king", "queen", "jack", "joker" };
	string face;

public:
	Reel();
	void spin();
	string getFace();
};
#endif