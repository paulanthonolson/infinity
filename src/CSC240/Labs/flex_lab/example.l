%option noyywrap

%%

while   { printf("1: Found a while: %s\n", yytext); }

[a-z]+  { printf("2: Found letters: %s\n", yytext); }

[01][01][01][01]*   { printf("3: Found a binary number: %s\n", yytext); }

[-+]?[0-9]*\.?[0-9]+   { printf("4: Found a number: %s\n", yytext); }

^#.*    { printf("5: Found a comment: %s\n", yytext); }

[ \t\n\r\f] 

.	{ printf("*%s*\n", yytext); }

%%

int main(int argc, char *argv[]) {
  yylex();
}

