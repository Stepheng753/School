clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

xx = linspace(-10,10,100); % x points of evaluation
yy = 14.5+(xx-xx);
yy1 = 14.5 - .3*xx;
yy2 = 15.7 - 1.8*cos(.2618*(xx+3));


plot(xx,yy,'b-','LineWidth',1.5);  % plot the quadratic
hold on
plot(xx,yy1,'r-','LineWidth',1.5);  % plot the rational fcn
plot(xx,yy2,'k-','LineWidth',1.5);  % plot the rational fcn

grid;      % provide gridlines
h = legend('$T_{e1} = 14.5$', '$T_{e2} = 14.5 = .3x$', '$T_{e3} = 15.7 - 1.8\cos{(.2618(x+3))}$',...
    'Location','northeast');
set(h,'Interpreter','latex')
xlim([-7,2]);
xticklabels({'12am' '1am' '2am' '3am' '4am' '5am' '6am' '7am' '8am' '9am'})
ylim([10,20]);
% Set up fonts and labels for the Graph
fontlabs = 'Times New Roman';  
xlabel('Midnight to 9:00AM','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex');  
ylabel('Environment Temp ($^{\circ}$C)','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex'); 
mytitle = 'Environment Temp Over Time';
title(mytitle,'FontSize',16,'FontName', ...
    'Times New Roman','interpreter','latex'); 
set(gca,'FontSize',16);        

%print -depsc graph1.eps	   % Create EPS file (Figure)
print -djpeg Problem19Environment.jpg	   % Create EPS file (Figure)