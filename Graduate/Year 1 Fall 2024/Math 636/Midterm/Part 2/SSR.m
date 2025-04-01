function SSR_value = SSR(params)

global a b rw rm
global W0 M0
global tData wData mData

a = params(1); 
b = params(2);
rw = params(3); 
rm = params(4);

z0 = [W0 M0];

[t,z] = ode45(@(t,z) Deqns(t,z), tData, z0');

W = z(:,1);
M = z(:,2);

SSR_value = sum((W - wData).^2) + sum((M - mData).^2);
