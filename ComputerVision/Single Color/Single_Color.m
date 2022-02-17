function [] = Single_Color(read_file, write_file, color_num)

    % Get Original
    full_color = imread(read_file);

    % Extract Colors
    red = full_color(:,:,1);
    green = full_color(:,:,2);
    blue = full_color(:,:,3);

    % Convert to black and white 
    blackwhite = rgb2gray(full_color);

    % Create a Blank Matrix the size of the original
    single_color = uint8(zeros(size(full_color)));

    % Make Black and White
    single_color(:,:,1) = blackwhite;
    single_color(:,:,2) = blackwhite;
    single_color(:,:,3) = blackwhite;

    % Color Conversion
    % Traverse every pixel, if more of one color, then keep the full color
    for x = 1 : size(single_color,1)
        for y = 1 : size(single_color,2)
            if color_num == 1
                if red(x,y) > 128 && green(x,y) < 128 && blue(x,y) < 128
                    for z = 1 : 3
                        single_color(x,y,z) = full_color(x,y,z);
                    end
                end
            elseif color_num == 2
                if green(x,y) > 128 && red(x,y) < 128 && blue(x,y) < 128
                    for z = 1 : 3
                        single_color(x,y,z) = full_color(x,y,z);
                    end
                end
            elseif color_num == 3
                if blue(x,y) > 128 && red(x,y) < 128 && green(x,y) < 128
                    for z = 1 : 3
                        single_color(x,y,z) = full_color(x,y,z);
                    end
                end
            end
        end
    end

    % Show Original v Mod
    figure(), imshow(full_color)
    figure(), imshow(single_color)

    % Write to File
    imwrite(single_color, write_file)
    
end






