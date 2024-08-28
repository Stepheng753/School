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

figure(), imshow( red )
print -depsc ../Figures/Prob5/red/1.eps
figure(), imshow( uint8(f0) )
print -depsc ../Figures/Prob5/red/2.eps
figure(), imshow( uint8(f1) )
print -depsc ../Figures/Prob5/red/3.eps
figure(), imshow( mat2gray( log(abs(F1) + 1) ) )
print -depsc ../Figures/Prob5/red/4.eps
figure(), imshow( mat2gray( log(abs(Glp) + 1) ) )
print -depsc ../Figures/Prob5/red/5.eps
figure(), imshow( mat2gray( log(abs(G) + 1) ) )
print -depsc ../Figures/Prob5/red/6.eps
figure(), imshow(uint8(gflt))
print -depsc ../Figures/Prob5/red/7.eps
figure(), imshow(uint8(fflt1))
print -depsc ../Figures/Prob5/red/8.eps

[f0, f1, F1, Glp, G, gflt, fflt2] = GaussianLP(green, r0);

figure(), imshow( green )
print -depsc ../Figures/Prob5/green/1.eps
figure(), imshow( uint8(f0) )
print -depsc ../Figures/Prob5/green/2.eps
figure(), imshow( uint8(f1) )
print -depsc ../Figures/Prob5/green/3.eps
figure(), imshow( mat2gray( log(abs(F1) + 1) ) )
print -depsc ../Figures/Prob5/green/4.eps
figure(), imshow( mat2gray( log(abs(Glp) + 1) ) )
print -depsc ../Figures/Prob5/green/5.eps
figure(), imshow( mat2gray( log(abs(G) + 1) ) )
print -depsc ../Figures/Prob5/green/6.eps
figure(), imshow(uint8(gflt))
print -depsc ../Figures/Prob5/green/7.eps
figure(), imshow(uint8(fflt2))
print -depsc ../Figures/Prob5/green/8.eps

[f0, f1, F1, Glp, G, gflt, fflt3] = GaussianLP(blue, r0);

figure(), imshow( blue )
print -depsc ../Figures/Prob5/blue/1.eps
figure(), imshow( uint8(f0) )
print -depsc ../Figures/Prob5/blue/2.eps
figure(), imshow( uint8(f1) )
print -depsc ../Figures/Prob5/blue/3.eps
figure(), imshow( mat2gray( log(abs(F1) + 1) ) )
print -depsc ../Figures/Prob5/blue/4.eps
figure(), imshow( mat2gray( log(abs(Glp) + 1) ) )
print -depsc ../Figures/Prob5/blue/5.eps
figure(), imshow( mat2gray( log(abs(G) + 1) ) )
print -depsc ../Figures/Prob5/blue/6.eps
figure(), imshow(uint8(gflt))
print -depsc ../Figures/Prob5/blue/7.eps
figure(), imshow(uint8(fflt3))
print -depsc ../Figures/Prob5/blue/8.eps

balloons(:,:,1) = uint8(fflt1);
balloons(:,:,2) = uint8(fflt2);
balloons(:,:,3) = uint8(fflt3);

figure(), imshow(balloons)
print -depsc ../Figures/Prob5/filtered.eps




















