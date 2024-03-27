#include <iostream>  

using namespace std;

int main() {
   char line[50];

   cout << "Please enter a line: " << endl;
   cin.getline(line, 50, '\n');
   cout << line << endl;

   cout << "Please enter a line ended by '@': " << endl;
   cin.getline(line, 50, '@');
   cout << line << endl;

   return 0;
} 

