#ifndef STACK_H
#define STACK_H

using namespace std;

#define MAX 3

class Stack
{
private:
	int stack[MAX];
	int top = -1;

public:
	void display();
	bool isEmpty();
	void pop();
	void push(int data);
};

#endif