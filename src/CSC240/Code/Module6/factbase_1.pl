mother_of(jane, elaine).
mother_of(jane, mike).
mother_of(elaine, bob).

father_of(david, elaine).
father_of(david, mike).

sibling_of(X, Y) :- mother_of(P, X), mother_of(P, Y).
sibling_of(X, Y) :- father_of(P, X), father_of(P, Y).

grandmother_of(X, Z) :- mother_of(X, Y), mother_of(Y, Z).
grandmother_of(X, Z) :- mother_of(X, Y), father_of(Y, Z).

male(luke).
male(mike).
female(sarah).

class(csc240, programming, mwf, "12:00").

likes(john, pizza).
likes(john, mary).
likes(john, chocolate).
likes(john, ponies).

likes(henry, pizza).

likes(mary, john).
likes(mary, heavy_metal).
likes(mary, vegan_food).
likes(mary, ponies).

change(H,Q,D,N,P) :-
	member(H,[0,1,2]), 		 	
	member(Q,[0,1,2,3,4]), 		 	
	member(D,[0,1,2,3,4,5,6,7,8,9,10]), 	
	member(N,[0,1,2,3,4,5,6,7,8,9,10,11,
                  12,13,14,15,16,17,18,19,20]), 
	S is 50*H + 25*Q +10*D + 5*N,
	S =< 100,
	P is 100-S.

allchange :-
   write("All of the ways to make a dollar:"), nl,
   change(H,Q,D,N,P),
   write(H),write("x50 "),
   write(Q),write("x25 "),
   write(D),write("x10 "),
   write(N),write("x5 "),
   write(P),write("x1"), nl,
   fail.

allchange.


weather(tempe,      spring, warm).
weather(tempe,      summer, hot).
weather(tempe,      fall,   hot).
weather(tempe,      winter, warm).
weather(phoenix,    spring, hot).
weather(phoenix,    summer, hot).
weather(phoenix,    fall,   hot).
weather(phoenix,    winter, warm).
weather(wellington, spring, warm).
weather(wellington, summer, warm).
weather(wellington, fall,   hot).
weather(wellington, winter, cold).
weather(toronto,    spring, cold).
weather(toronto,    summer, hot).
weather(toronto,    fall,   cold).
weather(toronto,    winter, cold).

warmer_than(C1, C2) :-
	weather(C1, spring, hot),
	weather(C2, spring, warm).

colder_than(C1, C2) :-
	weather(C1, winter, cold),
	weather(C2, winter, warm).

weatherquestions :-
	warmer_than(phoenix, X),
	write('Phoenix is warmer than '), write(X), nl.
