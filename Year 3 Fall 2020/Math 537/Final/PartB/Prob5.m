

time = linspace(0,1,1e6);
w1 = 1; w2 = 4;
x1 = cos(2*pi*time*w1);
x2 = cos(2*pi*time*w2);

figure(), 
plot(x1,x2); grid on;
title('Periodic')
