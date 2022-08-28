clear		
figure(101)           
clf                
hold off

n = 100;
m = 100;
sMinProp = zeros(m,7);

hold on
grid on
xlim([1,m]);
ylim([0,110]);
xticks(0:m/20:m);
xlabel('m Vals')
ylabel('Min Singular Vals Proportion (%)')
title('Min Singular Vals Proportion from 100 m $\times$ m','interpreter','latex');

for i = 1 : m
    under2 = 0;
    under4 = 0;
    under8 = 0;
    under16 = 0;
    under32 = 0;
    under64 = 0;
    
    for j = 1 : n
        A = randn(i,i) ./ sqrt(i);
        singleVals = svd(A);
        sMin = min(singleVals);
        
        if sMin < 2 ^ -1
            under2 = under2 + 1;
        end

        if sMin < 4 ^ -1 
            under4 = under4 + 1;
        end

        if sMin < 8 ^ -1
            under8 = under8 + 1;
        end  
        
        if sMin < 16 ^ -1
            under16 = under16 + 1;
        end

        if sMin < 32 ^ -1 
            under32 = under32 + 1;
        end

        if sMin < 64 ^ -1
            under64 = under64 + 1;
        end
        
    end
    
    sMinProp(i,1) = i;
    sMinProp(i,2) = (under2 / n)*100;
    sMinProp(i,3) = (under4 / n)*100;
    sMinProp(i,4) = (under8 / n)*100;
    sMinProp(i,5) = (under16 / n)*100;
    sMinProp(i,6) = (under32 / n)*100;
    sMinProp(i,7) = (under64 / n)*100;
end

plot(sMinProp(:,1),sMinProp(:,2));
plot(sMinProp(:,1),sMinProp(:,3));
plot(sMinProp(:,1),sMinProp(:,4));
plot(sMinProp(:,1),sMinProp(:,5));
plot(sMinProp(:,1),sMinProp(:,6));
plot(sMinProp(:,1),sMinProp(:,7));

legend = legend({'$\delta_{min} < 2^{-1}$','$\delta_{min} < 4^{-1}$','$\delta_{min} < 8^{-1}$','$\delta_{min} < 16^{-1}$','$\delta_{min} < 32^{-1}$','$\delta_{min} < 64^{-1}$'},'interpreter','latex');
set(legend,'location','southeast');


