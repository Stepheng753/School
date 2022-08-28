clear		
figure(101)           
clf                
hold off

n = 500;
m = 1;
under2 = 0;
under4 = 0;
under8 = 0;

hold on
grid on
xlim([0,n]);
ylim([-10,2]);
xlabel('Iterator of Random Matrices')
ylabel('$log_2$(Min Singular Vals)','interpreter','latex')
titleString = sprintf('Min Singular Values of Random %.0f x %.0f Matrices',m,m);
title(titleString);
for i = 1 : n
    A = randn(m,m) ./ sqrt(m);
    singleVals = svd(A);
    sMin = min(singleVals);
    logSMin = log2(sMin);
    plot(i,logSMin,'o');
    
    if sMin < 2 ^ -1
        under2 = under2 + 1;
    end
    
    if sMin < 4 ^ -1 
        under4 = under4 + 1;
    end
    
    if sMin < 8 ^ -1
        under8 = under8 + 1;
    end 
        
end

for i = -9 : -1
    plot([0,n],[i,i],'--');
    sMinVal = 2 ^ abs(i);
    text(400,i+.2,sprintf('$\\bf \\delta_{min} = %.0f^{-1}$', sMinVal),'interpreter','latex');
end

