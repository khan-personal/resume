#ifndef ANIMAL_H
#define ANIMAL_H

using namespace std;
#include <string>
//ABSTRACT CLASS, see: below virtual function
class Animal
{
private:
    string name;
    string food;
    static int mood;
    string happy = "quite happy";
    string sad = "not very happy";
    string sound;
public:
    //ABSTRACT FUNCTIONS:  
    virtual void decreaseMood();    
    virtual int getMood();
    virtual string getName();    
    virtual string getSound();
    virtual void increaseMood();

    //non-virtual functions
    string getHappy();
    string getSad();
};

#endif