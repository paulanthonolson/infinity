#include <stdio.h>

void foo(int *m) { 
printf("m = %d\n", *m);
*m = 2; 
printf("m = %d\n", *m);
}

void main() {
   int i = 1;
   printf("i = %d\n", i);
   foo(&i);  
   printf("i = %d\n", i);
} 

