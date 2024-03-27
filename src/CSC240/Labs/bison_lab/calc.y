%{
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
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
%token '{'
%token '}'
%token '^'
%token SQRT    666
%token PI      3
%token POUND     2
%token MOD   420
%token I	555
%token SUM	888 

%%
input:  /* empty string */
        | input line
;

line:     '\n'
        | exp '\n'  { printf (">>> %.5g\n", $1); }
;

sum_exp: '{' exp_list '}'	{ $$ = $2; }
;

exp_list: exp	{ $$ = $1;  }
	| exp_list exp { $$ = $1 + $2; }
;

exp:      NUM                { $$ = atof(yytext);    }
        | exp '+' exp        { $$ = $1 + $3;    }
        | exp '-' exp        { $$ = $1 - $3;    }
        | exp '*' exp        { $$ = $1 * $3;    }
        | exp '/' exp        { $$ = $1 / $3;    }
        | exp '^' exp	     { $$ = pow($1, $3);}
        | SQRT '(' exp ')'    { $$ = sqrt($3);   }
        | PI		     { $$ = 3.14159265358979323846264; }
        | exp POUND	     { $$ = $1 * $1;	}
        | I '(' exp ')' '/' exp { $$ = (int) ($3 / $6); }
        | exp MOD exp        { $$ = (int)$1 % (int)$3; }
        | '-' exp 	     { $$ = -$2;        }
        | '(' exp ')'        { $$ = $2;         }
        | sum_exp
;
%%
