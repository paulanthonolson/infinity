#include <iostream>     // Notice no .h!

using namespace std;    // Use this or use std::cout, std::cin

int main() {
   int i = 0; float f; string s;

   cout << "Enter an integer: ";
   cin >> i;
   cout << "Enter a float: ";
   cin >> f;
   cout << "Enter a string: ";
   cin >> s;

   cout << "i = " << i << endl;         // endl is '\n'
   cout << "f = " << f << endl;
   cout << "s = " << s << endl;

   return 0;
}

