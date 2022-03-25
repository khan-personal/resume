#ifndef COW_H
#define COW_H

#include "Animal.h"
#include <string>

using namespace std;

class Cow :
    public Animal
{
private:
    string name = "Cow";
    string sound = "moooooooooooooooo";
    static int mood;

public:
    void decreaseMood();
    int getMood();
    string getName();
    string getSound();
    void increaseMood();
};

#endif