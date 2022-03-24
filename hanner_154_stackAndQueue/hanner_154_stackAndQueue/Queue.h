#ifndef QUEUE_H
#define QUEUE_H

using namespace std;

#define MAX 3

class Queue
{
private:
	int queue[MAX];
	int front = -1;
	int rear = -1;
public:
	void dequeue();
	void display();
	void enqueue(int val);
	bool isEmpty();
};

#endif