l-and(1, 1, 1).
l-and(0, 0, 0).
l-and(0, 1, 0).
l-and(1, 0, 0).
l-or(0, 0, 0).
l-or(0, 1, 1).
l-or(1, 0, 1).
l-or(1, 1, 1).
l-not(0, 1).
l-not(1, 0).

frank(A,B,C,D,E,F,Z) :- 
   l-not(A,R),
   l-or(R,B,T),
   l-not(C,U),
   l-and(T,U,W),
   l-or(D,E,Q),
   l-and(Q,F,S),
   l-not(S,V),
   l-or(C,V,X),
   l-or(W,X,Y),
   l-not(Y,Z).
