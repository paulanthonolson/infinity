%option noyywrap

%%

\"[^\"]*\"	;

"/*"((("*"[^/])?)|[^*])*"*/"	{ printf("%s\n", yytext); }
"//".*				{ printf("%s\n", yytext); }

. 				;
"\n"				;

%%

void yyerror () {
   printf (" error\n");
   exit(0);
}
