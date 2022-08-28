clear
figure(1)
clf
hold off

grid on
hold on

x = linspace(0,1,101);
x = transpose(x);

bigK = 1000;
c = zeros(bigK,1);

for k = 0 : bigK
    A = x .^ 0;
    for i = 1 : k
        A = horzcat(A,x.^i);
    end
    c(1 + k,1) = log10(cond(A,2));
end

k = 0 : bigK;
plot(k,c,'r')

title('Condition Numbers for Vandermonde Matrix, $A_k$','interpreter','latex');
xlabel('k values');
ylabel('$log_{10} \kappa (A_k)$','interpreter','latex')
xticks(0:25:bigK);
yticks(0:1:30);

