

x = linspace(-5,5,1e6);
y = (-x.^2)/2;

figure(), plot(x,y,'r')
xlim([-5,5]); ylim([-15,2]);
grid on; hold on;
plot(0,0,'bo')


x = linspace(-5,5,1e6);
y = (-x.^2)/2 + (x.^4)/24;

figure(), plot(x,y,'r')
xlim([-5,5]); ylim([-2,15]);
grid on; hold on;
plot(0,0,'bo')

x = [-sqrt(6), sqrt(6)];
y = (-x.^2)/2 + (x.^4)/24;
plot(x,y,'bo')

