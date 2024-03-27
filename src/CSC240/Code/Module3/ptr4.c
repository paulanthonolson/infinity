#include <stdio.h>
#include <string.h>

void main() {
   int n, len; 
   char str[] = "Hello World!";
   len = strlen(str);

   for(n=0; n<len; n++) 
      putc(str[n], stdout);

   printf("\nn = %d\n", n);
}

