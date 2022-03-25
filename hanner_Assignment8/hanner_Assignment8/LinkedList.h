#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include "PersonNode.h"

using namespace std;

class LinkedList
{
private:
	PersonNode* headPtr;
	PersonNode* tailPtr;

public:
	void addLink(PersonNode* newNodePtr);
	PersonNode* findInsertSpot(PersonNode* newNodePtr);
	PersonNode* getHeadPtr();
	LinkedList();
	PersonNode* searchForPerson(string search);
	string removePerson(string search);
};

#endif
