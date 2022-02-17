function [] = colorEdgeDetect (fileName, redLim, greenLim, blueLim)

    input = imread(fileName);
    red = input(:,:,1);
    green = input(:,:,2);
    blue = input(:,:,3);
    output = input;
    
    
    % Horizontal Traversal
    for x = 2 : ( size(input, 1) - 2 )
        for y = 2 : ( size(input, 2) - 2 )
            greenLeft = red(x-1,y) < redLim && green(x-1,y) > greenLim && blue(x-1,y) < blueLim; 
            greenRight = red(x+1,y) < redLim && green(x+1,y) > greenLim && blue(x+1,y) < blueLim;
            if (greenLeft && ~greenRight) || (~greenLeft && greenRight)
                output(x,y,1) = 0;
                output(x,y,2) = 0;
                output(x,y,3) = 255;
            end      
        end
    end
    
    % Vertical Traversal
    for x = 2 : ( size(input, 1) - 2 )
        for y = 2 : ( size(input, 2) - 2 )
            greenLeft = red(x,y-1) < redLim && green(x,y-1) > greenLim && blue(x,y-1) < blueLim; 
            greenRight = red(x,y+1) < redLim && green(x,y+1) > greenLim && blue(x,y+1) < blueLim;
            if (greenLeft && ~greenRight) || (~greenLeft && greenRight)
                output(x,y,1) = 0;
                output(x,y,2) = 0;
                output(x,y,3) = 255;
            end      
        end
    end
    
    figure(), imshow(output)
end