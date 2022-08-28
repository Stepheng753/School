# python3 ./prog2.py
# Program 2

import sys
import random
import os

def main():
    readable = clean_read_args()
    list_of_trigrams = get_list_of_trigrams(readable)
    first5_words = get_lines(list_of_trigrams, 5)
    seven_words = get_lines(list_of_trigrams, 7)
    second5_words = get_lines(list_of_trigrams, 5)

    print()
    print('Number of Trigrams: ', len(list_of_trigrams))
    print(first5_words)
    print(seven_words)
    print(second5_words)
    print()

    write_output(first5_words, seven_words, second5_words)


def clean_read_args(num_iterations = 0, ask_to_enter_file = len(sys.argv)):
    try:
        if ask_to_enter_file == 1:
            file_name = input('Please enter in Input File to Read from: ') 
        elif ask_to_enter_file == 2:
            file_name = sys.argv[1]
        else:
            raise

        with open(file_name, 'r') as f:
            return read_clean_file(f)

    except Exception:
        if num_iterations == 4:
            print('File Not Found, Now Closing Application')
            sys.exit()

        print('Try Again, File Not Found')
        return clean_read_args(num_iterations + 1, 1)


def read_clean_file(file):
    readable = file.read()
    terminating_chars = [',', '.', '!', '?', ';']
    for term_char in terminating_chars:
        readable = readable.replace(term_char,'')
    readable = readable.strip().split()
    return readable


def get_list_of_trigrams(word_arr):
    list_of_trigrams = []
    for i in range(0, len(word_arr) - 2):
        trigram = (word_arr[i].lower(), word_arr[i+1].lower(), word_arr[i+2].lower())
        list_of_trigrams.append(trigram)
    return list_of_trigrams


def get_lines(list_of_trigrams, num_words):
    starting_trigram = list_of_trigrams[random.randrange(0, len(list_of_trigrams))]
    run_num_times = 1 if num_words == 5 else 2

    for i in range(0, run_num_times):
        connectors = []
        for i in range(0, len(list_of_trigrams)):
            if (starting_trigram[len(starting_trigram) - 1] == list_of_trigrams[i][0]):
                connectors.append(list_of_trigrams[i]);
        
        if (len(connectors) == 0):
            return get_lines(list_of_trigrams, num_words)
        
        random_trigram = connectors[random.randrange(0, len(connectors))]

        connect2 = list(starting_trigram)
        [connect2.append(random_trigram[i]) for i in range(1, len(random_trigram))]

        starting_trigram = connect2 if num_words == 7 else starting_trigram

    line = connect2[0]
    for i in range(1, len(connect2)):
        line = line  + ' ' + connect2[i]
    return line


def write_output(line1, line2, line3):
    write_str = line1 + '\n' + line2 + '\n' + line3 + '\n\n'
    write_file = open('output.txt', 'ab+')
    write_file.write(bytes(write_str, 'UTF-8'))
    

if __name__ == '__main__':
    write_file = open('output.txt', 'wb')
    for i in range(0,5):
        main()