% Data Fitting: Viral Dynamics model

clear all

global a b c d 
global S0 P0 I0 R0
global tData IData
    
exp_data = load('DataH1N1.dat');

tData = exp_data(:,1);
IData = exp_data(:,2).*18234;
 
plot(tData,IData,'.','MarkerSize',30)
hold on

% % ---- Fixed model parameters and initial condition -----
S0 = 18223;
P0 = 0;
I0 = 11;
R0 = 0;

d = 1/6;

% 
% % % % ----- Estimated model parameters -----
 a_ini = 5.45e-6;
 b_ini = 0.2;
 c_ini = 3.74e-7;

 initial_params = [a_ini b_ini c_ini];
% 
% % %%===== minimising error ====== 
params = fminsearch(@SSR, initial_params); %alternate check fmincon

% % % final solution of system with estimated parameters
% % %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
a = params(1); 
b = params(2);
c = params(3); 

% 
z0 = [S0 P0 I0 R0];
% 
[t z] = ode45('Deqns', [0 40], z0');

S = z(:,1);
P = z(:,2);
I = z(:,3);
R = z(:,4);

% % %=========PLOTTTING
% 
plot(t, I,'k','LineWidth',4)
% axis square
axis([0 40 0 1000])
xlabel('Days')
ylabel('Number of infected individuals')
set(gca,'fontsize',20)
legend('Data','Model')
a
b
c
