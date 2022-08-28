close all; clc; clear;
figure();hold on; grid on;

L = 1;

x = linspace(-4,4,2000);
for i = 1 : 3
    plot(x,diffFTerms(x, L, i),'LineWidth',1.5);
end

x = linspace(-4,0,2000);   
g = x;
plot(x,g,'r-','LineWidth',1.5)
plot(0,0,'ro')
x = linspace(0,4,2000); 
g = 1+x;
plot(x,g,'r-','LineWidth',1.5)
plot(0,1,'ro')

xlabel('$x$','FontSize',16,'interpreter','latex'); 
ylabel('$y$','FontSize',16, 'interpreter','latex');
title('Fourier Series for $f(x)$','FontSize',16, 'interpreter','latex');
legend('cosine', 'sine', 'full series', '$f(x)$', 'interpreter','latex', 'location', 'north' );

print -depsc Prob2.eps


function f = diffFTerms(x, L, num)
    Nf = 1000;
    a0 = (1/2);
    a = zeros(1,Nf);
    b = zeros(1,Nf);
    if (num == 2), f = 0;
    else, f = a0; 
    end
    for n = 1 : Nf     
        npi = n * pi;
        a(n) = 0; 
        b(n) = (-(1 + (2*L))*((-1)^n)) / (npi);
        if (num == 1), fn = a(n)*cos((npi*x)/L); 
        elseif (num == 2), fn = b(n)*sin((npi*x)/L);
        elseif (num == 3), fn = a(n)*cos((npi*x)/L) + b(n)*sin((npi*x)/L);
        end 
        f=f+fn; 
    end
end
