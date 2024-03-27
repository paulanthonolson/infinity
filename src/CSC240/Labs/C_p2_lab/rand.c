#include <stdio.h>
#include <stdlib.h>

int inlist(int, int*, int);
void numIter(int, int *);

int main() {
   int list[] = { 593, 973, 984, 397, 140, 250, 384, 293, 112, 817, 
                  674, 800, 261, 891, 843, 159, 857, 922, 579, 475 };
   
   int list_size = sizeof(list) / sizeof(list[0]);
   
   
   printf("Array: ");
   // Print list using the array syntax
   
   for(int i = 0; i < list_size; i++){
   printf("%3d ", list[i]);}

   printf("Pointers: ");
   // Print list using the pointer syntax
   
   for(int *p = list; p < &list[list_size]; p++){
   printf("%3d ", *p);}

   // DO-while loop: continue to ask for numbers until a number is NOT found
   int n, iterations = 0; 
   int seed, seed_squared, pos = -1;

   do {
        printf("What number are you looking for? ");
        scanf("%d", &n);
        
        pos = inlist(n, list, list_size);
        if (pos >= 0) {
            printf("Number %d is at position %d\n", n, pos);
        } else {
            printf("Number %d is not in the list\n", n);
        }

        iterations++;
    
    } while ((pos = inlist(n, list, list_size)) >= 0);
   // Ask for a random number seed and print the number of iterations before a repeat.
    
     
        printf("Enter a 4 digit number: ");
        scanf("%d", &seed);
       

        numIter(seed, &iterations);
        printf("Number of iterations before a repeat: %d\n", iterations);
    

    return 0;
}

int inlist(int target, int* pool, int size) {
   // Return the position of target in pool or -1 if not found
   
   for(int i = 0; i < size; i++){ 
       if (pool[i] == target) {
            return i;
       }
   }
   return -1;
}

	
void numIter(int x, int *n) {
    *n = 0;
    int iterations = 0;
    int seed = x;
    int new_seed = 0;
    int generated_seeds[10000] = {0};

     if (x < 0 || x >= 10000) {
        printf("Seed value too high pick a number between 1 and 9999.");
        return;
    }

    do {
        int seed_squared = seed * seed;
        int new_seed = (seed_squared / 100) % 10000;

        if (generated_seeds[new_seed] == 1) {
            break;
        }
        generated_seeds[new_seed] = 1; 
        seed = new_seed;
        iterations++;
    } while (1);

    *n = iterations;
}
