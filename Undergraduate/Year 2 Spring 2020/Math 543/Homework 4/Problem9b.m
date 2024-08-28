clear		
figure(101)           
clf                
hold off
hold on;
x = (-128:128)'/128;
A = [x.^0, x.^1, x.^2, x.^3];
[Q, R] = qr_mgs(A);

scale = Q (257,:);
Q = Q * diag(1 ./ scale);
%plot(x,Q);

xval = linspace(-1,1,257);
actualYVal0 = 1 + xval -xval;
%plot(xval, actualYVal0,'r:');

actualYVal1 = xval;
%plot(xval, actualYVal1,'b:');

actualYVal2 = (3/2)*(xval .^ 2) - (1/2);
%plot(xval, actualYVal2,'y:');

actualYVal3 = (5/2) * xval .^ 3 - (3/2)*xval;
%plot(xval, actualYVal3,'g:');

error0 = Q(:,1) - actualYVal0';
error1 = Q(:,2) - actualYVal1';
error2 = Q(:,3) - actualYVal2';
error3 = Q(:,4) - actualYVal3';

plot(xval,error0,'r');
plot(xval,error1,'b--');
plot(xval,error2,'y');
plot(xval,error3,'m');

grid on
title('Error Graph between Legendre polynomials');
xlabel('x');
ylabel('Error');
legend({'k = 0', 'k = 1', 'k = 2', 'k = 3'});


