close all; clc; clear;
figure();hold on; grid on;

x = linspace(-4,4,2000);   
g = x.^2;
plot(x,g,'r-','LineWidth',1.5)

numTerms = [3,5,10,20];
x = linspace(-6,6,2000);
for i = 1 : size(numTerms,2)
    plot(x,diffFTerms(numTerms(i), x),'LineWidth',1.5); 
end 

xlabel('$x$','FontSize',16,'interpreter','latex'); 
ylabel('$y$','FontSize',16, 'interpreter','latex');
title('Fourier Cosine Series for $x^2$','FontSize',16, 'interpreter','latex');
legend('$f(x) = x^2$','nT=3', 'nT=5', 'nT=10', 'nT=20', 'interpreter','latex', 'location', 'north' );
xlim([-6,6]);
ylim([-2,18]);

print -depsc Prob1Cosine.eps

function f = diffFTerms(Nf, x) 
    a0 = 3;
    a = zeros(1,Nf); 
    f = a0;
    for n = 1 : Nf     
        npi = n * pi;
        a(n) = (36 / (npi^2))*cos(npi);   
        fn = a(n)*cos((npi*x)/3);     
        f=f+fn; 
    end
end
