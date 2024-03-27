edge(a,b). 
edge(a,c). 
edge(b,d). 
edge(c,d). 
edge(c,f). 
edge(d,e). 
edge(f,g). 
edge(g,h). 
edge(i,j).

edge(b,a).
edge(c,a).
edge(d,b).
edge(d,c).
edge(f,c).
edge(e,d).
edge(g,f).
edge(h,g).
edge(j,i).


connected(Node1, Node2) :-
	edge(Node1, Node2), !.

connected(Node1, Node2) :-
	edge(Node1, X),
	connected(X, Node2).