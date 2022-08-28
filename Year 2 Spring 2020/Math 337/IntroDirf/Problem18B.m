clear				% Clear previous definitions
figure(102)           % Assign figure number
clf                 % Clear previous figures
hold off            % Start with fresh graph

xx = linspace(-10,10,100); 
yy = xx - 4.1;

xx1 = linspace(-10,-3.01,100);
yy1 = (2.1*xx1)./ (xx1.^2 + xx1 - 6) ;

xx2 = linspace(-2.99,1.99,100);
yy2 = (2.1*xx2)./ (xx2.^2 + xx2 - 6) ;

xx3 = linspace(2.01,10,100);
yy3 = (2.1*xx3)./ (xx3.^2 + xx3 - 6) ;


plot(xx,yy,'b-','LineWidth',1.5); 
hold on
plot(xx1,yy1,'r-','LineWidth',1.5);
plot(xx2,yy2,'r-','LineWidth',1.5);
plot(xx3,yy3,'r-','LineWidth',1.5);
plot([-3 -3],[-10 10],'r:','LineWidth',1.5);  % vertical asymp
plot([2 2],[-10 10],'r:','LineWidth',1.5);  % vertical asymp
plot([-10 10],[0 0],'r:','LineWidth',1.5);  % horizontal asymp

plot([-3.177095 1.686805 4.5902896],[-7.277095 -2.413195 .49028963],'o','color',[0 0.5 0],...
    'MarkerSize',7); 
grid;   
text(4,-0.5,'Horizontal Asymptote','FontSize',10,'Color','r');
text(-3.5,1.5,'Vertical Asymptote','FontSize',10,'Color','r','Rotation',90);
text(1.5,1.6,'Vertical Asymptote','FontSize',10,'Color','r','Rotation',90);
h = legend('$y = x - 4.1$', '$y = \frac{2.1x}{x^2 + x - 6}$',...
    'Location','northeast');
set(h,'Interpreter','latex')
xlim([-10,10]);
ylim([-10,10]);

fontlabs = 'Times New Roman';  
xlabel('$x$','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex');  
ylabel('$y$','FontSize',16,'FontName',fontlabs, ...
    'interpreter','latex'); 
mytitle = 'Problem 18B';
title(mytitle,'FontSize',16,'FontName', ...
    'Times New Roman','interpreter','latex'); 
set(gca,'FontSize',16);        

%print -depsc graph1.eps	   % Create EPS file (Figure)
print -djpeg Problem18B.jpg	   