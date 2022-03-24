#include "Queue.h"

#include <iostream>

using namespace std;

//display queue
void Queue::display() {
	if (isEmpty()) {
		cout << "QUEUE IS EMPTY" << endl;
	}
	else {
		for (int i = front; i <= rear; i++) {
			cout << queue[i] << " ";
		}
		cout << "\nFRONT ELEMENT IS: " << queue[front] << endl;
	}
	cout << endl;
}

//remove element from queue
void Queue::dequeue() {
	if (isEmpty()) {
		cout << "QUEUE IS EMPTY" << endl;
	}
	else {
		if (front == rear) {
			cout << "YOU DEQUEUED THIS: " << queue[front] << endl;
			front = rear = -1;
		}
		else {
			cout << "YOU DEQUEUED THIS: " << queue[front] << endl;
			front++;
		}
	}
}


//insert element into queue
void Queue::enqueue(int val) {
	if (rear == MAX - 1) {
		cout << "QUEUE IS FULL" << endl;
	}
	else {
		if (front == -1) {
			front = 0;
		}
		rear++;
		queue[rear] = val;
	}
}

//check for empty queue
bool Queue::isEmpty() {
	if (front == -1 && rear == -1) {
		return true;
	}
	else {
		return false;
	}
}