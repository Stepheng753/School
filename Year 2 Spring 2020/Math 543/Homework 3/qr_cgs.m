function [q, r] = qr_cgs(a)

[m, n] = size(a);
q = zeros([m n]);
r = zeros([n n]);
v = zeros([m n]);

for j= 1 : n
    v(:,j) = a(:,j);
    
    for i = 1 : (j - 1)
        r(i,j) = q(:,i)' * a(:,j);
        v(:,j) = v(:,j) - r(i,j) * q(:,i);
    end
    
    r(j,j) = norm(v(:,j));
    q(:,j) = v(:,j) / r(j,j);
end