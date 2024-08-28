clear		
figure(101)           
clf                
hold off

n = 500;
hold on
grid on
xlim([0,n]);
ylim([-10,2]);
xticks(0:n/20:n);
yticks(-10:1:2);
xlabel('m Vals')
ylabel('$log_2$(Min Singular Vals)','interpreter','latex')
title('Min Singular Values of Random m x m Matrices')
for m = 1 : n
    A = randn(m,m) ./ sqrt(m);
    singleVals = svd(A);
    sMin = min(singleVals);
    logSMin = log2(sMin);
    plot(m,logSMin,'o');
end

for i = -9 : -1
    plot([0,m],[i,i],'--');
    sMinVal = 2 ^ abs(i);
    text(400,i+.2,sprintf('$\\bf \\delta_{min} = %.0f^{-1}$', sMinVal),'interpreter','latex');
end

