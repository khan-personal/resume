#ifndef CONTACT_H
#define CONTACT_H

#include <string>
using namespace std;

class Contact
{
private:
	char firstName[20] = { 0 };
	char fullName[40] = { 0 };
	char lastName[20] = { 0 };
	char phone[14] = { 0 };
public:
	Contact();
	char* getFirstName();
	char* getFullName();
	char* getLastName();
	char* getPhone();
	void setFirstName(string input);
	void setFullName(string input);
	void setLastName(string input);
	void setPhone(string input);
};
#endif