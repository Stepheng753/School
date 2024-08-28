clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

t = linspace(0,12,100); 
A = -(500*exp(-(14*t)/25))/23 + (500*exp(-(33*t)/100))/23;
plot(t,A,'r');

grid on
hold on

plot(2.299322301, 4.180705651, 'ko');

xticks(0:1:12);
xlabel('Time (yr)');
ylabel('Weighted Activity (hr/day)');
title('Lead Exposure');
legend({'A(t)'},'Location','northeast')