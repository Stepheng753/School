function SSR_value = SSR(params)
global a b c d 
global S0 P0 I0 R0
global tData IData

a = params(1); 
b = params(2);
c = params(3); 

z0 = [S0 P0 I0 R0];

[t,z] = ode45(@(t,z) Deqns(t,z), tData, z0');

S = z(:,1);
P = z(:,2);
I = z(:,3);
R = z(:,4);

SSR_value = sum((I - IData).^2);
