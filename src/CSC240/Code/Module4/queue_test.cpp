#include <iostream>
#include <string>
#include "queue.h"

using namespace std;

int main() {
   Queue q1(100);

   q1.enqueue(11); 
   q1.enqueue(22); 
   q1.enqueue(33); 
   cout << "q1: " << q1.toString() << endl;

   Queue *q2;  
   q2 = new Queue(10); 

   q2->enqueue(44);
   q2->enqueue(55);
   cout << "q2: " << q2->toString() << endl;

   q2 = &q1;
   q2->enqueue(66);

   cout << "q1: " << q1.toString() << endl;
   cout << "q2: " << q2->toString() << endl;
}
