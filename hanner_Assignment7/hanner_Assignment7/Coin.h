#ifndef COIN_H
#define COIN_H

#include <cstdlib>
#include <ctime>
#include <string>
using namespace std;

class Coin 
{
private:
	static double balance;
	bool heads; 
	string sideUp;
	double value;
public:
	void addBalance(double v);	
	Coin(double v);
	static double getBalance();
	bool getHeads();
	string getSideUp();
	double getValue();
	void toss();
};


		//CHILD CLASSES
class Dime : public Coin
{
public:
	Dime();
};

class Nickel : public Coin
{
public:
	Nickel();
};
class Quarter : public Coin
{
public:
	Quarter();
};

#endif