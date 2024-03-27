small-c : small-c-main.c lex.yy.c small-c.tab.c tokens.h
	gcc small-c-main.c lex.yy.c small-c.tab.c -o small-c 

lex.yy.c : small-c.l tokens.h
	flex small-c.l

small-c.tab.c : small-c.y tokens.h
	bison --warnings=none small-c.y
