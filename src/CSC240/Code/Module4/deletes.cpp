#include <iostream>

using namespace std;

struct XY_pair { 
   int x; 
   double y;   
   
   XY_pair()  { cout << "Constructor called" << endl; }   
   ~XY_pair() { cout << "Destructor called"  << endl; }
};

#define SIZE 3

int main () {   
   XY_pair *p;
   int i = 1;

   p = new XY_pair[SIZE];

   for (XY_pair *q = p; q < p+SIZE; q++) {
      q->x = 10 * i; 
      q->y = 3.1415 * i++;
   }

   for (XY_pair *q = p; q < p+SIZE; q++)
      cout << "   (x=" << q->x << ", y=" << q->y << ")" << endl;

   delete[] p;
}

