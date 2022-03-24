//Kenneth Hanner, ITDEV185-900, Assignment 1

#include <iostream>
#include <string>
#include <iomanip> //for setprecision
using namespace std;

int main() {
	const double STATE_TAX = 0.04, COUNTY_TAX = 0.02;
	double amountCollected;
	string month;
	int year;
	
	//intro and collect data
	cout << "Welcome to your Monthly Sales Tax Calculator!" << endl;
	cout << "Enter reporting year: " << endl;
	cin >> year;
	cout << "Enter reporting month: " << endl;
	cin >> month;
	cout << "Enter the amount collected at the cash register: " << endl;
	cin >> amountCollected;

	//calculate using amountCollected
	auto paidCounty = amountCollected * COUNTY_TAX, paidState = amountCollected * STATE_TAX,
		totalTaxPaid = amountCollected * (STATE_TAX + COUNTY_TAX), totalSales = amountCollected - totalTaxPaid;
	

	//format to show cents properly
	cout << fixed << showpoint; 
	cout << setprecision(2);

	//display calculations
	cout << "\n\nMonth: " << month << " " << year << endl;
	cout << "\n-----------------------------------------" << endl;
	cout <<"\nTotal Collected: $" << amountCollected <<
		"\nSales = $" << totalSales << 
		"\nCounty Sales Tax: $" << paidCounty <<
		"\nState Sales Tax: $" << paidState <<
		"\nTotal Sales Tax: $" << totalTaxPaid << endl;
}