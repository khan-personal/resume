#include "LinkedList.h"
#include <cstddef>
#include <iostream>
//getters
PersonNode* LinkedList::getHeadPtr() {
	return headPtr;
}

//constructors
LinkedList::LinkedList() {
	headPtr = NULL;
	tailPtr = NULL;
}

//functions
void LinkedList::addLink(PersonNode* newNodePtr) {
	//add the node to the linked list
		
	if (headPtr == NULL) {//if head is null, add to beginning of list
		headPtr = newNodePtr;
		tailPtr = newNodePtr;

	}
	else {//else find and insert at alphabetical spot
		tailPtr = getHeadPtr();

		//find node to insert after
		PersonNode* insertHere = findInsertSpot(newNodePtr);

		//if only a head ...
		if (headPtr->getNext() == NULL) {
			//if found insert spot is < head, insert at head and set old head to next
			if (insertHere == newNodePtr) {
				newNodePtr->setNext(headPtr);
				headPtr = newNodePtr;
			}
			//if found insert spot is > head 
			else if (insertHere == headPtr) {
				headPtr->setNext(newNodePtr);
			}
		}
		//if multiple nodes...
		else /*if (headPtr->getNext() != NULL) */{
			while (tailPtr != NULL) {
				if (tailPtr == insertHere) {
					//exit loop when found insert spot
					break;
				}
				//traverse!	when insert spot found, tailPtr will continue with proper value outside of while loop			
				tailPtr = tailPtr->getNext();
			}
			if (insertHere->getLName() > newNodePtr->getLName()) {
				//insert at beginning
				PersonNode * temp = newNodePtr;
				temp->setNext(headPtr);
				headPtr = temp;
			}
			else {
				//new node next is old  next
				newNodePtr->setNext(tailPtr->getNext());
				//temp next is now the new node, yay
				tailPtr->setNext(newNodePtr);
			}					
		}
	}
}

PersonNode* LinkedList::findInsertSpot(PersonNode * newNode) {
	//points to the location where a PersonNode is to be inserted into the linked list
	//operating under assumption no same last names!!
	if (headPtr->getNext() == NULL) {
		if (headPtr->getLName() > newNode->getLName()) {
			//if headPtr > newNode
			return newNode;
		}
		else {
			//if headPtr < newNode
			return headPtr;
		}
	}
	else {
		while (tailPtr->getNext() != NULL) {
			if (tailPtr->getNext()->getLName() > newNode->getLName()) {
				//break out of while and return the node which holds the node that will sit ***BEFORE*** new node
				break;
			}
			//tail goes to next
			tailPtr = tailPtr->getNext();
		}
		return tailPtr;
	}	
}

PersonNode* LinkedList::searchForPerson(string search) {		//*****EXTRA CREDIT*****
	PersonNode* searchFor = getHeadPtr();
	//if empty list
	if (headPtr == NULL) {
		return NULL;
	}
	while (searchFor != NULL) {
		if (searchFor->getLName() == search)
		{
			//exit loop
			break;
		}
		//traverse
		searchFor = searchFor->getNext();
	}
	if (searchFor == NULL) {//if search fails, return NULL
		return NULL;
	}
	else {//return found node ptr
		return searchFor;
	}
	
}

string LinkedList::removePerson(string search) {	//*****EXTRA CREDIT*****
	string message = "";
	//if empty list
	if (headPtr == NULL) {
		return "THIS LIST IS EMPTY, BACK TO THE MAIN MENU";
	}
	//found in first node
	if (headPtr->getLName() == search) {
		headPtr = headPtr->getNext();
		return "SEARCHED PERSON FOUND AND REMOVED, BACK TO THE MAIN MENU";
	}
	//found elsewhere
	tailPtr = headPtr;
	while (tailPtr->getNext() != NULL) {
		if (tailPtr->getNext()->getLName() == search) {
			break;
		}
		tailPtr = tailPtr->getNext();
	}
	//if not found
	if (tailPtr->getNext() == NULL) {
		return "SEARCHED PERSON DOES NOT EXIST, BACK TO THE MAIN MENU";
	}
	else {
		tailPtr->setNext(tailPtr->getNext()->getNext());
		return "SEARCHED PERSON FOUND AND REMOVED, BACK TO THE MAIN MENU";
	}
	return "error";
}