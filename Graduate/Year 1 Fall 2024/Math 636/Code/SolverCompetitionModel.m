% Solving System of 2 Differential Equations
% dx1/dt = x1(1-x1-ax2), x1(0)=0.9
% dx2/dt = cx2(1-bx1-x2), x2(0)=0.1

global a b c

%parameter values
a = 0.3; %1; 
b = 0.6;
c = 1.9;

%initial conditions
x10 = 0.3; 
x20 = 0.8;

%Final time until which we want to run the program
tf = 20;

%Vector for initial conditions
x0 = [x10; x20];

%Main solver
[t x] = ode45('Deqns2DOdeModel',[0 tf],x0); %you can also use ode23, ode15s

x1 = x(:,1);
x2 = x(:,2);
% 
% figure(1) %solution
%  plot(t,x1,'r')
%  hold on
%  plot(t,x2,'b')
%  xlabel('time')
%  ylabel('population')
%  title('Solution')

figure(2) %phase diagram
plot(x1,x2)
hold
xlabel('x_1')
ylabel('x_2')
title('Phase diagram')
