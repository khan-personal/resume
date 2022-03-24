#include "SlotMachine.h"
#include "Reel.h"
#include <iostream>
#include <iomanip>

//SlotMachine will have a function called Play that will spin each of the Reel objects once and decide if the user won and print out the faces spoon and if the user won 
void SlotMachine::Play() {
	//create a reel object

	//spin the three reels inside of Play()
	for (int i = 0; i < 3; i++) {
		threeReels[i].spin();
		cout << left << setw(16) << threeReels[i].getFace();
	}
	cout << endl;
	//win validation inside Play() 
	if ((threeReels[0].getFace() == threeReels[1].getFace()) && (threeReels[1].getFace() == threeReels[2].getFace())) {
		win = true;
	}
}

bool SlotMachine::getWin() {
	return win;
}