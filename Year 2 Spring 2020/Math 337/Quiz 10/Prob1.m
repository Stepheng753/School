clear
figure(1)
clf
hold off

grid on
hold on

t = linspace(0,3,100);
plot(t, t.^2 + 1);

t = linspace(3,10,1000);
plot(t,t-t);
plot(3,0,'o');

ylim([-1 10]);
xlabel('t');
ylabel('f(t)');
title('Problem 1')