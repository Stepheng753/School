

figure(1)
grid on; hold on;

for i = 0 : 255
    plot([i i], [0 1], 'b')
end
xlim([0, 266])
ylim([0 4])
yticks([0 1 2 3 4])
yticklabels({'0/256','1/256','2/256', '3/256'})
xlabel('GrayLevels')
ylabel('Frequency')
title('Frequency per GrayLevel')


figure(2)
grid on; hold on;

plot([0 0], [0 120])
for i = 120 : 255
    plot([i i], [0 1], 'b')
end
xlim([0, 266])
%ylim([0 4])
%yticks([0 1 2 3 4])
%yticklabels({'0/256','1/256','2/256', '3/256'})
xlabel('GrayLevels')
ylabel('Frequency')
title('Frequency per GrayLevel')



