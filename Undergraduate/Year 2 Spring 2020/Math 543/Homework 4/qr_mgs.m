function [Q, R] = qr_mgs(A)

[m, n] = size(A);
Q = zeros([m n]);
R = zeros([n n]);
v = zeros([m n]);

for i = 1 : n
    v(:,i) = A(:, i);
end

for i = 1 : n
    R(i,i) = norm(v(:,i));
    Q(:,i) = v(:,i) / R(i,i);
    
    for j = (i + 1) : n
        R(i,j) = Q(:,i)' * v(:,j);
        v(:,j) = v(:,j) - R(i,j) * Q(:,i);
    end
end

