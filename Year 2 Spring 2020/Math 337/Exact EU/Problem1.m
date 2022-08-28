[x,y] = meshgrid(-10:1:10, -10:1:10);
F = (-1/2)*(x.^2) + (1/2)*(y.^2);
xticks(-10:2:10);
yticks(-10:2:10);

figure(1);
surf(x,y,F);
colorbar;
colormap(spring);
zticks(-50:10:50);
xlabel('x');
ylabel('y');
zlabel('z');

figure(2);
contour(x,y,F,'ShowText','on');
grid on;
xlabel('x');
ylabel('y');