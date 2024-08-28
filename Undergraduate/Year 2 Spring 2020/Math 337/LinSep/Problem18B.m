clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

length = [0.55, 0.62, 0.71, 0.77, 0.86, 0.92, 1.01, 1.09, 1.14, 1.21];
weight = [3, 6, 7, 10, 14, 15, 21, 26, 34, 39];
plot(length(1,:),weight(1,:),'ro');

grid on
hold on

L = linspace(0,1.3,100);
W = 21.2319 * L.^3.0589;
plot(L,W,'b');

maxWeight = 37.50385478 + L - L;
plot(L,maxWeight,'k')

xlim([0,1.3])
xticks(0:.1:1.3)
yticks(0:5:50)

xlabel('Length (m)')
ylabel('Weight (kg)')
title('Allometric Model v Data') 
legend({' Albacore Data',' Allometric Model',' Max Weight = 37.50385478'}, 'Location', 'northwest');