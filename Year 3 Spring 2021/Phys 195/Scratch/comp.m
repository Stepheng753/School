function A = comp(r,theta)
    x = r*cosd(theta);
    y = r*sind(theta);
    A = [x,y];
    fprintf('\nx: %.4f\n\n', x);
    fprintf('y: %.4f\n', y);
end