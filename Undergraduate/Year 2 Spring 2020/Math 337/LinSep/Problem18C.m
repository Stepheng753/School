clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

t = linspace(0,20,1000);
W = 21.2319 * (1.204415785*(1 - exp(-0.384651137 * t))).^3.0589;
plot(t,W,'r');

grid on
hold on

dW = 30.08829639 * exp(-0.384651137 * t) .* (1.204415785*(1 - exp(-0.384651137 * t))).^2.0589;
plot(t,dW,'b')

HA = 37.50385478 + t - t;
plot(t,HA,'k');

plot(2.906673779,[11.17272610,6.384930855],'ko')

xlabel('Age (yr)');
title('Weight of Albacore' );
legend({' W(t)(kg)',' W''(t)(kg/yr)',' HA = 37.50385478',' t_p = 2.906673779 '},'Location', 'southeast')