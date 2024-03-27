#include <stdio.h>

int main () {
   int *x, *y;
   int a[10];

   x = &a[2];
   y = &a[4];

   printf("%ld\n", y - x);

   return 0;
}

