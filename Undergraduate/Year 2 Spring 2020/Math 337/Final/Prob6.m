clear
figure(1)
clf
hold off

grid on
hold on

x = linspace(-5,20,1000);
dx = ((6.5 * x.^2)./(22 + x.^2)) - 0.5*x;

plot(x,dx);
plot(x,0*x,'k');
plot([0,0],[-6,6],'k');

plot(0,0,'ro','markerfacecolor','r');
plot(2,0,'ro');
plot(11,0,'ro','markerfacecolor','r');

x = [0.2 0.25];
y = [0.517 0.517];   
annotation('arrow',x,y,'Linewidth',1,'color','red')

x = [0.335 0.31];
y = [0.517 0.517];   
annotation('arrow',x,y,'Linewidth',1,'color','red')

x = [0.36 0.4];
y = [0.517 0.517];   
annotation('arrow',x,y,'Linewidth',1,'color','red')

x = [0.36 0.6];
y = [0.517 0.517];   
annotation('arrow',x,y,'Linewidth',1,'color','red')

x = [0.8 0.65];
y = [0.517 0.517];   
annotation('arrow',x,y,'Linewidth',1,'color','red')

xticks(-5:1:20);
yticks(-6:1:6);
xlabel('x');
ylabel('dx/dt')
