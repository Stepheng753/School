clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

t = linspace(0,12,100);
w = 83 - (399*exp(-(33*t)/500))/5;
plot(t,w,'r');

grid on
hold on

xticks(0:1:12);
xlabel('Time (yr)');
ylab = ylabel('Weight of Boy (kg)');
title('Weight of Boy');
legend({'w(t)'},'Location','northwest')