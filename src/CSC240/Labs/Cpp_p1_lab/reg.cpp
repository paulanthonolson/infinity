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
   Student coilBoy("Nikola Tesla");
   coilBoy.addClass(3, 4);
   coilBoy.addClass(4, 4);
   coilBoy.addClass(3, 4);
   coilBoy.addClass(5, 4);
   coilBoy.addClass(4, 4);
   coilBoy.addClass(3, 4);

   cout << "Name: " << coilBoy.getName() << endl;
   cout << "ID: " << coilBoy.getID() << endl;
   printf("GPA: %4.2f\n", coilBoy.calcGPA());

   cout << endl;

   

   // Add yourself as a pointer to s Student with the new operator.

   Student *me = new Student("Paul Olson");
   me->addClass(3, 3);
   me->addClass(4, 4);
   me->addClass(3, 2);
   me->addClass(5, 3);

   cout << "Name: " << me->getName() << endl;
   cout << "ID: " << me->getID() << endl;
   printf("GPA: %4.2f\n", me->calcGPA());

   return 0;
}
