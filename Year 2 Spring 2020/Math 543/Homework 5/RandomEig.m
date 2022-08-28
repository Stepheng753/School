clear		
figure(101)           
clf                
hold off

subplot(2,2,1);
hold on
grid on
xlim([-1.75,1.75]);
ylim([-1.75,1.75]);
xticks(-1.75:.25:1.75);
yticks(-1.75:.25:1.75);
xlabel('Re{ EigenValues }')
ylabel('Im{ EigenValues }')
title('Eigenvalues of Random 8 x 8 Matrix')
for i = 1: 100
    m = 8;
    
    A = randn(m,m) ./ sqrt(m);
    eigVals = eig(A);

    plot(eigVals,'x');
end

subplot(2,2,2);
hold on
grid on
xlim([-1.75,1.75]);
ylim([-1.75,1.75]);
xticks(-1.75:.25:1.75);
yticks(-1.75:.25:1.75);
xlabel('Re{ EigenValues }')
ylabel('Im{ EigenValues }')
title('Eigenvalues of Random 16 x 16 Matrix')
for i = 1: 100
    m = 16;
    
    A = randn(m,m) ./ sqrt(m);
    eigVals = eig(A);

    plot(eigVals,'x');
end


subplot(2,2,3);
hold on
grid on
xlim([-1.75,1.75]);
ylim([-1.75,1.75]);
xticks(-1.75:.25:1.75);
yticks(-1.75:.25:1.75);
xlabel('Re{ EigenValues }')
ylabel('Im{ EigenValues }')
title('Eigenvalues of Random 32 x 32 Matrix')
for i = 1: 100
    m = 32;
    
    A = randn(m,m) ./ sqrt(m);
    eigVals = eig(A);

    plot(eigVals,'x');
end


subplot(2,2,4);
hold on
grid on
xlim([-1.75,1.75]);
ylim([-1.75,1.75]);
xticks(-1.75:.25:1.75);
yticks(-1.75:.25:1.75);
xlabel('Re{ EigenValues }')
ylabel('Im{ EigenValues }')
title('Eigenvalues of Random 64 x 64 Matrix')
for i = 1: 100
    m = 64;
    
    A = randn(m,m) ./ sqrt(m);
    eigVals = eig(A);

    plot(eigVals,'x');
end






