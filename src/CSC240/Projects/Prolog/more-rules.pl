mother_of(X,Y) :- 
   family(_, X, Children), 
   member(Y,Children).

