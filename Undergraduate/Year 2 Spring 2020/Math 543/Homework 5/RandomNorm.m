clear		
figure(101)           
clf                
hold off

n = 500;
hold on
grid on
xlim([0,n]);
ylim([1,2.5]);
xticks(0:n/20:n);
yticks(1:.125:2.5);
xlabel('m Vals')
ylabel('Norm Vals')
title('Norm Values of Random m x m Matrices')
for m = 1: n
    A = randn(m,m) ./ sqrt(m);
    normVals = norm(A);

    plot(m,normVals,'*');
end






