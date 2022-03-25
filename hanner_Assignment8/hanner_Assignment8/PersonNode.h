#ifndef PERSONNODE_H
#define PERSONNODE_H

#include <string>

using namespace std;

class PersonNode
{
private: 
	string address;
	string fName;
	string lName;
	PersonNode* next;
	string phone;
	
public:
	string getAddress();
	string getFName();
	string getFullName();
	string getLName();
	PersonNode* getNext();
	string getPhone();
	PersonNode();
	PersonNode(string f, string l, string a, string p);
	void setAddress(string a);
	void setFName(string f);
	void setLName(string l);
	void setNext(PersonNode* n);
	void setPhone(string p);
};

#endif

