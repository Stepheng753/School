% Data Fitting: Viral Dynamics model

clear all

global a b rw rm
global W0 M0
global tData wData mData
    
exp_data = load('AbundanceWM.dat');

tData = exp_data(:,1);
wData = exp_data(:,2);
mData = exp_data(:,3);
 
figure();
hold on;
grid on;

plot(tData, wData, 'r.', 'MarkerSize', 20);
plot(tData, mData, 'b.', 'MarkerSize', 20);

W0 = 0.9;
M0 = 0.1;

a_ini = 0;
b_ini = 0;
rw_ini = 0;
rm_ini = 0;

initial_params = [a_ini b_ini rw_ini rm_ini];

params = fminsearch(@SSR, initial_params); 

a = params(1); 
b = params(2);
rw = params(3); 
rm = params(4);
 
z0 = [W0, M0];
[t z] = ode45('Deqns', [0 40], z0');

W = z(:,1);
M = z(:,2);

plot(t, W, 'r', 'LineWidth', 2);
plot(t, M, 'b', 'LineWidth', 2);
axis([0 35 0 1]);
xlabel('Days');
ylabel('Abundance');
title('Abundance of W and M')
set(gca,'fontsize',10);
legend('DataW', 'DataM','W', 'M');
fprintf('a = %0.12f\n\n', a);
fprintf('b = %0.12f\n\n', b);
fprintf('rw = %0.12f\n\n', rw);
fprintf('rm = %0.12f\n\n', rm);