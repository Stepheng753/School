clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

xx = linspace(-10,10,100); % x points of evaluation
yy = 14.5+(xx-xx);
yy1 = 14.5 - .3*xx;
yy2 = 15.7 - 1.8*cos(.2618*(xx+3));


f = @(k) 14.5+6.1*exp(-k)-18.3;    % Function for finding heat coefficient
k = fzero(f,0.3);            % Find the heat coefficient
ft = @(t) 14.5+6.1*exp(-k*t)-38.4; % Function for finding the time of death
td = fzero(ft,-5);           % Find the time of death

[t1,y1] = ode23(@murder,[0,td],20.6); % Simulate the heat equation
[t2,y2] = ode23(@murder,[0,12],20.6); % Simulate the heat equation

plot(t1,y1,'m-','LineWidth',1.5);  % Plot from death to t = 0
hold on                            % Plots Multiple graphs
plot(t2,y2,'m-','LineWidth',1.5);  % Plot from t = 0 to 12
plot([-9,td],[38.4,38.4],'k-','LineWidth',1.5);  % Plot from t = -9 to td
plot([td,td],[10,40],'k:','LineWidth',1.5);   % Plot time of murder
plot(xx,yy,'b-','LineWidth',1.5);  % plot the quadratic
plot(xx,yy1,'r-','LineWidth',1.5);  % plot the rational fcn
plot(xx,yy2,'k-','LineWidth',1.5);  % plot the rational fcn
text(-3.15,20,'Time of death, $t_d$, = 4:06:52 am','rot',90,'FontSize',14,...
    'FontName','Times New Roman','interpreter','latex');
text(-6.5,17.5,'Room Temperature','rot',-3,'FontSize',14,...
    'FontName','Times New Roman','interpreter','latex');
text(0,21,'(7am, 20.6)','FontSize',14,...
    'FontName','Times New Roman','interpreter','latex');
text(1,19,'(8am, 18.3)','FontSize',14,...
    'FontName','Times New Roman','interpreter','latex');
grid;      % provide gridlines
%h = legend('$T_{e1} = 14.5$', '$T_{e2} = 14.5 = .3x$', '$T_{e3} = 15.7 - 1.8\cos{(.2618(x+3))}$',...
    %'Location','northeast');
%set(h,'Interpreter','latex')
xlim([-7,2]);
xticklabels({'12am' '1am' '2am' '3am' '4am' '5am' '6am' '7am' '8am' '9am'})
ylim([10,40]);
% Set up fonts and labels for the Graph
fontlabs = 'Times New Roman';  
xlabel('Midnight to 9:00AM','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex');  
ylabel('Environment Temp ($^{\circ}$C)','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex'); 
mytitle = 'Dead Kitty';
title(mytitle,'FontSize',16,'FontName', ...
    'Times New Roman','interpreter','latex'); 
set(gca,'FontSize',16);        

%print -depsc graph1.eps	   % Create EPS file (Figure)
print -djpeg Problem19.jpg	   % Create EPS file (Figure)