clear
figure(1)
clf
hold off

[YIE] = ImprovedEulers(@Problem10eFunction,0,200,.5,0);

tvals = YIE(:,1);
yvals = YIE(:,3);

plot(tvals,yvals);
grid on;
xlabel('t (hours)');
ylabel('c(t) ($m^3$)','interpreter','latex');
title('Improved Euler''s of Concentration');
