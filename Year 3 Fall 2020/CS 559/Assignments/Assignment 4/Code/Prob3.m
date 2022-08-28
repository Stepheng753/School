close all
clear 
clc

lena = rgb2gray(imread('../Figures/Lena.png'));

[f0, f1, F1, Hlp, G, gflt, fflt] = ButterworthLP(lena, 45, 6);

figure(), imshow( lena )
print -depsc ../Figures/Prob3/1.eps
figure(), imshow( uint8(f0) )
print -depsc ../Figures/Prob3/2.eps
figure(), imshow( uint8(f1) )
print -depsc ../Figures/Prob3/3.eps
figure(), imshow( mat2gray( log(abs(F1) + 1) ) )
print -depsc ../Figures/Prob3/4.eps
figure(), imshow( mat2gray( log(abs(Hlp) + 1) ) )
print -depsc ../Figures/Prob3/5.eps
figure(), imshow( mat2gray( log(abs(G) + 1) ) )
print -depsc ../Figures/Prob3/6.eps
figure(), imshow(uint8(gflt))
print -depsc ../Figures/Prob3/7.eps
figure(), imshow(uint8(abs(fflt)))
print -depsc ../Figures/Prob3/8.eps

[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 1, 6);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/r01.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 20, 6);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/r020.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 40, 6);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/r040.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 60, 6);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/r060.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 80, 6);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/r080.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 100, 6);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/r0100.eps

[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 45, 1);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/p1.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 45, 3);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/p3.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 45, 6);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/p6.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 45, 10);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/p10.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 45, 25);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/p25.eps
[~, ~, ~, ~, ~, ~, fflt] = ButterworthLP(lena, 45, 100);
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob3/p100.eps




















