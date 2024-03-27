first(X, [X | _ ]).

second(X, [ _, X | _ ]).	

last(X, [X]).
last(X, [ _ | Tail]) :- last(X, Tail).

count([], 0) :- !.
count([ _ | Tail], S) :-
	  count(Tail, S2),
	  S is 1 + S2.

sum_list([], 0).
sum_list([Head|Tail], Sum) :-
	  sum_list(Tail, Sum2),
	  Sum is Head + Sum2.

addhead(List, Element, [Element | List]).

append([], X, X).
append([X | Y], Z, [X | W]) :-
   append(Y, Z, W).

