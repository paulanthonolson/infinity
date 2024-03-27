#include <stdio.h>

int fact(int);

int main() {
   int n;

   printf("Enter an integer: ");
   scanf("%d", &n);

   printf("%d! = %d\n", n, fact(n));

   return 0;
}

int fact(int x) {
   if (x <= 1) 
      return 1;
   return x * fact(x-1);
}

