close all; clc; clear;
figure();hold on; grid on;

nf = 20;
x = linspace(0,2,2000);
t = [0,1,2,5,10,20];

for i = 1 : size(t, 2)
    sineSeries = fSine(nf, x, t(i));
    subplot(3,2,i), plot(sineSeries(1,:), sineSeries(2,:));
    xlabel('$x$','interpreter','latex'); 
    ylabel('$y$', 'interpreter','latex');
    titleStr = "Fourier Sine Series for t = " + t(i);
    title(titleStr);
end

print -depsc Prob6b.eps

function f = fSine(nf, x, t)  
    b = zeros(1,nf); 
    f = 0;
    for n = 1 : nf
        npi = n * pi;
        b(n) = (-4 * ( (-1)^n - 1 )) / (npi * sqrt(0.01 + (npi / 4)^4));
        fn = b(n)*exp(-0.05*t)*sinh((t/2) * sqrt(0.01 + (npi / 4)^4)) * sin( (npi * x) / 2);     
        f=f+fn; 
    end
    f = [x; f];
end