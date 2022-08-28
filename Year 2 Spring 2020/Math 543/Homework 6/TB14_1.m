A = [1 1;1 1.0001; 1 1.0001 ];
b = [2; 0.0001; 4.0001];

Ap = (transpose(A)*A)\transpose(A);

P = A*Ap;
x = Ap*b;
y = P*b;

%-----------------------------------------------------------------

da = [10^(-12) -10^(-12); -10^(-12) 10^(-12); 10^(-12) -10^(-12)];
At = A + da;

Atp = (transpose(At)*At)\transpose(At);
Pt = At*Atp;
xt = Atp*b;
yt = Pt*b;

( norm(yt - y) / norm(y) ) / (norm(da) / norm(A)) %#ok
( norm(xt - x) / norm(x) ) / (norm(da) / norm(A)) %#ok