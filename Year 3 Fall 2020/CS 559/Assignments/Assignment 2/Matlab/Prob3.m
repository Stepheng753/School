
figure(1)
grid on; hold on;

for i = 0 : 99
    plot([i i], [0 2], 'b')
end
for i = 100 : 199
    plot([i i], [0 1], 'r')
end
for i = 200 : 255
    plot([i i], [0 2], 'b')
end

xlim([0, 266])
ylim([0 4])
yticks([0 1 2 3 4])
yticklabels({'0/412','1/412','1/206', '3/412'})
xlabel('GrayLevels')
ylabel('Frequency')
title('Frequency per GrayLevel, h(l)')

figure(2)
grid on; hold on;

for i = 0 : 123
    plot([i i], [0 48], 'b')
end
for i = 133 : 256
    plot([i i], [0 55], 'r')
end
xlim([0 256])
ylim([0 60])
xticks([62 195])
xticklabels({'Black (l = 0)','White (l = 255)'})
yticks(0:5:55)
yticklabels({'0/206', '10/206', '20/206', '30/206', '40/206', '50/206', '60/206', '70/206', '80/206', '90/206', '100/206','110/206'})
xlabel('GrayLevels')
ylabel('Frequency')
title('Frequency per GrayLevel, new output')