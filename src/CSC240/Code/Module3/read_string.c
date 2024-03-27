#include <stdio.h>

int main() {
   char buf[100];

   printf("Enter a string: ");
   fgets(buf, 100, stdin);

   printf("String entered: ");
   fputs(buf, stdout);

   putc('\n', stdout);

   return 0;
}

