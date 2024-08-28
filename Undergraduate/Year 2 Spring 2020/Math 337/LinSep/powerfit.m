function [k,a] = powerfit(ldata,wdata)
 % Power law fit for model W = k*L^a
 % Uses linear least squares fit to logarithms of data
 Y = log(wdata);      % Logarithm of W-data
 X = log(ldata);      % Logarithm of L-data
 p = polyfit(X,Y,1);  % Linear fit to X and Y
 a = p(1);            % Value of exponent
 k = exp(p(2));       % Value of leading coefficient
end

