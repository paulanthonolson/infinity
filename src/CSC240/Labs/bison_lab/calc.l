%option noyywrap

%%

[0-9]+([\.][0-9]+)?	{ return 1;   }
"-"	{ return '-'; }
"+"	{ return '+'; }
"*"	{ return '*'; }
"/"	{ return '/'; }
"("	{ return '('; }
")"	{ return ')'; }
"{"	{ return '{'; }
"}"	{ return '}'; }
"^"     { return '^'; }
"SQRT"  { return 666; }
"PI"	{ return 3;   }
"#" 	{ return 2;   }
"I"	{ return 555; }
"%"     { return 420; }
"sum"   { return 888; }
\n	{ return '\n';}
.	;

%%

void yyerror () {
   printf (" error\n");
   exit(0);
}
