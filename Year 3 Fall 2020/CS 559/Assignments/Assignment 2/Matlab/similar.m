function [] = similar(imgA, imgB)

    imgB = imresize(imgB, [size(imgA,1), size(imgA,2)]);
    diffMat = abs(double(imgA) - double(imgB)) ./ 255;
    
    sum = 0;
    for row = 1 : size(diffMat,1)
        for col = 1 : size(diffMat,2)
            for colr = 1 : 3
                sum = sum + diffMat(row, col, colr);
            end
        end
    end
    average = sum / (size(diffMat,1) * size(diffMat,2)* size(diffMat,3));
    
    
    fprintf('The Second Image is about %.2f %% the same as the First Image\n', (1 - average)*100); 
end
