#include <stdio.h> 

int yyparse();
	
int main () {
   printf("Calculator– ver. 0.1\n\n");

   yyparse();

   return 0;
}

