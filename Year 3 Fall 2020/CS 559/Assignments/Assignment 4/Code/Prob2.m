close all
clear 
clc

brain = imread('../Figures/Brain.png');
r0 = 10;
wf = 3000;

[f0, f1, F1, Gbp, G, gflt, fflt] = GaussianBP(brain, r0, wf);

figure(), imshow( brain )
print -depsc ../Figures/Prob2/1.eps
figure(), imshow( uint8(f0) )
print -depsc ../Figures/Prob2/2.eps
figure(), imshow( uint8(f1) )
print -depsc ../Figures/Prob2/3.eps
figure(), imshow( mat2gray( log(abs(F1) + 1) ) )
print -depsc ../Figures/Prob2/4.eps
figure(), imshow( mat2gray( log(abs(Gbp) + 1) ) )
print -depsc ../Figures/Prob2/5.eps
figure(), imshow( mat2gray( log(abs(G) + 1) ) )
print -depsc ../Figures/Prob2/6.eps
figure(), imshow(uint8(gflt))
print -depsc ../Figures/Prob2/7.eps
figure(), imshow(uint8(fflt))
print -depsc ../Figures/Prob2/8.eps