clear
close all

imgLeft = Single_Color('..\Images\Left.jpg', 1);
imgRight = Single_Color('..\Images\Right.jpg', 1);

a = 0; b = 0; c = 0;

% Point A
for x = (size(imgLeft, 1) / 2) : (2 * size(imgLeft, 1) / 3)
    for y = 1 : (size(imgLeft,2) / 9)
        if (imgLeft(x,y,2) ~= imgLeft(x,y,3))
            a = y;
            break;
        end
    end
    if a ~= 0
        break;
    end
end

% Point B
for x = (size(imgLeft, 1) / 2) : (5 * size(imgLeft, 1) / 8)
    for y = (3 * size(imgLeft, 2) / 8) : (size(imgLeft, 2) / 2)
        if (imgLeft(x,y,2) ~= imgLeft(x,y,3))
            b = y;
            break;
        end
    end
    if b ~= 0
        break;
    end
end

% Point C
for x = (size(imgRight, 1) / 2) : -1 : (size(imgRight, 1) / 3)
    for y = (size(imgRight, 2) / 3) : (2 * size(imgRight, 2) / 3)
        if (imgRight(x,y,2) ~= imgRight(x,y,3))
            c = y;
            break;
        end
    end
    if c ~= 0
        break;
    end
end







