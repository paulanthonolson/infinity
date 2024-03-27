edge(a,b). 
edge(a,c). 
edge(b,d). 
edge(c,d). 
edge(c,f). 
edge(d,e). 
edge(f,g). 
edge(g,h). 
edge(i,j).

edge(X, Y) :- edge(Y, X).

connected(Node1, Node2) :-
	edge(Node1, Node2), !.

connected(Node1, Node2) :-
	edge(Node1, X),
	connected(X, Node2).