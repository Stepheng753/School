close all
clear 
clc

lena2 = rgb2gray(imread('../Figures/Lena2.png'));


[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena2, 45,6);

figure(), imshow(uint8(abs(fflt)))



[~, ~, ~, ~, ~, ~, fflt] = GaussianLP(lena2, 40);

figure(), imshow(uint8(abs(fflt)))