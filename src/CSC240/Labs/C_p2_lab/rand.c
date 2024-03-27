#include <stdio.h>

int inlist(int, int*, int);
void numIter(int, int *);

int main() {
   int list[] = { 593, 973, 984, 397, 140, 250, 384, 293, 112, 817, 
                  674, 800, 261, 891, 843, 159, 857, 922, 579, 475 };

   printf("Array:    ");
   // Print list using the array syntax

   printf("Pointers: ");
   // Print list using the pointer syntax

   // DO-while loop: continue to ask for numbers until a number is NOT found
   int n;
   do {
      // Your code here
   } while (inlist(n, list, 20) >= 0);

   // Ask for a random number seed and print the number of iterations before a repeat.

   return 0;
}	

int inlist(int target, int* pool, int size) {
   // Return the position of target in pool or -1 if not found
   return -1;
}
	
void numIter(int x, int *n) {
   // Set *n to the number of iterations of the random number generator before a repeat is found.
   *n = 0;
}
