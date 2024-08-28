clear
figure(1)
clf
hold off

[YIE] = ImprovedEulers(@Problem8fFunction,0,5,.5,400);

%Actual
tvals = linspace(0,5,1e4);
yvals = 400*exp(-tvals.*(-79 + 18*tvals)/50);

%Eulers
hvals = YIE(:,1);
evals = YIE(:,2);

%Improved Eulers
iEvals = YIE(:,3);

%Eulers Plot
subplot(1,2,1)

plot(tvals,yvals,'b');
hold on;
grid on;
plot(hvals, evals,'r');

title('Eulers (h = .2)')
xlim([0,5]);
ylim([0,2500]);
xticks(0:.5:5);
yticks(0:250:2500);
xlabel('t');
ylabel('y(t)')
legend({'Actual y(t)', 'Eulers'}, 'Location', 'northwest');

%Improved Plot
subplot(1,2,2)

plot(tvals,yvals,'b');
hold on;
grid on;
plot(hvals, iEvals,'r');

title('Improved Eulers (h = .2)')
xlim([0,5]);
ylim([0,2500]);
xticks(0:.5:5);
yticks(0:250:2500);
xlabel('t');
ylabel('y(t)')
legend({'Actual y(t)', 'Improved Eulers'}, 'Location', 'northwest');