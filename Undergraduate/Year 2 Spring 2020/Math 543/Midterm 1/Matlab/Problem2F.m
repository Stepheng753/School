clear
figure(1)
clf
hold off

grid on
hold on

usCovidData = [1,1,2,2,5,5,5,5,5,7,8,8,11,11,11,11,11,11,11,11,12,12,13,13,13,13,13,13,13,13,15,15,15,51,51,57,58,60,68,74,98,118,149,217,262,402,518,583,959,1281,1663,2179,2727,3499,4632,6421,7783,13677,19100,25489,33276,43847,53740,65778,83836,101657,121478,140886,161807,188172,213372];
usCovidData = transpose(usCovidData);
logUSCovidData = log10(usCovidData);

time = 0 : size(logUSCovidData) - 1;
time = transpose(time);

%Semi-Log Plot
plot(time,logUSCovidData, 'r');

%QR Factorization for Least-Squares Linear Fit
yint = ones(size(time));
A = [yint time];
[Q, R] = qr(A);
x = linsolve(R, Q*logUSCovidData);
yInt = x(1);
slope = x(2);
plot(time, line(yInt,slope,time),'b');

xticks(0:2:70);
yticks(-1:.5:6);
xlabel('Days Since Jan 22.');
ylabel('$\log_{10}$ of Confirmed Cases','interpreter','latex');
title('Confirmed Cases since Jan 22.');
legend({'Actual Data','Linear Fit'},'location','southeast');

extrapData = ones(7,1);
for i = 1:7
    logData = line(yInt,slope,size(time,1) +  i);
    extrapData(i,:) = 10^logData;
end

function y = line(yint,slope,x)
    y = yint + slope*x;
end


