//Kenneth Hanner, ITDEV185-900, Assignment 7

#include <iostream>
#include <iomanip>
#include <string>
#include <sstream>
#include "Coin.h"

using namespace std;

void evaluateToss(Coin * q, Coin* d, Coin* n);
//static double balance = 0.00;

int main()
{
    //object for each coin
    Quarter quarter;
    Dime dime;
    Nickel nickel;
    //pointer for each coin
    Coin* coinPtrQ = &quarter;
    Coin* coinPtrD = &dime;
    Coin* coinPtrN = &nickel;
        
    //run while not over $1.00
    while (Coin::getBalance() < 1.00)
    {  
        //toss each coin before checking while condition
        evaluateToss(coinPtrQ, coinPtrD, coinPtrN); 
    }
    //win validation and message
    if (Coin::getBalance() == 1.00) {
        cout << "\nCongratulations, your balance is $1.00! You win!" << endl;
        exit(0);
    }
    //else a loss message
    else {
        cout << "\nYour tosses add up to $" << Coin::getBalance() << " so you lose." << endl;
        exit(0);
    }
};

void evaluateToss(Coin* q, Coin* d, Coin* n) {
    //format display
    cout << fixed << setprecision(2) << setfill('0');
    //toss and evaluate quarter
    q->toss();
    //if heads, addBalance and display getValue
    if (q->getHeads()) {
        q->addBalance(q->getValue());
        cout << q->getSideUp() << " ...$" << q->getValue() << endl;
    }
    //if tails, no addBalance or display getValue
    else {
        cout << q->getSideUp() << endl;
    }

    //toss and evaluate dime
    d->toss();
    //if heads, addBalance and display getValue
    if (d->getHeads()) {
        d->addBalance(d->getValue());
        cout << d->getSideUp() << " ...$" << d->getValue() << endl;
    }
    //if tails, no addBalance or display getValue
    else {
        cout << d->getSideUp() << endl;
    }

    //toss and evaluate nickel
    n->toss();
    //if heads, addBalance and display getValue
    if (n->getHeads()) {
        n->addBalance(n->getValue());
        //display results
        cout << n->getSideUp() << " ...$" << n->getValue() << endl;
    }
    //if tails, no addBalance or display getValue
    else {
        cout << n->getSideUp() << endl;
    }
};