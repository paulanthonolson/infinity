mother_of(X,Y) :- 
   female(X), 
   parent_of(X,Y).

father_of(X,Y) :-
   male(X),
   parent_of(X,Y).

sibling_of(X,Y) :-
   parent_of(Z,X),
   parent_of(Z,Y),
   X \= Y.

brother_of(X,Y) :-
   male(X),
   sibling_of(X,Y),
   X \= Y.

sister_of(X,Y) :-
   female(X),
   sibling_of(X,Y),
   X \= Y.

grandparent_of(X,Y) :-
   parent_of(X,Z),
   parent_of(Z,Y).

uncle_of(X,Y) :-
   brother_of(X,Z),
   parent_of(Z,Y).

aunt_of(X,Y) :-
   sister_of(X,Z),
   parent_of(Z,Y).

cousin_of(X,Y) :-
   parent_of(Z,X),
   sibling_of(Z,W),
   parent_of(W,Y).
