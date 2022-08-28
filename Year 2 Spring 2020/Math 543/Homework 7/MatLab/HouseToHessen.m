function A = HouseToHessen (A)

m = size(A);
for k = 1 : (m - 2)
    x = A((k + 1): m, k);
    e1 = zeros(size(x));
    e1(1) = 1;
    vk = sign(x(1)) * norm(x)*e1 + x;
    vk = vk / norm(vk);
    A((k + 1): m, k : m) = A((k + 1): m, k : m) - 2*vk*(transpose(vk) *A((k + 1): m, k : m));
    A(1 : m, (k + 1) : m) = A(1 : m, (k + 1) : m) - 2*(A(1 : m, (k + 1) : m) * vk) * transpose(vk);
end

