#include <stdio.h>

int main() {
   char c;
   int linecount = 0;

   FILE *f = fopen("linecount.c", "r");
   if (f == NULL) {
      printf("File doesn't exist\n");
      return 1;
   }

   while (!feof(f)) {
      c = fgetc(f);
      if (c == '\n') 
		linecount++;
   }
   fclose(f);

   printf("%d lines\n", linecount);
}
