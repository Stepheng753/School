function [] = Change_Bit(read_file, write_file, original_bit, new_bit)

% b = original bit, c = new bit
diff = original_bit - new_bit;
diff_factor = 2^diff;

% Get Original
image = imread(read_file);

% Change Bits
image_mod = (image / diff_factor) * diff_factor;

% Show Original v Mod
figure(1), imshow(image)
figure(2), imshow(image_mod)

% Write to File
imwrite(image_mod, write_file)


