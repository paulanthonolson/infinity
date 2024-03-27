#include <stdio.h>
#include "tokens.h"

extern FILE *yyin;
extern char *yytext;
int yyparse();

int main(int argc, char *argv[]) {
   int tokenNumber;
   int lineNumber = 1;

   printf("Small-C Parser - Student Name\n");
   
   if (argc != 2) {
      fprintf(stderr, "usage: small-c <filename>\n");
      return 1;
   }
   
   char *filename = argv[1];
   yyin = fopen(filename, "r");

   yyparse();

   fclose(yyin);
   
   return 0;
}
