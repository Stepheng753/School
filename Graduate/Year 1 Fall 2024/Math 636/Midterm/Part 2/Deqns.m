% Differential Equations of time-vaying infectivity

function zdot = Deqns(t,z)

global a b rw rm
global W0 M0
global tData wData mData

W = z(1);
M = z(2);

zdot = ones(2,1);

zdot(1) = rw * W * (1 - W - a * M)
zdot(2) = rm * M * (1 - M - b * W)