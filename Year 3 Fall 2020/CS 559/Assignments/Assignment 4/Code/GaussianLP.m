function [f0, f1, F1, Glp, G, gflt, fflt] = GaussianLP(img, r0)
    
    % Padding for Size
    w = size(img, 1);
    h = size(img, 2);
    power2 = 2 .^ (1 : 12);
    for i = 1 : 12
        if max(w,h) <= power2(i)
            break
        end
    end
    n = power2(i);

    f0 = zeros(n,n);
    for i = 1 : w
        for j = 1 : h
            f0(i,j) = img(i,j);
        end
    end

    % Multiply by -1 ^ x+y
    f1 = zeros(n,n);
    for x = 1 : n
        for y = 1 : n
            f1(x,y) = (-1)^(x+y) * f0(x,y);
        end
    end

    % Fourier Transform
    F1 = fft2(f1);

    % Filter 
    Glp = zeros(n,n);
    u = [(-n/2):((n/2) - 1), (-n/2):((n/2) - 1)];
    [U,V] = meshgrid(u,u);
    for i = 1 : n
        for j = 1 : n
            r2 = U(i,j)^2 + V(i,j)^2;
            frac = (-r2) / (2 * (r0)^2);
            Glp(i,j) = exp(frac);
        end
    end

    % Multication of HF1
    G = Glp .* F1;

    % Inverse
    gflt = abs(ifft2(G));
    fflt = gflt(1:w, 1:h);



end