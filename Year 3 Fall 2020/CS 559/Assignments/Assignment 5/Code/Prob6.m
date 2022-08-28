close all;
clear all;

% Problem 6a
I1 = im2double(imread('../Figures/ThreeRegions.jpg'));
xarr = [180 180 180];
yarr = [125 175 215];
reg_maxdist = [0.0485 0.2 0.15];

J1 = Prob6a(I1,xarr,yarr,reg_maxdist);
figure(), imshow(J1)
bw = J1(:,:,1) + J1(:,:,2) + J1(:,:,3);
figure(), imshow(bw)



% Problem 6b
Area = sum(bw(:,:),'all');

sumsx = 0; sumsy = 0;
for x = 0 : size(J1,1) - 1
    for y = 0 : size(J1,2) - 1
        sumsx = sumsx + x*bw(x+1,y+1);
        sumsy = sumsy + y*bw(x+1,y+1);
    end
end
xc = (1 / Area) * sumsx;
yc = (1 / Area) * sumsy;
centroid = [xc, yc];

bound = edge(bw, 'canny');
figure(), imshow(bound)
points = zeros(Area,3); i = 1;
for x = 1 : size(bound,1) 
    for y = 1 : size(bound,2) 
        if (bound(x,y) == 1)
            points(i,1) = x;
            points(i,2) = y;
            points(i,3) = sqrt( ((x - xc)^2) + ((y - yc)^2) );
            i = i + 1;
        end
    end
end
points = points(1:i,:);
dave = sum(points(:,3)) / size(points,1);

circ = 0;
for i = 1 : size(points,1)
    circ = circ + ((points(i,3) - dave)^2);
end


% Problem 6c
I2 = imresize(im2double(imread('../Figures/Beans.jpg')), 1 / 3);
color = [.64 .27 .29];
reg_maxdist = [0.14 0.12 0.13];
J2 = Prob6c(I2,color,reg_maxdist);

A = edge(rgb2gray(J2), 'canny');
figure(), imshow(A)
[center1, radius1] = imfindcircles(A, [15 50]);

figure(), imshow(I2)
viscircles(center1, radius1,'EdgeColor','r');



% Problem 6d
color = [.97 .81 .31];
reg_maxdist = [0.005 0.3 0.3];
J = Prob6c(I2,color,reg_maxdist);

A = edge(rgb2gray(J), 'canny');
[center2, radius2] = imfindcircles(A, [20 100]);

figure(), imshow(I2)
viscircles(center1, radius1,'EdgeColor','r');
viscircles(center2, radius2,'EdgeColor','r');
line([center1(1) center2(1)], [center1(2), center2(2)],... 
    'linewidth', 2 , 'color', 'red');

d = sqrt( ((center2(1) - center1(1))^2) + ((center2(2) - center1(2))^2) )... 
    - (radius1 + radius2);

