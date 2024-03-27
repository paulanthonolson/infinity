#include "queue.h"

class Priority_Queue : public Queue {
   private:
      int find_first();

   public:
      Priority_Queue(int n) : Queue(n) { }
      int first();
      int dequeue();
};
