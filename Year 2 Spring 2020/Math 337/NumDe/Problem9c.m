clear
figure(1)
clf
hold off

tvals = linspace(0,100,1e4);
A1Vals = 20*exp(log(1/2).*(-tvals)/-21);
A2Vals = ( 1260*exp(-(3.*tvals)/20) / (-63 + 20*log(2)) ) - ( (1260*2.^(-tvals/21)) / (-63 + 20*log(2)) );

hold all
grid on
plot(tvals,A1Vals);
plot(tvals,A2Vals);
xlim([0,100]);
ylim([0,20]);
xticks(0:10:100);
yticks(0:2:20);
xlabel('t (days)');
ylabel('Amount of Drug ($\mu$g)','interpreter','latex');
title('Actual Solution');
legend('$\frac{dA}{dt} = -kA$','$\frac{dA}{dt} = re^{-qt} -kA$','interpreter','latex');
