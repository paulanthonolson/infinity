%option noyywrap

%{
#include "tokens.h"
%}


%option yylineno

%%
	// Keywords
break 		{ return BREAK;		}

continue	{ return CONTINUE;	}

do		{ return DO;		}

while		{ return WHILE;		}

return		{ return RETURN;	}

for		{ return FOR;		}

if		{ return IF;		}

int		{ return INT;		}

readint		{ return READINT;	}

writeint	{ return WRITEINT;	}

writestring	{ return WRITESTRING;	}

float		{ return FLOAT;		}

else		{ return ELSE;		}

const		{ return CONST;		}




	/* Punctuation */
"{"		{ return LBRACE;	}

"}"		{ return RBRACE;	}	
	
"("		{ return LPAREN;	}

")"		{ return RPAREN;	}

","		{ return COMMA;		}

";"		{ return SEMICOLON;	}

"="		{ return EQUALS;	}

"?"		{ return QUESTION;	}

":"		{ return COLON;		}

"||"		{ return OR_OR;		}

"&&"		{ return AND_AND;	}

"=="		{ return EQUALS_EQUALS;	}

"!="		{ return NE;		}

"<"		{ return LESS;		}

">"		{ return GREATER;	}

"<="		{ return LE;		}

">="		{ return GE;		}

"+"		{ return PLUS;		}

"-"		{ return MINUS;		}

"*"		{ return TIMES;		}

"/"		{ return DIVIDE;	}

"%"		{ return MOD;		}

"!"		{ return BANG;		}

"&"		{ return AND;		}

"++"		{ return PLUS_PLUS;	}

"--"		{ return MINUS_MINUS;	}

	
	/* Constants: Integer, real and string */
[-+]?[0-9]+	{ return INT_CONST;	}

[-+]?[0-9]+\.[0-9]*  { return REAL_CONST; }

\".*\"		{ return STRING_CONST;	}


	/* Identifiers */
[a-zA-Z_][a-zA-Z0-9_]*	{ return IDENTIFIER;	}


	/* Ignored stuff: macros, comments, whitespace (tab, newline, carriage return, space) */
[ \t\r\n]+	// Ignored Whitespace, Tab, Carriage Return

"//".*		// Ignore single line comments

^#.*		// Ignore # and line





	/* Anything not matches in a lexical error. */
.		{ printf("%d: Lexical Error: '%c'\n", yylineno, yytext[0]); exit(0); }

%%

void yyerror () {
	printf ("%d: Syntax error\n", yylineno);
	exit(0);
	}


