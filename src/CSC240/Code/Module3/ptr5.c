#include<stdio.h>
#include <string.h>

void main() {
   char *p = "Hello World!";

   while (*p != '\0') {
      putc(*p, stdout);
      p++;
   }

   printf("\n");
}

