#ifndef DICE_H
#define DICE_H
#include <cstdlib>
#include <ctime>

class Dice
{
private:
	int value;
	

public:
	Dice();

	int roll();
};
#endif