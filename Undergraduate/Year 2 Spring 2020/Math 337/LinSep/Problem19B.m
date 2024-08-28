clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

t = linspace(0,12,100);
P = -(1000000*exp(-(33*t)/100))/33 + (125000*exp(-(14*t)/25))/7 + 2875000/231;
plot(t,P,'r');

grid on
hold on

xticks(0:1:12);
yticks(0:1000:12000)
xlabel('Time (yr)');
ylab = ylabel('Accumalation of Lead (\mu g)');
title('Accumalation of Lead');
legend({'P(t)'},'Location','northwest')