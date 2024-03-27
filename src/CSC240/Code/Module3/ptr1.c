#include <stdio.h>

void main() {
   int a[10] = {1,2,3,4,5,6,7,8,9,10};
   int i;

   for (i=0; i<10; i++) printf("%d ", a[i]); printf("\n");

   int *p = &a[0];
   *p = 11;

   p = p + 1;
   *p = 22;

   p++;
   *p = 33;

   p += 3;
   *p = 66;

   p -= 2;
   *p = 44;

   for (i=0; i<10; i++) printf("%d ", a[i]); printf("\n");
}

