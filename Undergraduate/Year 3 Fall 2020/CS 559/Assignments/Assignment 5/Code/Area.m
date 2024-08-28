function A = Area(ChainCode) 

    xarr = zeros(length(ChainCode) + 1);
    yarr = zeros(length(ChainCode) + 1); 
    
    % convert ChainCode into polyline
    x = 0; y = 0;
    pointIndex = 2;
    for i = 1 : length(ChainCode)
        if (ChainCode(i) == 1), y = y + 1;
        elseif (ChainCode(i) == 2), x = x - 1;
        elseif (ChainCode(i) == 3), y = y - 1;
        elseif (ChainCode(i) == 0), x = x + 1; 
        end
        xarr(pointIndex) = x;
        yarr(pointIndex) = y;
        pointIndex = pointIndex + 1;
    end
    
    % Shoelace Formula
    sum = 0;
    for i = 1 : length(ChainCode)
        sum = sum + ((xarr(i + 1) * yarr(i)) - (xarr(i) * yarr(i + 1)));
    end
    A = abs(sum) / 2;  

end
