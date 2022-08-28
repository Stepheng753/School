# python3 ./randList.py
# Program 1

import random
import sys
import timeit

def main():
    print('Welcome - Stephen Giang\n')
    inputs_arr = get_inputs()

    print()
    print('Test Size:', inputs_arr[0])
    print('Modify into Dice: ', inputs_arr[1])

    if inputs_arr[1]:
        print('Beginning Range: ', inputs_arr[2])
        print('Ending Range: ', inputs_arr[3])
        print()

        num_tests = inputs_arr[0]
        for i in range(0, 12):
            time = timeit.timeit(wrapped_roll(epoch, num_tests, inputs_arr[2], inputs_arr[3], inputs_arr[1]), number=1)
            print('time = {0:1.7f}'.format(time))
            num_tests *= 2
    else:
        print()

        num_tests = inputs_arr[0]
        for i in range(0, 12):
            time = timeit.timeit(wrapped_roll(epoch, num_tests), number=1)
            print('time = {0:1.7f}'.format(time))
            num_tests *= 2

    


def epoch(num_tests, begin_range = 0, end_range = 1, modified = False):
    coins_dice_test = rand_num_gen(num_tests, begin_range, end_range)

    if not modified:
        stats = calc_coin_stats(coins_dice_test)
        print('n = {0:08d}, h = {1:08d}, t = {2:08d}, p = {3:1.7f}, ch = {4:02d}, ct = {5:02d}'.format(num_tests, stats[0], stats[1], stats[2], stats[3], stats[4]), end=", ")
    else:
        stats = calc_dice_stats(coins_dice_test, begin_range, end_range)
        print('n = {0:08d}, minimal value continual run: c{1:02d} = {3:02d}, longest continual run: c{2:02d} = {4:02d}'.format(num_tests, stats[0], stats[1], stats[2], stats[3]), end=", ")

def get_inputs():
    inputs_arr = []

    enter_test_size = input('Would you like to enter a test size? Type \'y\' or \'n\': ')
    input_test_size = -1
    if enter_test_size.lower() == 'y' or enter_test_size.lower() == 'yes':
        while input_test_size < 0:
            try:
                input_test_size = int(input('Enter Test Size: '))
                if input_test_size <= 0:
                    raise ValueError
                inputs_arr.append(input_test_size)
            except ValueError:
                print('Not a Valid Test Size')
    else:
        inputs_arr.append(16)  
    

    modify_to_dice = input('Would you like to modify this program to a dice roll? Type \'y\' or \'n\': ')
    if modify_to_dice.lower() == 'y' or modify_to_dice.lower() == 'yes':
        inputs_arr.append(True)

        begin_range = None
        while begin_range is None:
            try:
                begin_range = int(input('Enter Beginning Range: '))
            except ValueError:
                print('Not a Valid Beginning Range')

        end_range = None
        while end_range is None:
            try:
                end_range = int(input('Enter Ending Range: '))
            except ValueError:
                print('Not a Valid Ending Range') 

        if end_range < begin_range:
            temp = end_range
            end_range = begin_range
            begin_range = temp
        
        inputs_arr.append(begin_range)
        inputs_arr.append(end_range)
    else:
        inputs_arr.append(False)

    return inputs_arr


def rand_num_gen(num_rolls = 10, begin_range = 0, end_range = 1):
    rand_num_arr = []
    random.seed()
    for x in range(0, num_rolls):
        rand_num_arr.append(random.randint(begin_range, end_range))

    return rand_num_arr


def calc_coin_stats(coin_flips_arr):
    stats_arr = []  # [h, t, p, cH, cT]
    num_coin_flips = len(coin_flips_arr)

    counter = 0
    for i in range(0, num_coin_flips):
        if coin_flips_arr[i] == 0:
            counter += 1
    stats_arr.append(counter)
    stats_arr.append(num_coin_flips - counter)
    stats_arr.append(counter / num_coin_flips)
    
    
    for i in range(0,2):
        counter = 0
        max_count = 0
        for j in range(0, num_coin_flips):
            if coin_flips_arr[j] == i:
                counter += 1
            if coin_flips_arr[j] != i or j == num_coin_flips - 1:
                if max_count < counter:
                    max_count = counter
                counter = 0
        stats_arr.append(max_count)

    return stats_arr

def calc_dice_stats(dice_rolls_arr, begin_range, end_range):
    stats_arr = []  # [smallestNum, largestContinualNum, cS, cL]
    num_dice_rolls = len(dice_rolls_arr)

    max_count_holder = []
    for i in range(begin_range, end_range + 1):
        counter = 0
        max_count = 0
        for j in range(0, num_dice_rolls):
            if dice_rolls_arr[j] == i:
                counter += 1
            if dice_rolls_arr[j] != i or j == num_dice_rolls - 1:
                if max_count < counter:
                    max_count = counter
                counter = 0
        max_count_holder.append([i, max_count])

    smallest_num = begin_range
    count_smallest_num = max_count_holder[0][1]

    biggest_num = 0
    count_biggest_num = 0
    for i in range(0, len(max_count_holder)):
        if max_count_holder[i][1] > count_biggest_num:
            biggest_num = max_count_holder[i][0]
            count_biggest_num = max_count_holder[i][1]

    stats_arr = [smallest_num, biggest_num, count_smallest_num, count_biggest_num]

    return stats_arr

def wrapped_roll(func, *args, **kwargs):
    def inner():
        func(*args, **kwargs)
    return inner
    

if __name__ == '__main__':
    main()
