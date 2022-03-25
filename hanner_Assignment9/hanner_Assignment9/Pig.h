#ifndef PIG_H
#define PIG_H

#include "Animal.h"
#include <string>

using namespace std;

class Pig :
    public Animal
{
private:
    string name = "Pig";
    string sound = "oink oink";
    static int mood;

public:
    void decreaseMood();
    int getMood();
    string getName();
    string getSound();
    void increaseMood();
};

#endif