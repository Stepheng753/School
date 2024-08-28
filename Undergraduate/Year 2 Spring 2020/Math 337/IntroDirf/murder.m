function yp = murder(t,y)

% Model for Newton's Law of Cooling
% Parameters for the model 
k = 0.4732877044; Te = 14.5;
yp = -k*(y - Te);
end

% [t,y] = ode23(@murder,[-9,12],y0);
