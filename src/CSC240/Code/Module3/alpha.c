#include <stdio.h>
#include <string.h>
#include <ctype.h>

char *xlate(char);

int main(int argc, char *argv[]) {
   FILE *f = NULL;
   char c;

   printf("Phonetic Translator - E. Eckert, Spring 2023\n\n");

   if (argc < 2 || (f = fopen(argv[1], "r")) == NULL) {
      printf("The filename is not given or the file cannot be opened.\n");
      return 1;
   }

   while ((c = fgetc(f) ) != -1) {
      printf(" %s", xlate(c));
   }
   printf("\n");

   return 0;
}

char *xlate(char c) {
   static char *phonetic[] = {
      "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", 
      "India", "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", 
      "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", 
      "X-ray", "Yankee", "Zulu"
   };
   static char retVal[2] = { 0, 0 };

   if (isalpha(c)) {
      c = tolower(c);
      return phonetic[c-'a'];
   } else if (isspace(c)) {
      retVal[0] = '\n';
      return retVal;
   }
   retVal[0] = c;
   return retVal;
}
