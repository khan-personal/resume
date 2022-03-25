#include "PersonNode.h"

//getters
	string PersonNode::getAddress() {
		return address;
	}

	string PersonNode::getFName() {
		return fName;
	}

	string PersonNode::getFullName() {
		string fullName = lName + ", " + fName;
		return fullName;
	}

	string PersonNode::getLName() {
		return lName;
	}

	PersonNode* PersonNode::getNext() {
		return next;
	}

	string PersonNode::getPhone() {
		return phone;
	}

// setters
	void PersonNode::setAddress(string a) {
		address = a;
	}

	void PersonNode::setFName(string f) {
		fName = f;
	}

	void PersonNode::setLName(string l) {
		lName = l;
	}

	void PersonNode::setNext(PersonNode* n) {
		next = n;
	}

	void PersonNode::setPhone(string p) {
		phone = p;
	}

//constructors
	PersonNode::PersonNode() {
		setNext(NULL);
	}

	PersonNode::PersonNode(string f, string l, string a, string p) {
		setFName(f);
		setLName(l);
		setAddress(a);
		setPhone(p);
		setNext(NULL);
	}