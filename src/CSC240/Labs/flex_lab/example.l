%option noyywrap

%%

while   { printf("1: Found a while: %s\n", yytext); }

for   { printf("2: Found a for: %s\n", yytext); }

if   { printf("3: Found an if: %s\n", yytext); }

[01][01][01][01]*   { printf("4: Found a binary number: %s\n", yytext); }

[-+]?[0-9]*\.?[0-9]+   { printf("5: Found a number: %s\n", yytext); }

[A-Za-z_][a-zA-Z0-9_]*  { printf("6: Found legal C identifiers: %s\n", yytext); }

\"[^"]*\" { printf("7: Found string literals: %s\n", yytext); }

^#.*    { printf("8: Found a comment: %s\n", yytext); }

\/\/.*$ { printf("9: Found a single line comment: %s\n", yytext); }


[ \t\n\r\f]

.	{ printf("*%s*\n", yytext); }

%%

int main(int argc, char *argv[]) {
  yylex();
}

