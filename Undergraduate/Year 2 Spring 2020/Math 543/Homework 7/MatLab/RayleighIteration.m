function [lambdam, vm] = RayleighIteration (A)

m = size(A,1);
v = zeros(m, m);
v(:,1) = rand(m,1);
v(:,1) = v(:,1) / norm(v(:,1));
lambda = zeros(m,1);
lambda(1) = transpose(v(:,1)) * A * v(:,1);
k = 1;
I = eye(m);

while k < m 
    k = k + 1;
    w = linsolve(A - lambda(k-1)*I, v(:,(k-1)));
    v(:,k) = w / norm(w);
    lambda(k) = transpose(v(:,k)) * A * v(:,k);
end

vm = v(:,m);
lambdam = lambda(m);