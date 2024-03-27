#include <stdio.h>

void main() { 				
   int i, j, max;

   printf("Please enter an integer: ");
   scanf("%d", &max);

   for (i = 1; i <= max; i++) {
      for (j = 1; j <= max; j++) {
         printf("%3d ", i*j);
      }
      printf("\n");
   }
}
