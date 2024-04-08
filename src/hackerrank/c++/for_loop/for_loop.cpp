#include <iostream>
#include <cstdio>
using namespace std;

bool isEven(int a, int b){
    
    
    return a % 2 == 0 && b % 2 == 0;
};

bool isOdd(int a, int b){
    
    return a % 2 != 0 && b % 2 != 0;
};

int main() {
    // Complete the code.

    int a, b, c = 0;
    
    cin >> a >> b;
    
    if (a == 1 || b == 1){
        cout << "one" << endl;
    } else  if (a == 2 || b == 2){
        cout << "two" << endl;
    } else  if (a == 3 || b == 3){
        cout << "three" << endl;
    } else  if (a == 4 || b == 4){
        cout << "four" << endl;
    } else  if (a == 5 || b == 5){
        cout << "five" << endl;
    } else  if (a == 6 || b == 6){
        cout << "six" << endl;
    } else  if (a == 7 || b == 7){
        cout << "seven" << endl;
    } else  if (a == 8 || b == 8){
        cout << "eight" << endl;
    } else  if (a == 9 || b == 9){
        cout << "nine" << endl;
    } else if (a > 9 && b > 9) {
        if (isEven(a, b)) {
            cout << "even" << endl;
        } else if (isOdd(a, b)) {
            cout << "odd" << endl;
        }
    return 0;


}
};
