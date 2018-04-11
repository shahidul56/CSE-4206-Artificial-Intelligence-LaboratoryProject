print1(N, X):-
N =:= X, write(' '),
write(X),nl.


print1(N, X):-

 N > X, write(' '),
 write(X), NX is X + 1,
 print1(N, NX).

generate_series(N):-
generate_series(N, 1).

generate_series(N, X):-
N =:= X, print1(X, 1).

generate_series(N, X):-
N > X, print1(X, 1),
NX is X + 1,
generate_series(N, NX).



