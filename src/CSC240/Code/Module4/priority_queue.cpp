#include "priority_queue.h"

int Priority_Queue::find_first() { 
   if (isEmpty()) {
      fprintf(stderr, "queue is empty\n");
      return -1;
   }

   int least_val = data[front];
   int least_pos = front;
   int pos;

   for(int i = 1, pos = (front + 1) % capacity; i < length; i++, pos = (pos + 1) % capacity) {
      if (data[pos] < least_val) {
	 least_val= data[pos];
	 least_pos = pos;
      }
   }

   return least_pos;
}

int Priority_Queue::first() { return find_first(); }

int Priority_Queue::dequeue() { 
   int pos = find_first();
   int val = data[pos];

   data[pos] = data[front];
   front = (front + 1) % capacity;
   length--;

   return val; 
}
