#include "Reel.h"

Reel::Reel() {
	srand(time(0));//not included in assignment instructions
}

void Reel::spin() {	
	int facesNum;
	//select rand num 0-19	
	facesNum = rand() % 20;//random inclusion not in assignment instructions
	//convert face to corresponding faceNum in faces array
	face = faces[facesNum];
}

string Reel::getFace() {	
	return face;
}

