close all
clear 
clc

balloons = imread('../Figures/balloons.png');

figure(), imshow( balloons )

red = balloons(:,:,1);
green = balloons(:,:,2);
blue = balloons(:,:,3);

r0 = 30;

[f0, f1, F1, Glp, G, gflt, fflt1] = GaussianLP(red, r0);

[f0, f1, F1, Glp, G, gflt, fflt2] = GaussianLP(green, r0);

[f0, f1, F1, Glp, G, gflt, fflt3] = GaussianLP(blue, r0);

balloons(:,:,1) = uint8(fflt1);
balloons(:,:,2) = uint8(fflt2);
balloons(:,:,3) = uint8(fflt3);

figure(), imshow(balloons)




















