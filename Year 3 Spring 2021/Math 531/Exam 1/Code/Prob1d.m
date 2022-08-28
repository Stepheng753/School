close all; clc; clear;
figure();hold on; grid on;
options = optimset('Display','off');

lenArrays = 2000;
numEigen = 50;
L = 4; h = 2;

roots = zeros(numEigen,1);
for i = 1 : numEigen 
    % x = sqrt(lambda)
    roots(i) = fsolve(@(x) ((h*sin(L*x)) + (x*cos(L*x))) , (i*pi/4), options );
end
eigenVals = roots.^2;
eigIndices = [1,2,5,10,25,50];
for i = 1 : size(eigIndices,2)
    fprintf('Lambda %.0f: %.4f\n',eigIndices(i), eigenVals(eigIndices(i)))
end

subplot(3,1,1); hold on; grid on;
x = linspace(0,1.99999,2000); g = 5+(x-x);
plot(x,g,'r-');
x = linspace(2,3.99999,2000); g = 0+(x-x);
plot(x,g,'r-');
title('Original Function'); ylim([-0.5,5.5]);

subplot(3,1,2); hold on; grid on;
x = linspace(0,L,lenArrays);
sineSeries = fSine(numEigen, x, roots);
plot(sineSeries(1,:), sineSeries(2,:));
title('Sine Series');

subplot(3,1,3); hold on; grid on;
x = linspace(-4,8,lenArrays);
sineSeriesExtended = fSine(numEigen, x, roots);
plot(sineSeriesExtended(1,:), sineSeriesExtended(2,:));
title('Sine Series');

absError = sineSeries;
for i = 1 : size(absError, 2)
    if (absError(1,i) < 2), absError(2,i) = absError(2,i) - 5;
    end
end
[maxError,I] = max(absError(2,:));
fprintf('Max Error at x = %.4f and error of %.04f\n', absError(1,I), maxError);

absErrorVals = [0.05,1,2.5,3.75];
absErrorIndices = (absErrorVals / (L / lenArrays)) + 1;
for i = 1 : size(absErrorVals,2)
    if (absErrorVals(i) < 2), g = 5;
    else, g = 0;
    end
    fprintf('Abs Error at x = %.2f: %.4f\n',absErrorVals(i), abs(sineSeries(2, absErrorIndices(i)) - g));
end

print -depsc Prob1d.eps

function f = fSine(nf, x, roots)  
    b = zeros(1,nf); 
    f = 0;
    for n = 1 : nf
        b(n) = ((-5*roots(n)) / 2) * ( cos(2*roots(n)) - 1);
        fn = b(n)*sin( roots(n) * x);     
        f=f+fn; 
    end
    f = [x; f];
end
