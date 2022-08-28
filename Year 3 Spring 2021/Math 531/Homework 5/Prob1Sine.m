close all; clc; clear;
figure();hold on; grid on;

x = linspace(-4,4,2000);   
g = x.^2;
plot(x,g,'r-','LineWidth',1.5)

numTerms = [3,5,10,20,100];
x = linspace(-6,6,2000);
for i = 1 : size(numTerms,2)
    plot(x,diffFTerms(numTerms(i), x),'LineWidth',1.5); 
end 

xlabel('$x$','FontSize',16,'interpreter','latex'); 
ylabel('$y$','FontSize',16, 'interpreter','latex');
title('Fourier Sine Series for $x^2$','FontSize',16, 'interpreter','latex');
legend('$f(x) = x^2$','nT=3', 'nT=5', 'nT=10', 'nT=20', 'nT=100', 'interpreter','latex', 'location', 'north' );
xlim([-6,6]);
ylim([-12.5,20]);

print -depsc Prob1Sine.eps

function f = diffFTerms(Nf, x)  
    b = zeros(1,Nf); 
    f = 0;
    for n = 1 : Nf     
        npi = n * pi;
        b(n) = ( (-18/npi)*cos(npi) ) + ( (36/(npi^3))*cos(npi) ) + ( 36/(npi^3) );    
        fn = b(n)*sin((npi*x)/3);     
        f=f+fn; 
    end
end


