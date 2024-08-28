clear
close all

A = imread('..\Photos\A.jpg');
B = imread('..\Photos\B.jpg');
C = imread('..\Photos\C.jpg');
D = imread('..\Photos\D.jpg');
figure (1); imshow(A)
figure(2); imshow(D)

similar(A,A) 
% The Second Image is about 100.00 % the same as the First Image

similar(A,B)
% The Second Image is about 87.80 % the same as the First Image

similar(A,C)
% The Second Image is about 96.90 % the same as the First Image

similar(A,D)
% The Second Image is about 68.78 % the same as the First Image





