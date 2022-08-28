function J = Prob6a(I,xarr,yarr,reg_maxdist)
    
    J = zeros(size(I)); % output
    Isizes = size(I);   % sizes of image
    for i = 1 : size(I,3)
        x = xarr(i);
        y = yarr(i);
        neg_free = 10000;   % for neighbor list
        neg_pos = 0;        % position of neighbor, and also number of neighbors
        neg_list = zeros(neg_free,3);   % holds all the neighbor information
        neigb = [-1 0; 1 0; 0 -1;0 1];  % used for finding 4 direction neighbor 
        pixdist = 0;
        reg_mean = I(x,y,i);  
        reg_size = 1;

        % checks whether pixdist isn't bigger than the max region distance 
        % checks whether the region isn't bigger than the image

        % if pixdist > reg_maxdist then no neihgbors are similar to region
        while (pixdist < reg_maxdist(i) && reg_size < numel(I(:,:,i)))

            % finds the 4 neighbors of pixel and adds to neighbor list
            for j = 1 : 4
                % j = 1, it goes to the left neighbor
                % j = 2, it goes to the right neighbor
                % j = 3, it goes to the up neighbor
                % j = 4, it goes to the down neighbor
                % (xn , yn) - neighbor pixel that we working with
                xn = x + neigb(j,1);
                yn = y + neigb(j,2); 

                % is (xn,yn) within the image boundarys 1 < xn, yn < dim(image)
                ins = (xn >= 1) && (yn >= 1) && (xn <= Isizes(1)) && ... 
                      (yn <= Isizes(2)); 

                % checks if inside image, then checks if neighbor pixel wasn't
                % already counted as a neighbor
                if (ins && (J(xn,yn,i) == 0))
                    neg_pos = neg_pos + 1;  % increment neighbor
                    % saves neighbor location and data
                    neg_list(neg_pos, :) = [xn yn I(xn, yn,i)]; 
                    J(xn, yn,i) = 1; % notes as neighbor
                end
            end

            % Make neighbor list bigger if needed;
            if (neg_pos + 10 > neg_free)
                neg_free = neg_free + 10000;
                neg_list( (neg_pos + 1) : neg_free, :) = 0;
            end

            % dist finds distance between the neighbor and the mean
            dist = abs( neg_list(1: neg_pos,3) - reg_mean ) ;

            % pixdist is the smallest distance from one neighbor to the mean
            % index is the index of the neighbor that has the smallest distance
            % from the mean
            [pixdist, index] = min(dist);

            % Path which the algorithm goes is the path of 2s
            J(x,y,i) = 2;
            % increments region size 
            reg_size = reg_size + 1;

            % mean = (mean * reg_size + closest neighbor value) / (reg_size + 1)
            reg_mean = (reg_mean * reg_size + neg_list(index,3))/(reg_size+1);

            % restarts except starts with closest neighbor 
            x = neg_list(index,1); 
            y = neg_list(index,2);

            % replaces the closest neighbor with the last neighbor
            neg_list(index,:) = neg_list(neg_pos,:); 

            % decrements neg_pos so the last neighbor gets overwritten
            neg_pos = neg_pos-1;
        end

        % converts path of 2's into path of 1's and everything else is 0
        J(:,:,i) = J(:,:,i) > 1;
    end
end