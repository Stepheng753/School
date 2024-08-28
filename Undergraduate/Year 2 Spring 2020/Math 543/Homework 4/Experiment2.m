clear		
figure(101)           
clf                
hold off

[U, Y] = qr(randn(80));
[V, X] = qr(randn(80));
S = diag(2 .^ (-1:-1:-80));
A = U*S*V;

[QC, RC] = qr_cgs(A);
[QM, RM] = qr_mgs(A);

for j = 1 : 80
    rcVals = log10(RC(j,j));
    plot(j,rcVals,'ro');
    hold on

    rmVals = log10(RM(j,j));
    plot(j, rmVals,'bs');
end

plot([0,85], [-8,-8], 'r--');
plot([0,85], [-18,-18], 'b--');
grid on;
xlim([0,85]);
ylim([-20,0]);
xlabel('j');
ylabel('$log_{10}(r_{jj})$','fontsize', 16,'interpreter','latex')
title('Classic v. Modified Gram-Schmidt');
legend({'Classical Gram-Schmidt', 'Modified Gram-Schmidt'},'location','northeast')
xticks(0:10:85);


