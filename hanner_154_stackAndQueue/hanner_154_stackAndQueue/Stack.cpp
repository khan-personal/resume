#include "Stack.h"

#include <iostream>

using namespace std;

void Stack::display() {
    if (!isEmpty()) {
        cout << "HERE IS YOUR STACK:" << endl;
        for (int i = top; i >= 0; i--) {
            cout << stack[i] << " ";
        }
        cout << "\nTOP OF STACK IS: " << stack[top] << endl;
        cout << endl;
    }
    else {
        cout << "EMPTY STACK" << endl;
    }
}

bool Stack::isEmpty() {
    if (top <= -1) {
        return true;
    }
    else {
        return false;
    }
}

void Stack::pop() {
    if (isEmpty()) {
        cout << "STACK UNDERFLOW!" << endl;
    }
    else {
        cout << "YOU POPPED THIS: " << stack[top] << endl;
        top--;
    }
}

void Stack::push(int data) {
    if (top >= MAX - 1) {
        cout << "STACK OVERFLOW!" << endl;
    }
    else {
        top++;
        stack[top] = data;
    }
}