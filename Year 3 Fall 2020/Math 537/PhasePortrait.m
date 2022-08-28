clf; clc;                
hold off; 
close all;

% Set Scale and Axes
xStart = -5; xFinal = 16; dx = 1;
yStart = xStart; yFinal = xFinal; dy = dx;

% Makes the Axis
x = xStart : dx: xFinal;    % Go from xStart to xFinal by dx
y = yStart : dy: yFinal;    % Go from yStart to yFinal by dy

% Creates a 2D array (graph)
% Contains Integer Coordinates
[X,Y] = meshgrid(x,y);

% Set Length of Axes
xLen = length(x);
yLen = length(y);

% Initialize P(x,y),Q(x,y)
P = zeros(xLen, yLen);
Q = zeros(xLen, yLen);

% Loop to display vectors
for i = 1 : xLen
    xi = xStart + (i - 1)*dx;
    for j = 1 : yLen
        yj = yStart + (j - 1)*dy;
        P(j, i) = p(xi, yj);
        Q(j, i) = q(xi, yj);
    end
end

figure(1); 
hold on;
grid on;
quiver(X,Y,P,Q,'r')

function [p] = p(xi, yj) 
    p = xi*(.56 - .12*xi - .02*yj);
end

function [q] = q(xi, yj) 
    q = yj*(.45 - .03*yj - .01*xi);
end

















