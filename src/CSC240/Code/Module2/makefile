all : ftoc out.c cscrape

clean :
	-rm ftoc out.c cscrape lex.yy.c

ftoc : ftoc.c
	gcc ftoc.c -o ftoc

out.c : expand.c
	cpp expand.c > out.c

cscrape : lex.yy.c cscrape-main.c
	gcc lex.yy.c cscrape-main.c -o cscrape

lex.yy.c : cscrape.l
	flex cscrape.l
