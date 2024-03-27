#include <stdio.h> 

int yylex ();	// scanner prototype
extern char* yytext;
	
int main ()
{
   printf("Comment Scraper\n");
	
   while (yylex()) { }

   return 0;
}
