#include <iostream>

using namespace std;

int main() {
   int *queue, n;

   cout << "Enter queue-size >= 10: " << endl;
   cin >> n;

   try {
      if (n < 10) throw /* nothing */ ;
      queue = new int[n];
      if (queue == NULL || n == 22)
         throw "Heap allocation failed!";
   }
   catch (char const *se) {
      cout << "Exception: " << se << endl;
   }
   catch (int ie) {
      cout << "Exception: " << ie << " too small" << endl;
   }
   
   return 0;
}
