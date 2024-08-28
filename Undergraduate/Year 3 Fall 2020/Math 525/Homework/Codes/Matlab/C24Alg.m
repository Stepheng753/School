function u = C24Alg(r) 
    B = [1 1 0 1 1 1 0 0 0 1 0 1; 
         1 0 1 1 1 0 0 0 1 0 1 1;
         0 1 1 1 0 0 0 1 0 1 1 1;
         1 1 1 0 0 0 1 0 1 1 0 1;
         1 1 0 0 0 1 0 1 1 0 1 1;
         1 0 0 0 1 0 1 1 0 1 1 1;
         0 0 0 1 0 1 1 0 1 1 1 1;
         0 0 1 0 1 1 0 1 1 1 0 1;
         0 1 0 1 1 0 1 1 1 0 0 1;
         1 0 1 1 0 1 1 1 0 0 0 1;
         0 1 1 0 1 1 1 0 0 0 1 1;
         1 1 1 1 1 1 1 1 1 1 1 0];
    I = eye(12);
    H = [I; B];
    
    % Step 1
    s1 = mod(r*H,2);
    
    % Step 2
    if weight(s1) <= 3
        u = [s1,0];
        return
    end
    
    % Step 3
    for i = 1 : 12
        spb = mod(s1 + B(i,:),2);
        if weight(spb) <= 2
            ei = zeros(1,12);
            ei(i) = 1;
            u = [spb, ei];
            return
        end
    end
    
    % Step 4
    s2 = mod(s1*B,2);
    
    % Step 5
    if weight(s2) <= 3
        u = [0, s2];
        return
    end
    
    % Step 6 
    for i = 1 : 12
        spb = mod(s2 + B(i,:),2);
        if weight(spb) <= 2
            ei = zeros(1,12);
            ei(i) = 1;
            u = [ei, spb];
            return
        end
    end
    
    % Step 7
    u = -1;
    
    
    
end

function wt = weight(w)
    wt = 0;
    for i = 1 : length(w)
        if w(i) == 1
            wt = wt + 1;
        end
    end
end















