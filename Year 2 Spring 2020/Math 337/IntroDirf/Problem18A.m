clear				% Clear previous definitions
figure(101)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

xx = linspace(-10,10,100); 
yy = -2*xx - 3.1;   
yy1 = .9 + 2.6*xx - 2.1*(xx.^2) - (xx.^3);

plot(xx,yy,'b-','LineWidth',1.5); 
hold on
plot(xx,yy1,'r-','LineWidth',1.5);

plot([-3.155957 -.7154866 1.7714438],[3.2119144 -1.669027 -6.642888],'o','color',[0 0.5 0],...
    'MarkerSize',7); 
grid;      
h = legend('$y = -2x- 3.1$', '$y = .9 + 2.6x - 2.1x^2 - x^3$',...
    'Location','northeast');
set(h,'Interpreter','latex')
xlim([-5,5]);
ylim([-10,10]);

fontlabs = 'Times New Roman';  
xlabel('$x$','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex');  
ylabel('$y$','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex'); 
mytitle = 'Problem 18A';
title(mytitle,'FontSize',16,'FontName', ...
    'Times New Roman','interpreter','latex'); 
set(gca,'FontSize',16);        

%print -depsc graph1.eps	   % Create EPS file (Figure)
print -djpeg Problem18A.jpg	   