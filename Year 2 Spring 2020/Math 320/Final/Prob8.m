function [a] = Prob8

modNum = 10;
a = zeros(modNum,1);

for x = 0:(modNum - 1)
    a(x+1,1) = mod(x^5 + 35*x^4 + 525*x^3 + 4375*x^2 + 21875*x + 65625, modNum);
end
a = transpose(a);