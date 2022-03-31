//Kenneth Hanner, ITDEV185-900, Assignment 11

#include <iostream>
#include <algorithm>

using namespace std;

bool isPalindrome(string, int, int);

int main()
{
    //kindly welcome the user
    cout << "--THIS IS A PALINDROME CHECKER--" << endl;
    cout << "  a palindrome reads backwards" << endl;
    cout << "  the same as it reads forwards" << endl;
    cout << "  Bob is a palindrome because" << endl;
    cout << "  it is Bob forwards and boB " << endl;
    cout << "  backwards. b o b both ways." << endl;
    cout << endl;

PLAY:
    cout << "Enter a word to check if it is a palindrome:" << endl;
    string wordInput;
    cin >> wordInput;//take user input for palindrome check
    int lower = 0;
    int upper = wordInput.length();//-1 in passing the function
    //send to isPalindrome() for recursive check
    if (isPalindrome(wordInput, lower, upper - 1)) {
        cout << "Wow! " << wordInput << " is a palindrome!" << endl;
        goto AGAIN;//offer to play again
    }
    else {
        cout << "Shucks... " << wordInput << " is not a palindrome." << endl;
    AGAIN://play again?
        cout << "Would you like to try again? y/n" << endl;
        char input;
        cin >> input;
        char choice = toupper(input);//uppercase input
        if (choice == 'N') {
            cout << "You selected to exit the program, goodbye." << endl;
        }
        else if (choice == 'Y') {
            system("cls");
            cin.ignore();
            goto PLAY;//start from beginning of gameplay
        }
        else {
            cout << "\tINVALID INPUT, ENTER Y or N" << endl;
            goto AGAIN;
        }
    }
    return 0;
}

bool isPalindrome(string input, int lower, int upper) {
    //ASSIGNMENT REQUIREMENT
    //input TOUPPER and then use UPPERCASED input to check for palindrome
    transform(input.begin(), input.end(), input.begin(), ::toupper);

    //while lower and upper are pointing to different side of the string...    
    while (lower < upper) {
        //if values not equal, not palindrome and return FALSE
        if (input[lower] != input[upper]) {
            return false;
        }
        //traverse recursively
        return isPalindrome(input, lower + 1, upper - 1);
    }
    //if lower >= upper, base case!
    return true;
}