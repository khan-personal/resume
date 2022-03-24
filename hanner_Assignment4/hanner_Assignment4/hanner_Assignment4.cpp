//Kenneth Hanner, ITDEV185-900, Assignment 4
//REVISED

#include <iostream>
#include <iomanip>
#include "Coin.h"

using namespace std;

int main()
{
    double balance = 0;
    Coin quarter(0.25), dime(0.10), nickel(0.05);

    //no rounding or cutting off numbers
    cout << fixed << setprecision(2);

    //toss quarter, dime, and nickel, add value if heads, until balance is 1 or higher
    while (balance < 1) {

        //quarter
        quarter.toss();
        //if heads...
        if (quarter.getHeads()) {
            //add coin value to balance
            cout << quarter.getSideUp() << " ...$" << quarter.getValue() << "\n" << endl;
            balance = quarter.getValue() + balance;
        }
        else {//else tails...
            cout << quarter.getSideUp() << endl;
        }

        //dime
        dime.toss();
        //if heads...
        if (dime.getHeads()) {
            //add coin value to balance
            cout << dime.getSideUp() << " ...$" << dime.getValue() << "\n" << endl;
            balance = dime.getValue() + balance;
        }
        else {//else tails...
            cout << dime.getSideUp() << endl;
        }

        //nickel
        nickel.toss();
        //if heads...
        if (nickel.getHeads()) {
            //add coin value to balance
            cout << nickel.getSideUp() << " ...$" << nickel.getValue() << "\n" << endl;
            balance = nickel.getValue() + balance;
        }
        else {//else tails...
            cout << nickel.getSideUp() << endl;
        }
    }

    //after balance is 1 or higher, validate for win or loss
    if (balance == 1) {
        cout << "Congratulations, your balance is $1.00! You win!" << endl;
        exit(0);
    }
    //loss
    else if (balance > 1) {
        cout << "Your tosses add up to $" << balance << " so you lose." << endl;
        exit(0);
    }
};