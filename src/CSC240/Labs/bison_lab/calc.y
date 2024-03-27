%{
#include <stdio.h>
#include <stdlib.h>
int yylex (void);
void yyerror (char const *);
extern char *yytext;
%}
%define api.value.type {double}

%token NUM	1
%token '-'
%token '+'
%token '*'
%token '/'
%token '('
%token ')'

%%
input:  /* empty string */
        | input line
;

line:     '\n'
        | exp '\n'  { printf (">>> %.5g\n", $1); }
;

exp:      NUM                { $$ = atof(yytext);    }
        | exp '+' exp        { $$ = $1 + $3;    }
        | exp '-' exp        { $$ = $1 - $3;    }
        | exp '*' exp        { $$ = $1 * $3;    }
        | exp '/' exp        { $$ = $1 / $3;    }
        | '-' exp 	     { $$ = -$2;        }
        | '(' exp ')'        { $$ = $2;         }
;
%%
