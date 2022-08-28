clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

xx = linspace(-10,10,100); % x points of evaluation
yy = 6 - 0.5*xx - 0.1*xx.^2;   % quadratic function 
xx1 = linspace(-10,-2.01,100); % x points of evaluation
yy1 = 4./(2 + xx1);   % rational function
xx2 = linspace(-1.99,10,100); % x points of evaluation
yy2 = 4./(2 + xx2);   % rational function

plot(xx,yy,'b-','LineWidth',1.5);  % plot the quadratic
hold on
plot(xx1,yy1,'r-','LineWidth',1.5);  % plot the rational fcn
plot(xx2,yy2,'r-','LineWidth',1.5);  % plot the rational fcn
plot([-2 -2],[-10 10],'r:','LineWidth',1.5);  % vertical asymp
plot([-10 10],[0 0],'r:','LineWidth',1.5);  % horizontal asymp
plot([-1.385 5.295],[6.500 0.548],'o','color',[0 0.5 0],'MarkerSize',7);  % intersection points
grid;      % provide gridlines
text(-0.5,-0.5,'Horizontal Asymptote','FontSize',10,'Color','r');
text(-2.5,-2.5,'Vertical Asymptote','FontSize',10,'Color','r','Rotation',90);
h = legend('$y = 6 - 0.5x - 0.1x^2$', '$y = \frac{4}{x+2}$','Location','northeast');
set(h,'Interpreter','latex')
xlim([-10,10]);
ylim([-10,10]);
% Set up fonts and labels for the Graph
fontlabs = 'Times New Roman';  
xlabel('$x$','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex');  
ylabel('$y$','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex'); 
mytitle = 'Basic Plot';
title(mytitle,'FontSize',16,'FontName', ...
    'Times New Roman','interpreter','latex'); 
set(gca,'FontSize',16);        

%print -depsc graph1.eps	   % Create EPS file (Figure)
print -djpeg graph1.jpg	   % Create EPS file (Figure)