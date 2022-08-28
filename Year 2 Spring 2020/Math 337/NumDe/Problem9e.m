clear
figure(1)
clf
hold off

[YIE] = ImprovedEulers(@Problem9eFunction,0,100,.5,0);
tvals = YIE(:,1);
yvals = YIE(:,3);

plot(tvals, yvals);
grid on;
xlim([0,100]);
ylim([0,20]);
xticks(0:10:100);
yticks(0:2:20);
xlabel('t');
ylabel('Amount of Drug ($\mu$g)','interpreter','latex');
title('Numerical Solution')