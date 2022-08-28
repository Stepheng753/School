function [YE] = EulersMethod(func, t0, tf, h, y0)

t = t0:h:tf;
y = zeros(1, tf - t0 + 1);
y(1) = y0;

for i = 1 : length(t) - 1
    F1 = feval( func, t(i), y(i) );
    y(i+1) = y(i) + h*( F1 );
end

YE(:,1) = t';
YE(:,2) = y';