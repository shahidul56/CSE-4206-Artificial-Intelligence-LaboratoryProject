
prime(1):- write(' '), write(1).
prime(X):- prime(X, 2).

prime(X, Y):-
X =:= Y, write(' '), write(X).

prime(X, Y):-
Z is X mod Y, Z =\= 0,
X =\= Y, prime(X,Y+1).


prime(X, Y):-
Z is X mod Y,
Z =:= 0,
 X =\= Y.

generate_prime(N):-
generate_prime(N, 1).

generate_prime(N, X):-
N =:= X, prime(X).

generate_prime(N, X):-
N > X,
prime(X),
NX is X + 1,
generate_prime(N, NX).
