#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int gcd(int n, int m) {
   if (n == 0) return m;
   else if (n <= m) return gcd(n, m-n);
   else return gcd (m, n);
}

int main() {
   int i, n, m;
   srand( (unsigned)time( NULL ) );  // Use current time as seed

   i = 1;
   while (i <= 10) {
      n = rand() % 100 + 1;
      m = rand() % 100 + 1;
      if (gcd(n, m) > 2) {
         printf( "%2d) gcd(%2d, %2d) = %2d\n", i, n, m, gcd(n, m) );
         i++;
      }
   }

   return 0;
}
