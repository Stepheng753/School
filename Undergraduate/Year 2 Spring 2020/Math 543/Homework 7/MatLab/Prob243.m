clear				
figure(101)           
clf                
hold off 

grid on
hold on

I = eye(10);
t = linspace(0,20,100);

for i = 0 : 0
    A = randn(10) - 2*I;

    yvals = zeros(length(t),1);
    yvals1 = zeros(length(t),1);
    specAbsc = max(real(eig(A)));

    for j = 0 : length(t) - 1
        yvals(j + 1) = norm(expm(t(j + 1)*A));
        yvals1(j + 1) = exp(t(j + 1)*specAbsc);
    end

    t = transpose(linspace(0,20,100));
    logYvals = log10(yvals);
    logYvals1 = log10(yvals1);

    plot(t, logYvals,'r');
    plot(t,logYvals1,'b');
end

xticks(0:20);
yticks(-5:1:20);
legend('$||e^{tA}||_2$','$e^{t\alpha (A)}$','interpreter','latex','fontsize',14,'location','best');











