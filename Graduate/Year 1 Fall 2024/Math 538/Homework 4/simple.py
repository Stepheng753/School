import matplotlib.pyplot as plt
import numpy as np
import random

x_range = np.linspace(-2.5, 2.5, 700)
y_range = np.linspace(-2.5, 2.5, 700)
num_iters = 50
a = 1.28
b = -0.3
diverged_x = []
diverged_y = []


# Loops through all points within window of x in [-2.5, 2.5] and y in [-2.5, 2.5]
for x0 in x_range:
    for y0 in y_range:
        x = x0
        y = y0
        # Keeps reiterating henon map - 50 times
        for _ in range(num_iters):
            prev_x = x
            prev_y = y
            x = a - prev_x**2 + b*prev_y
            y = prev_x
            # If infinity, it means it has diverged and break here (stop here)
            if np.isinf(x) or np.isnan(x) or np.isinf(y) or np.isnan(y):
                diverged_x.append(x0)
                diverged_y.append(y0)
                break

plt.plot(diverged_x, diverged_y, 'k,')