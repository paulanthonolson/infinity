%option noyywrap
%option yylineno
%{
#include "tokens.h"
%}




%%
	
finally 	{ return FINALLY; }

"&&"		{ return AND_AND; }

[0-9]+		// Found a line with 1 or more digits	

[xX][0-9a-fA-F]+ // A hexadecimal integer constant made up of 1 or more hexadecimal digits

[ \t\r]+	// ignore all whitespace

\n		// track newlines


%%

int main(int argc, char *argv[]) {
  yylex();
  return 0;
}


