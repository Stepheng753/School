clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

age = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
length = [0.4, 0.6, 0.84, 0.97, 1.02, 1.09, 1.13, 1.15, 1.16, 1.17];
plot(age(1,:), length(1,:),'ro');

grid on
hold on

t = linspace(0,15,100);
L = 1.204415785*(1 - exp(-0.384651137 * t));
plot(t,L,'b');

HA = 1.204415785 + t - t;
plot(t,HA,'k');

xticks(0:1:15)
yticks(0:.1:1.4)

xlabel('Age (yr)');
ylabel('Length (m)');
title('Von Bertalanffy Model v Data');
legend({' Albacore Data', ' Von Bertalanffy Model',' HA = 1.204415785'}, 'Location', 'southeast');

