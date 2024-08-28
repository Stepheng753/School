close all

img = imread('1.jpg');
img = imresize(img, 1/25)
colorEdgeDetect('1.jpg', 140, 20, 50);