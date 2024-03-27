#include <stdio.h>

int main(int argc, char *argv[]) {
   char c;
   int linecount = 0;

   FILE *f = NULL;
   if (argc >=2)
      f = fopen(argv[1], "r");

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
