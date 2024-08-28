
% Quantization Table  
q = [16 11 10 16 24 40 51 61;
     12 12 14 19 26 58 60 55;
     14 13 16 24 40 57 69 56;
     14 17 22 29 51 87 80 62;
     18 22 37 56 68 109 103 77;
     24 35 55 64 81 104 113 92;
     49 64 78 87 103 121 120 101;
     72 92 95 98 112 100 103 99;];

% given matrix
f = [56  45  51  66  70  61  64  73 ;
     63  59  56  90  109  85  69  72 ;
     62  59  68  103  144  104  66  73 ;
     63  58  71  132  134  106  70  69 ;
     65  61  68  114  116  82  68  70 ;
     79  65  60  67  77  68  58  75 ;
     85  71  54  59  55  61  65  73 ;
     87  79  69  58  65  66  78  94];

 % Step 1: bar{f} = f - 128
 fb = f - 128;
 
 % Step 2: Use DCT to get bar{C}
 n = 8; Cb = zeros(8,8);
 for u = 0 : (n - 1)
     for v = 0 : (n - 1)
         if (u == 0), a = sqrt(1 / n);
         else, a = sqrt(2 / n); end
         
         if (v == 0), b = sqrt(1 / n);
         else, b = sqrt(2 / n); end
         
         sum = 0;
         for x = 0 : (n - 1)
             for y = 0 : (n - 1)
                 sum = sum + fb((x + 1), (y + 1))*cos((pi * (2*x + 1)* u) / (2*n)) * ...
                     cos((pi * (2*y + 1)* v) / (2*n));
             end
         end
         
         Cb((u + 1), (v + 1)) = a*b*sum;
     end
 end
 
% Step 3: Quantize bar{C}
Cq = round( Cb ./ q);

% Step 4: Arrange into 1D sequence in zig zag order
Cq1 = zeros(1,64);

i = 1; x = 1; y = 1; % Start
Cq1(i) = Cq(x, y);
i = i + 1; y = y + 1; % Right
while (i <= 64  )
    while (x >= 1 && y >= 1 && x <= 8 && y <= 8)
        Cq1(i) = Cq(x,y);
        i = i + 1;
        x = x + 1; % Down
        y = y - 1; % Left
    end
    if (x > 8)
        x = x - 1; % Up
        y = y + 1; % Right 
    end
    y = y + 1; % Right
    while (x >= 1 && y >= 1 && x <= 8 && y <= 8)
        Cq1(i) = Cq(x,y);
        i = i + 1;
        x = x - 1; % Up
        y = y + 1; % Right
    end
    if (y > 8)
        x = x + 1; % Down
        y = y - 1; % Left 
    end
    x = x + 1; % Down
end

% Remove trailing zeros
len = 64;
while (Cq1(len) == 0)
    len = len - 1;
end

Cq1 = Cq1(1 : len);





 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

 