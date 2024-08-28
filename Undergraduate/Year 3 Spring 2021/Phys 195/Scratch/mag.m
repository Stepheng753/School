function A = mag(x,y) 

    r = sqrt(x^2 + y^2);
    theta = atand(y/x);
    if (x < 0 && y > 0) || (x < 0 && y < 0) 
        theta = theta + 180;
    end
    
    A = [r, theta];
    
    fprintf('\nMagnitude: %.4f\n\n', r);
    fprintf('Theta: %.4f\n', theta);
end

