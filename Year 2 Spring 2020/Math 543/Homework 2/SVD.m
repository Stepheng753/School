function [] = SVD(A)
[U,S,V] = svd(A);

theta = 0:pi/543:2*pi;
unitCircle = [cos(theta);
            sin(theta)];
modCircle = A*unitCircle;

subplot(1,2,2)
% Plot Unit Circle
plot(unitCircle(1,:),unitCircle(2,:),'b.'),grid;
% Right Vectors, V 
arrow([0,0], [V(1,1),V(2,1)])
arrow([0,0], [V(1,2),V(2,2)])
title('Right Vectors, V')

subplot(1,2,1)
% Plot Mod Circle
plot(modCircle(1,:),modCircle(2,:),'r.'),grid;
% Left Vectors, U * s_ii
axis(axis)
arrow([0,0], [U(1,1),U(2,1)] * S(1,1))
if (abs(S(2,2)) > 1e-10)
    arrow([0,0], [U(1,2),U(2,2)]*S(2,2))
end
title('Left Vectors, US')










