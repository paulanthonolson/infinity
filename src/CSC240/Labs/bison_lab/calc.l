%option noyywrap

%%

[0-9]+([\.][0-9]+)?	{ return 1;   }
"-"	{ return '-'; }
"+"	{ return '+'; }
"*"	{ return '*'; }
"/"	{ return '/'; }
"("	{ return '('; }
")"	{ return ')'; }
\n	{ return '\n'; }
.	;

%%

void yyerror () {
   printf (" error\n");
   exit(0);
}
