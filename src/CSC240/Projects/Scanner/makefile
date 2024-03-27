small-c : small-c-main.c lex.yy.c tokens.h
	gcc small-c-main.c lex.yy.c -o small-c 

lex.yy.c : small-c.l tokens.h
	flex small-c.l
