%{
#include <stdio.h>
#include <string.h>

int yylex (void);
void yyerror (char const *);
extern char *yytext;

%}

%define api.value.type {char *}

%token AND		1001
%token AND_AND		1002
%token BANG		1003
%token BREAK		1004
%token COLON		1005
%token COMMA		1006
%token CONST		1007
%token CONTINUE		1008
%token DIVIDE		1009
%token DO		1010
%token ELSE		1011
%token EQUALS		1012
%token EQUALS_EQUALS	1013
%token FLOAT		1014
%token FOR		1015
%token GE		1016
%token GREATER		1017
%token IDENTIFIER	1018
%token IF		1019
%token INT		1020
%token INT_CONST	1021
%token LBRACE		1022
%token LE		1023
%token LESS		1024
%token LPAREN		1025
%token MINUS		1026
%token MINUS_MINUS	1027
%token MOD		1028
%token NE		1029
%token NEWLINE		1030
%token OR		1031
%token OR_OR		1032
%token PLUS		1033
%token PLUS_PLUS	1034
%token QUESTION		1035
%token RBRACE		1036
%token READINT		1037
%token REAL_CONST	1038
%token RETURN		1039
%token RPAREN		1040
%token SEMICOLON	1041
%token STRING_CONST	1042
%token TIMES		1043
%token WHILE		1044
%token WRITEINT		1045
%token WRITESTRING	1046

%%

smallc_program	:  global_decl_list 
	        ;

global_decl_list: global_decl
                | global_decl global_decl_list
                ;

global_decl	: function_decl
	        | var_decl 
                ;

function_decl	: type_specifier id LPAREN opt_params RPAREN compound_stmt
	      	  { printf("Found function definition: %s\n", $2); }
		;

type_specifier	: INT 
	        | CONST INT
	        | FLOAT
	        | CONST FLOAT
		;

id		: IDENTIFIER
    		  { $$ = strdup(yytext); }
		;

compound_stmt	: LBRACE var_decl_list stmt_list RBRACE 
	          { printf("Found a compound statement\n"); }
		;

variable_id	: id
	          { printf("Defined variable %s\n", $1); }
		;

expr		: id EQUALS expr
	      	  { printf("Found assignment expression for: %s\n", $1); }
		;

%%

