#include <stdio.h>

void main() {
   int i = 12345;
   int *j = &i;
   int **k = &j;

   printf("i is %d, *j is %d, **k is %d\n", i, *j, **k);
   printf("j is %ld, k is %ld\n\n", (long) j, (long) k);

   **k = 54321;

   printf("i is %d, *j is %d, **k is %d\n", i, *j, **k);
   printf("j is %ld, k is %ld\n", (long) j, (long) k);
}

