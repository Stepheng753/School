function [YIE] = ImprovedEulers(func, t0, tf, h, y0)

t = t0:h:tf;
y = zeros(1, tf - t0 + 1);
y(1) = y0;

for i = 1 : length(t) - 1
    F1 = feval( func, t(i), y(i) );
    F2 = feval( func, t(i+1), y(i) + h*F1);
    y(i+1) = (y(i) + (h/2)*(F1 + F2));
end

YE = EulersMethod(func, t0, tf, h, y0);

YIE(:,1) = t';
YIE(:,2) = YE(:,2);
YIE(:,3) = y';
