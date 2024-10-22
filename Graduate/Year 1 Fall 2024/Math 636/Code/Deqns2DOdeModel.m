function dx = Deqns2OdeModel(t,x)
global a b c

x1 = x(1);
x2 = x(2);

dx = zeros(2,1);

dx(1) = x1*(1-x1-a*x2);
dx(2) = c*x2*(1-b*x1-x2);
