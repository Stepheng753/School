clear		
figure(101)           
clf                
hold off

x = (-128:128)'/128;
A = [x.^0, x.^1, x.^2, x.^3];
[Q, R] = qr_mgs(A);

scale = Q (257,:);
Q = Q * diag(1 ./ scale);
plot(x,Q);

grid on
ylim([-1.2,1.2]);
title('Approximate Legendre Polynomials')
xlabel('x');
ylabel('y');
legend({'k = 0', 'k = 1', 'k = 2', 'k = 3'},'location','southeast');