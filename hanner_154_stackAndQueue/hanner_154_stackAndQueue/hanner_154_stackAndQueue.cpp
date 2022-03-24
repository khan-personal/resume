// hanner_154_stackAndQueue.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>

#include "Stack.h"
#include "Queue.h"

using namespace std;

void playStack();
void playQueue();

int main()
{
    //select stack or queue
    int mainChoice = 0;
    cout << "THIS IS A FRIENDLY STACK AND QUEUE DEMO APPLICATION" << endl;
    cout << "NO INVALID ENTRIES ARE ACCEPTED, PUNISHMENT IS APPLICATION TERMINATION" << endl;
    cout << "ENTER CHOICE:\n\t(1) STACK\n\t(2) QUEUE" << endl;
    cin >> mainChoice;

    switch (mainChoice) {
    case 1:
        playStack();
        system("pause");
        break;
    case 2:
        playQueue();
        system("pause");
        break;
    default:
        cout << "INVALID ENTRY, EXITING APPLICATION";
        system("pause");
        break;
    }
    return 0;
}

void playStack() {
    //create stack
    Stack stack;
    
    while (true) {
        //display menu, take choice
        int stackChoice = 0;
        cout << "\n---===STACK MENU===---\n" << endl;
        cout << "ENTER CHOICE:\n\t(1) DISPLAY\n\t(2) PUSH\n\t(3) POP\n\t(4) EXIT" << endl;
        cin >> stackChoice;
        switch (stackChoice) {
        case 1:
            cout << "---===DISPLAY SELECTED===---" << endl;
            stack.display();
            system("pause");
            break;
        case 2:
            int pushValue;
            cout << "---===PUSH SELECTED===---" << endl;
            cout << "ENTER PUSH INTEGER: " << endl;
            cin >> pushValue;
            stack.push(pushValue);
            system("pause");
            break;
        case 3:
            cout << "---===POP SELECTED===---" << endl;
            stack.pop();
            system("pause");
            break;
        case 4:
            cout << "EXITING PROGRAM" << endl;
            exit(0);
        default:
            cout << "INVALID ENTRY, EXITING PROGRAM";
            exit(0);
        }
    }
    
}

void playQueue() {
    //create queue
    Queue queue;
    
    while (true) {
        //display menu, take choice
        int queueChoice = 0;
        cout << "\n---===QUEUE MENU===---\n" << endl;
        cout << "ENTER CHOICE:\n\t(1) DISPLAY\n\t(2) ENQUEUE\n\t(3) DEQUEUE\n\t(4) EXIT" << endl;
        cin >> queueChoice;
        switch (queueChoice) {
        case 1:
            cout << "---===DISPLAY SELECTED===---" << endl;
            queue.display();
            system("pause");
            break;
        case 2:
            int enqueueValue;
            cout << "---===ENQUEUE SELECTED===---" << endl;
            cout << "ENTER PUSH INTEGER: " << endl;
            cin >> enqueueValue;
            queue.enqueue(enqueueValue);
            system("pause");
            break;
        case 3:
            cout << "---===DEQUEUE SELECTED===---" << endl;
            queue.dequeue();
            system("pause");
            break;
        case 5:
            cout << "EXITING PROGRAM" << endl;
            exit(0);
        default:
            cout << "INVALID ENTRY, EXITING PROGRAM";
            exit(0);
        }
    }
}