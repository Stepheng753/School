close all
clear 
clc

lena2 = rgb2gray(imread('../Figures/Lena2.png'));

[f0, f1, F1, Glp, G, gflt, fflt] = GaussianLP(lena2, 40);


figure(), imshow( lena2 )
print -depsc ../Figures/Prob4/1.eps
figure(), imshow( uint8(f0) )
print -depsc ../Figures/Prob4/2.eps
figure(), imshow( uint8(f1) )
print -depsc ../Figures/Prob4/3.eps
figure(), imshow( mat2gray( log(abs(F1) + 1) ) )
print -depsc ../Figures/Prob4/4.eps
figure(), imshow( mat2gray( log(abs(Glp) + 1) ) )
print -depsc ../Figures/Prob4/5.eps
figure(), imshow( mat2gray( log(abs(G) + 1) ) )
print -depsc ../Figures/Prob4/6.eps
figure(), imshow(uint8(gflt))
print -depsc ../Figures/Prob4/7.eps
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob4/8.eps

[~, ~, ~, ~, ~, ~, fflt] = GaussianLP(lena2, 1);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob4/r01.eps
[~, ~, ~, ~, ~, ~, fflt] = GaussianLP(lena2, 20);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob4/r020.eps
[~, ~, ~, ~, ~, ~, fflt] = GaussianLP(lena2, 40);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob4/r040.eps
[~, ~, ~, ~, ~, ~, fflt] = GaussianLP(lena2, 60);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob4/r060.eps
[~, ~, ~, ~, ~, ~, fflt] = GaussianLP(lena2, 80);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob4/r080.eps
[~, ~, ~, ~, ~, ~, fflt] = GaussianLP(lena2, 100);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob4/r0100.eps





















