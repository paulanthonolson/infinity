drm([],[]):- !. 

drm([Head|Tail], L):- 
   member(Head,Tail), 
   write("removed member = "), write(Head), nl, 
   drm(Tail, L), !.

drm([H|T1],[H|T2]):- 
   drm(T1, T2).

