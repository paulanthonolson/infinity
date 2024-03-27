#include "queue.h"

using namespace std;

Queue::Queue(int c) {
   capacity = c;
   data = new int[capacity];
   front = 0;
   length = 0;
}

Queue::~Queue() {
   delete data;
}

void Queue::enqueue(int e) {
   if (length == capacity) fprintf(stderr, "Queue is full");

   int avail = (front + length) % capacity;
   data[avail] = e;
   length++;
}

int Queue::first() {
   if (isEmpty()) {
      fprintf(stderr, "Queue is empty");
	    return -1;
   }

   return data[front];
}

int Queue::dequeue() {
   if (isEmpty()) {
      fprintf(stderr, "Queue is empty");
	    return -1;
   }

   int answer = data[front];
   front = (front + 1) % capacity;
   length--;

   return answer;
}

string Queue::toString() {
   string s = "";
   int pos;

   for(int i = 0, pos = front; i < length; i++, pos = (pos + 1) % capacity) {
      s += (to_string(data[pos]) + " ");
   }

   return s;
}
