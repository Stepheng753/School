clear
close all

A = imread('A.jpg');
B = imread('B.jpg');
C = imread('C.jpg');
D = imread('D.jpg');

figure(); imshow(A)
figure(); imshow(B)
figure(); imshow(C)
figure(); imshow(D)

similar(A,A) 
% The Second Image is about 100.00 % the same as the First Image

similar(A,B)
% The Second Image is about 87.80 % the same as the First Image

similar(A,C)
% The Second Image is about 96.90 % the same as the First Image

similar(A,D)
% The Second Image is about 68.78 % the same as the First Image





