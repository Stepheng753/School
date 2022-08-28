function z = Problem9eFunction(t,y)

r = 3;
q = .15;
k = -log(1/2)/21;
z = r*exp(-q*t) - k*y; 