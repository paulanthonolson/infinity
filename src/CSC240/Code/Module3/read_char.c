#include <stdio.h>

int main() {
   char c;

   printf("Enter a single character: ");
   c = getc(stdin);

   printf("Character entered: ");
   putc(c, stdout);

   putc('\n', stdout);

   return 0;
}

