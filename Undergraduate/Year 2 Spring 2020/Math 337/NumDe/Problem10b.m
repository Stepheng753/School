clear
figure(1)
clf
hold off

tvals = linspace(0,48,1e4);
yvals = 50000000007/100000000000000 - ((50000000007*exp(-tvals/170))/100000000000000);

plot(tvals,yvals);
grid on
xlim([0,48]);
xticks(0:4:48);
xlabel('t (hours)');
ylabel('c(t) ($m^3$)','interpreter','latex');
title('Concentration of CO over time');

