#ifndef COIN_H
#define COIN_H

#include <cstdlib>
#include <ctime>
#include <string>
#include <iostream>

using namespace std;


class Coin
{
private:
	string sideUp;
	bool heads;
	double value;

public:
	Coin(double v);
	bool getHeads();
	string getSideUp();
	double getValue();
	void toss();

};
#endif
