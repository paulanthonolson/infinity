hanoi(N) :- move(N, source, center, destination).

move(1, S, _, D) :- 	 % stopping condition 
	write('Move top from '), write(S), write(' to '), write(D), 
	nl. 	 		% nl = newline 
move(N, S, C, D) :- 	
	N>1, 
	M is N-1, 
	move(M, S, D, C), 	 % move N-1 disks from S to C
	move(1, S, _, D), 	 % move remaining 1 from S to D
	move(M, C, S, D).	 % move N-1 disks from C to D
