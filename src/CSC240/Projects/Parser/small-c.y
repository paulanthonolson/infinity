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
var_decl	: type_specifier var_id_list SEMICOLON
		  
		;

var_id_list	: variable_id
		| variable_id COMMA var_id_list
		;
		
variable_id	: id { printf("Defined variable: %s\n", $1); }
		| id EQUALS expr { printf("Defined variable: %s (with initialization)\n", $1); }
		
		;


type_specifier	: INT 
	        | CONST INT
	        | FLOAT
	        | CONST FLOAT
		;

id		: IDENTIFIER
    		  { $$ = strdup(yytext); }
		;

opt_params	: param_decl_list
		| 
		;
param_decl_list : param_decl
		| param_decl COMMA param_decl_list
		;
param_decl      : type_specifier id
		;

compound_stmt	: LBRACE var_decl_list stmt_list RBRACE 
	          { printf("Found a compound statement\n"); }
		;

stmt_list	: 
		| stmt stmt_list
		;		
		
stmt		: compound_stmt
		| cond_stmt
		| while_stmt
		| do_stmt
		| for_stmt
		| expr SEMICOLON
		| BREAK SEMICOLON { printf("Found a break statement\n"); }
		| CONTINUE SEMICOLON { printf("Found a continue statement\n"); }
		| RETURN expr SEMICOLON { printf("Found a return statement\n"); }
		| READINT LPAREN id RPAREN SEMICOLON
		| WRITEINT LPAREN expr RPAREN SEMICOLON
		| WRITESTRING LPAREN string_constant RPAREN SEMICOLON
		;
		
cond_stmt	: IF LPAREN expr RPAREN stmt { printf("Found an if statement\n"); }
		| IF LPAREN expr RPAREN stmt ELSE stmt { printf("Found an if-else statement\n"); }
		;
		
while_stmt	: WHILE LPAREN expr RPAREN stmt
		  { printf("Found a while loop\n"); }
		;
		
do_stmt		: DO stmt WHILE LPAREN expr RPAREN SEMICOLON
		  { printf("Found a do statement\n"); }
		;
		
for_stmt	: FOR LPAREN expr_list SEMICOLON expr SEMICOLON expr_list RPAREN stmt
		  { printf("Found a for loop\n"); }
		;
		
expr_list	: expr
		| expr COMMA expr_list
		;		
		
var_decl_list	: 
		| var_decl var_decl_list
		;
		
var_decl	: type_specifier var_id_list SEMICOLON
		;

expr		: id EQUALS expr { printf("Found assignment expression for: %s\n", $1); }
		| expr QUESTION expr COLON expr { printf("Found ? expression\n"); }
		| expr OR_OR expr { printf("Found || expression\n"); }
		| expr AND_AND expr { printf("Found && expression\n"); }
		| expr EQUALS_EQUALS expr { printf("Found == expression\n"); }
		| expr NE expr { printf("Found != expression\n"); }
		| expr LESS expr { printf("Found < expression\n"); }
		| expr GREATER expr { printf("Found > expression\n"); }
		| expr LE expr { printf("Found <= expression\n"); }
		| expr GE expr { printf("Found >= expression\n"); }
		| expr PLUS expr { printf("Found + expression\n"); }
		| expr MINUS expr { printf("Found - expression\n"); }
		| expr TIMES expr { printf("Found * expression\n"); }
		| expr DIVIDE expr { printf("Found / expression\n"); }
		| expr MOD expr { printf("Found insert mod here expression\n"); }
		| BANG expr { printf("Found ! expression\n"); }
		| MINUS expr{ printf("Found unary - expression\n"); }
		| AND expr { printf("Found & expression\n"); }
		| integer_constant 
		| float_constant
		| string_constant
		| id
		| id PLUS_PLUS { printf("Found ++ expression\n"); }
		| id MINUS_MINUS { printf("Found -- expression\n"); }
		| LPAREN expr RPAREN
		| id LPAREN RPAREN 
		| id LPAREN arg_list RPAREN { printf("Found function call: %s (with arguments)\n", $1); }
	      	  
		;
float_constant	: REAL_CONST
		;

integer_constant : INT_CONST
		 ;

string_constant  : STRING_CONST
		 ;

arg_list	 : expr
		 | expr COMMA arg_list
		 ;			

%%

