function J = sumsq_nonlin(p,ldata,wdata)
% Function computing sum of square errors for allometric model
model = p(1)*ldata.^p(2);
error = model - wdata;
J = error*error';
end

% Obtain the least sum of square errors
% [p1,J,flag] = fminsearch(@sumsq_allom,[k,a],[],ltdfish,wtdfish);