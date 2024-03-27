%option noyywrap

%{
#include "tokens.h"
%}


%option yylineno

%%
	// Keywords
break 		{ return BREAK;		}


	/* Punctuation */
"("		{ return LPAREN;	}


	/* Constants: Integer, real and string */
[-+]?[0-9]+	{ return INT_CONST;	}


	/* Identifiers */


	/* New-line is used in the Scanner only for tracking lines */
"\n"		{ return NEWLINE; }


	/* Ignored stuff: macros, comments, whitespace (tab, newline, carriage return, space) */


	/* Anything not matches in a lexical error. */
.		{ printf("%d: Lexical Error: '%c'\n", yylineno, yytext[0]); exit(0); }

%%


