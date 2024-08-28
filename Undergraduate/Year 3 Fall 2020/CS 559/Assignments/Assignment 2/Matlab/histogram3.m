function [] = histogram3(x) 
    grid on
    hold on
    
    count = zeros(1,412);
    for i = 0 : 255
        counter = 0;
        for j = 1 : 412
            if (x(j) == i )
                counter = counter  + 1;
            end
        end
        count(i+1) = counter;
    end
    
    
    for i = 0 : 255
        plot([i i], [0 count(i+1)], 'b')
    end
    xlim([0, size(x,2) + 10])
    ylim([0 4])
    yticks([0 1 2 3 4])
    yticklabels({'0/255','1/255','2/255', '3/255'})
    xlabel('GrayLevels')
    ylabel('Frequency')
    title('Frequency per GrayLevel')
 
end