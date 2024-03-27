#include <stdio.h>

void main() {
   int f;

   printf("Enter the temp in F: ");
   scanf("%d", &f);
   printf("The temp in C is %d\n", 5*(f-32)/9);
}
