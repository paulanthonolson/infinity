#include <stdlib.h> // Includes the declaration of malloc()

void main() {
   int *ip;
   ip = (int *) malloc(sizeof(int));
   *ip = 5;
   
   int *a;
   a = (int *) malloc(sizeof(int) * 100);
   a[0] = 0; a[99] = 99;
   
   struct person {
      char name[20];
      int id;
   };
   
   struct person *p = (struct person *) malloc(sizeof(struct person));
} 
