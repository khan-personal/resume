//Kenneth Hanner, ITDEV185-900, Assignment 3
//REVISED


#include <iostream>
#include <iomanip>
using namespace std;

const double SPOOL = 100;
const double SHIPPING = 10;

//prototypes
void menu();
void saveUserInput(double& nOrder, double& nStock, double& eCharge);
void calculateValues(double numO, double numS, double extraC);

int main()
{   
    menu();
}

void menu() {
    double numOrdered, numStock, extraCharge;

    //ask for data, store in ref parameters
    saveUserInput(numOrdered, numStock, extraCharge);
    //calculate and display data
    calculateValues(numOrdered, numStock, extraCharge);    
}

void saveUserInput(double& nOrder, double& nStock, double& eCharge) {
    cout << "How many spools were ordered? ";
    cin >> nOrder;
    cout << "How many spools are in stock? ";
    cin >> nStock;
    cout << endl;
    cout << endl;
    cout << "Amount of any special shipping charges (per spool)\n"
        "above the regular $10.00 per spool rate (0 for none): ";
    cin >> eCharge;
}

void calculateValues(double numOr, double numSt, double extraCh = 0) {
    
    //if order in stock
    if (numOr <= numSt) {
        cout << "\n\t*** Order Summary ***" << endl;
        cout << "Spools ordered:         " << setw(8) << numOr << endl;
        cout << "Spools in this shipment:" << setw(8) << numOr << endl;

        cout << "\n\tCharges for this shipment" << endl;
        cout << "\t-------------------------" << endl;
        cout << fixed << showpoint << setprecision(2);
        cout << "Spool charges:         $" << setw(8) << numOr * SPOOL << endl;
        cout << "Shipping charges:      $" << setw(8) << (numOr * SHIPPING) + (numOr * extraCh) << endl;
        cout << "Total this shipment:   $" << setw(8) << (numOr * SPOOL) + (numOr * SHIPPING) + (numOr * extraCh) << endl;
    }//else backorder
    else {
        cout << "\n\n\t*** Order Summary ***" << extraCh << endl;
        cout << "Spools ordered:         " << setw(8) << numOr << endl;
        cout << "Spools in this shipment:" << setw(8) << numSt << endl;
        cout << "Spools back ordered:    " << setw(8) << numOr - numSt << endl;

        cout << "\n\tCharges for this shipment" << endl;
        cout << "\t-------------------------" << endl;
        cout << fixed << showpoint << setprecision(2);
        cout << "Spool charges:         $" << setw(8) << numSt * SPOOL<< endl;
        cout << "Shipping charges:      $" << setw(8) << (numSt * SHIPPING) + (numSt * extraCh) << endl;
        cout << "Total this shipment:   $" << setw(8) << (numSt * SPOOL) + (numSt * SHIPPING) + (numSt * extraCh) << endl;
    }    
}
    


