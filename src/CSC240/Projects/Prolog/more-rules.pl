mother_of(X, Y) :- 
   family(_, X, Children), 
   member(Y, Children).

father_of(X, Y) :-
   family(X, _, Children),
   member(Y, Children).

sibling_of(X, Y) :-
   family(_, X, Children),
   family(_, Y, Children),
   X \= Y.

brother_of(X, Y) :-
   male(X),
   family(_, X, Children),
   family(_, Y, Children),
   X \= Y.

sister_of(X, Y) :-
   female(X),
   family(_, X, Children),
   family(_, Y, Children),
   X \= Y.

parent_of(X, Y) :-
   mother_of(X, Y);
   father_of(X, Y).

grandparent_of(X, Y) :-
   family(X, _, Children),
   member(Z, Children),
   family(Z, Y, _).

uncle_of(X, Y) :-
   brother_of(X, Z),
   parent_of(Z, Y).

aunt_of(X, Y) :-
   sister_of(X, Z),
   parent_of(Z, Y).

cousin_of(X, Y) :-
   parent_of(Z, X),
   sibling_of(Z, W),
   parent_of(W, Y).

ancestor_of(X, Y) :-
   parent_of(X, Y).
   ancestor_of(X, Y) :-
      parent_of(X, Z),
      ancestor_of(Z, Y).


print_all_ancestors(X) :-
   write('The ancestors of '), 
   write(X), 
   write(' are: '), nl,
   (
      ancestor_of(Y, X),
      write(' '),
      write(Y), nl,
      
      fail
   );
   true.






