%option noyywrap

%%

table		{ return 1; }
horse		{ return 2; }
computer	{ return 3; }
big		{ return 4; }
fast		{ return 5; }
good		{ return 6; }
high		{ return 7; }
makes		{ return 8; }
is		{ return 9; }
red		{ return 10;}
'?'		{ return 11;}


%%

void yyerror () {
   printf (" error\n");
   exit(0);
}
