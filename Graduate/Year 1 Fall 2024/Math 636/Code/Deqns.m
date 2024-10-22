% Differential Equations of time-vaying infectivity

function zdot = Deqns(t,z)

global a b c d 
global S0 P0 I0 R0
global tData IData

S = z(1);
P = z(2);
I = z(3);
R = z(3);

zdot = ones(4,1);

zdot(1) = -a*S*I - b*S;
zdot(2) = b*S - c*P*I;
zdot(3) = a*S*I + c*P*I - d*I;
zdot(4) = d*I;      