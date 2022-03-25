#ifndef CHICKEN_H
#define CHICKEN_H

#include "Animal.h"
#include <string>

using namespace std;

class Chicken :
    public Animal
{
private:
    static int mood; 
    string name = "Chicken";
    string sound = "cluck cluck";
public:
    void decreaseMood(); 
    int getMood();
    string getName();
    string getSound(); 
    void increaseMood();       
};

#endif