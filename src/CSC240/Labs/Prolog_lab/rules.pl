mother_of(X,Y) :- 
   female(X), 
   parent_of(X,Y).

father_of(X,Y) :-
   male(X),
   parent_of(X,Y).

