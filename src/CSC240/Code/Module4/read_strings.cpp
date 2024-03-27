#include <iostream>
#include <cstring>

using namespace std;

int main(){
   string long_string, short_string;
   char char_array[100];

	cout << "Enter an string with spaces (>>):";
	cin >> short_string;

	cout << "Enter an string with spaces (getline):";
	getline(cin, long_string);

	cout << "Enter a character array with spaces (getline):";
	cin.getline(char_array, 100, '\n');

	cout << "Reading a string with >>: " << short_string << endl;
	cout << "Reading a string with getline: " << long_string << endl;
	cout << "Reading a char array with getline: " << char_array << endl;

   return 0;
}
