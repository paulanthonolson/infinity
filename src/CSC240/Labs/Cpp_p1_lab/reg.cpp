#include <iostream>
#include "student.h"

using namespace std;

int main() {
   Student snoopy("Joe Cool");

   snoopy.addClass(3, 4);
   snoopy.addClass(4, 3);
   snoopy.addClass(3, 2);
   snoopy.addClass(5, 4);

   cout << "Name: " << snoopy.getName() << endl;
   cout << "ID: " << snoopy.getID() << endl;
   printf("GPA: %4.2f\n", snoopy.calcGPA());

   cout << endl;

   // Add Nikola Tesla Here

   // Add yourself as a pointer to s Student with the new operator.

   return 0;
}
