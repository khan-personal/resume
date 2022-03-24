#ifndef SLOTMACHINE_H
#define SLOTMACHINE_H
#include "Reel.h"

using namespace std;

class SlotMachine //"A class named SlotMachine that will simulate the slot machine"
{
private:
	Reel threeReels[3];//"SlotMachine will contain an array of three Reel objects"
	bool win = false;//not listed in assignment instructions

public:
	void Play();//"SlotMachine will have a function called Play that will spin each of the Reel objects once and decide if the user won and print out the faces spoon and if the user won" 

	bool getWin();//not listed in assignment instructions

};
#endif