#include <string>

using namespace std;

class Queue {
   protected:
      int *data;
      int front;
      int length;
      int capacity;

   public: 
      Queue(int c);
      ~Queue();
      int size() { return length; }
      bool isEmpty() { return (length == 0); }
      void enqueue(int e);
      int first();
      int dequeue();
      string toString();
};
