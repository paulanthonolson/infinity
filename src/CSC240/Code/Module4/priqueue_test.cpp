#include <iostream>
#include <string>
#include "priority_queue.h"

using namespace std;

int main() {
   Priority_Queue pq(100);

   pq.enqueue(7); 
   pq.enqueue(5); 
   pq.enqueue(8); 
   pq.enqueue(2); 
   pq.enqueue(6); 
   pq.enqueue(1); 
   pq.enqueue(3); 
   pq.enqueue(4); 

   cout << "pq: " << pq.toString() << endl;

   while (!pq.isEmpty()) {
      int next = pq.dequeue();
      cout << "Removed " << next << endl;
      cout << "pq: " << pq.toString() << endl;

   }
}
