clear
figure(1)
clf
hold off

grid on
hold on

plot1(0,4);
plot1(4,8);
plot1(8,12);

ylim([0,3]);

function [] = plot1(a,b)
    c = (a+b)/2;
    t = linspace(a,c,200);
    y1 = t - a;
    plot(t,y1,'b');

    t = linspace(c,b,200);
    y2 = b-t;
    plot(t,y2,'r');
end

