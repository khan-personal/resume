#include "Contact.h"

#include <stdio.h>
#include <string.h>

Contact::Contact() {

}

char* Contact::getFirstName() {
	return firstName;
}

char* Contact::getFullName() {
	return fullName;
}

char* Contact::getLastName() {
	return lastName;
}

char* Contact::getPhone() {
	return phone;
}

void Contact::setFirstName(string input) {
	strcpy_s(firstName, input.c_str());//copy input to firstName
}	

void Contact::setFullName(string input) {
	strcpy_s(fullName, input.c_str());//copy input to fullName
}

void Contact::setLastName(string input) {
	strcpy_s(lastName, input.c_str());//copy input to lastName
}

void Contact::setPhone(string input) {
	strcpy_s(phone, input.c_str());//copy input to phone
}