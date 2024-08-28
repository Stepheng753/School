clear
figure(1)
clf
hold off

[YIE] = ImprovedEulers(@Problem8cFunction,0,3,.1,1);
[YIE2] = ImprovedEulers(@Problem8cFunction,0,3,.05,1);

%Actual
tvals = linspace(0,2.999,1e4);
yvals = -3*(tvals - 3).^-1;

%Eulers
hvals = YIE(:,1);
evals = YIE(:,2);

%Improved Eulers
iEvals = YIE(:,3);

%Eulers Plot
subplot(2,2,1)

plot(tvals,yvals,'b');
hold on;
grid on;
plot(hvals, evals,'r');

title('Eulers (h = .1)')
xlim([0,3]);
ylim([0,10]);
xticks(0:.25:3);
yticks(0:10);
xlabel('t');
ylabel('y(t)')
legend({'Actual y(t)', 'Eulers'}, 'Location', 'northwest');

%Improved Plot
subplot(2,2,2)

plot(tvals,yvals,'b');
hold on;
grid on;
plot(hvals, iEvals,'r');

title('Improved Eulers (h = .1)')
xlim([0,3]);
ylim([0,10]);
xticks(0:.25:3);
yticks(0:10);
xlabel('t');
ylabel('y(t)')
legend({'Actual y(t)', 'Improved Eulers'}, 'Location', 'northwest');


%Eulers
hvals = YIE2(:,1);
evals = YIE2(:,2);

%Improved Eulers
iEvals = YIE2(:,3);

%Euler's Plot
subplot(2,2,3)

plot(tvals,yvals,'b');
hold on;
grid on;
plot(hvals, evals,'r');

title('Eulers (h = .05)')
xlim([0,3]);
ylim([0,10]);
xticks(0:.25:3);
yticks(0:10);
xlabel('t');
ylabel('y(t)')
legend({'Actual y(t)', 'Eulers'}, 'Location', 'northwest');



subplot(2,2,4)

plot(tvals,yvals,'b');
hold on;
grid on;
plot(hvals, iEvals,'r');

title('Improved Eulers (h = .05)')
xlim([0,3]);
ylim([0,10]);
xticks(0:.25:3);
yticks(0:10);
xlabel('t');
ylabel('y(t)')
legend({'Actual y(t)', 'Improved Eulers'}, 'Location', 'northwest');



