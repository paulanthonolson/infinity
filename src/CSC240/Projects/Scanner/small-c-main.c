#include <stdio.h>
#include "tokens.h"

extern FILE *yyin;
extern char *yytext;
int yylex();

int main(int argc, char *argv[]) {
   int tokenNumber;
   int lineNumber = 1;

   printf("Small-C Scanner - Paul Olson\n");
   
   if (argc != 2) {
      fprintf(stderr, "usage: small-c <filename>\n");
      return 1;
   }
   
   char *filename = argv[1];
   yyin = fopen(filename, "r");

   printf("\n%3d) ", lineNumber++);

   while ((tokenNumber = yylex()) != 0) { // call scanner until it returns 0 for EOF
      switch (tokenNumber) {
         case NEWLINE: printf("\n%3d) ", lineNumber++);  break;
         case IDENTIFIER:
         case INT_CONST:
         case REAL_CONST:
         case STRING_CONST: printf ("%d (%s) ", tokenNumber, yytext);  break;
         default:           printf ("%d ", tokenNumber);               break;
      }	
   }
   printf("\n");

   fclose(yyin);
   
   return 0;
}
