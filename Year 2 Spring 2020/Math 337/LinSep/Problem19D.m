clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

t = linspace(0,12,100);
P = -(1000000*exp(-(33*t)/100))/33 + (125000*exp(-(14*t)/25))/7 + 2875000/231;
w = 83 - (399*exp(-(33*t)/500))/5;
c = (0.1*P).*(w).^-1;
plot(t,c,'r');

grid on
hold on

plot(5.783690455, 30.33656218,'ko');

xticks(0:1:12);
ylim([0,35]);
xlabel('Time (yr)');
ylabel('Concentration of Lead (\mu g / dl)');
title('Concentration of Lead over Time');
legend({'c(t)', 'Max Concentration'},'Location','southeast');