close all; clc 

x = linspace(0,1,1e6);
epsVals = [0.01 0.05 0.1];

figure(1)
grid on; hold on;
for i = 1 : 3 
    eps = epsVals(i);
    y = boundLayer(eps,x);
    plot(x,y)
end

legend('$\epsilon = 0.01$', '$\epsilon = 0.05$', '$\epsilon = 0.1$', 'interpreter','latex','fontsize',14)
xlabel('x');
ylabel('y');
title('Solution Based off Different $\epsilon$ values', 'interpreter','latex');





function [y] = boundLayer(eps, x)
    num = exp(-x / eps) - exp(-x);
    den = exp(-1 / eps) - exp(-1); 
    y = num / den;
end