clear
close all

figure(1)
A = imread('..\Photos\Bird.jpg');
imshow(A)

figure(2)
B = bilinearInterpl(A, 3);
imshow(B)

figure(3)
C = imresize(A, 3, 'bilinear');
imshow(C)


