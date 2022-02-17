import random
from pathlib import Path

def main():
    Open_Output_Folder()
    output = Open_Output_File('w+')
    print('Program 3')
    print('Data Structures for Data Scientists and Engineers')
    print('SDSU CS 496')
    print('Stephen Giang and Elvidio Hidalgo')
    print('-------------------------------------------')

    output.write('Program 3\n')
    output.write('Data Structures for Data Scientists and Engineers\n')
    output.write('SDSU CS 496\n')
    output.write('Stephen Giang and Elvidio Hidalgo\n')
    output.write('-------------------------------------------\n')
    Close_Output_File(output)
    User_Input()

def Open_Output_Folder():
    p = Path('Output')
    p.mkdir(exist_ok=True)

def Open_Output_File(str):
    output = open("Output.txt", str)
    return output

def Close_Output_File(output):
    output.close()

def User_Input():
    print('Enter an option in brackets->[ ]')
    choice = -1
    while choice != 0:
        choice = input('Would you like to display a range of events[1], 5 random events[2], or exit[0]: ')
        print()
        if(choice == '1'):
            event1 = input('Select starting event [ 1 - 243666 ]: ')
            event2 = input('Select ending event [ 1 - 243666 ]: ')
            if(event1 > event2):
                temp = event1
                event2 = event1
                event2 = temp
            for i in range(int(event1), int(event2) + 1):
                Render_Human_Info(i)
        if choice == '2':
            print('\nDisplaying Events:\n')
            for i in range(0, 5):
                Render_Human_Info(random.randint(1, 243666))
        if choice == '0':
            break
    print('Exiting Program')

def Render_Human_Info(entry_num):
    CLEANED = open('CSV Files\\COLEDV_Cleaned.csv')
    SUB_UNITS = open('CSV Files\\COLEDV_Sub_Unit.csv')
    MAJOR_UIC = open('CSV Files\\COLEDV_Major_UIC.csv')
    MAJOR_NAME = open('CSV Files\\COLEDV_Major_NAME.csv')
    MISSION_CODE = open('CSV FILES\\COLEDV_Mission_Codes.csv')
    TERRAIN_CODE = open('CSV FILES\\COLEDV_Terrain_Codes.csv')
    WEATHER_CODE = open('CSV FILES\\COLEDV_Weather_Codes.csv')
    DAY_NIGHT_CODE = open('CSV FILES\\COLEDV_Day_Night_Codes.csv')
    TARGET_FIRE_CODES = open('CSV Files\\COLEDV_Target_Fire_Codes.csv')
    WEAPON_CODES = open('CSV Files\\COLEDV_Weapon_Codes.csv')
    events = CLEANED.readlines()
    sub_units = SUB_UNITS.readlines()
    major_uics = MAJOR_UIC.readlines()
    major_names = MAJOR_NAME.readlines()
    mission_codes = MISSION_CODE.readlines()
    terrain_codes = TERRAIN_CODE.readlines()
    weather_codes = WEATHER_CODE.readlines()
    day_night_codes = DAY_NIGHT_CODE.readlines()
    target_fire_codes = TARGET_FIRE_CODES.readlines()
    weapon_codes = WEAPON_CODES.readlines()
    WEAPON_CODES.close()
    TARGET_FIRE_CODES.close()
    DAY_NIGHT_CODE.close()
    WEATHER_CODE.close()
    TERRAIN_CODE.close()
    MISSION_CODE.close()
    MAJOR_NAME.close()
    MAJOR_UIC.close()
    SUB_UNITS.close()
    CLEANED.close()

    headers = events[0][:-1].split(',')
    current_event = events[entry_num][:-1].split(',')
    output = Open_Output_File('a+')
    string = "Event " + str(entry_num) + " of " + str((len(events) - 1))

    string = string + '    ' +  Julian_Converter(current_event[headers.index('JULIAN DATE OF ACTION')])
    output.write(string + '\n')
    print(string)
    
    string = 'Subunit: ' + str(find(sub_units, current_event[headers.index('SUB-UNIT UIC')],1)) + ' (' + str(current_event[0]) + ')    '
    string =string + 'Major Command: ' + str(find(major_names, current_event[headers.index('MAJOR COMMAND NAME')],1)) + ' (' + str(find(major_uics, current_event[headers.index('MAJOR COMMAND UIC')],1)) + ')'
    output.write(string + '\n')

    string = 'Mission: ' + str(find(mission_codes, current_event[headers.index('MISSION CODE')],1))
    output.write(string + '\n')
    print(string)

    string = 'Terrain: ' + str(find(terrain_codes, current_event[headers.index('TERRAIN CODE')],1)) + '    '
    string = string + 'Weather: ' + str(find(weather_codes, current_event[headers.index('WEATHER CODE')],1)) + '    '
    string = string + 'Day/Night: ' + str(find(day_night_codes, current_event[headers.index('DAY-NIGHT CODE')],1))
    output.write(string + '\n')
    print(string)

    print('Weapon Code: ', find(weapon_codes, current_event[headers.index('WEAPON CODE')], 1), '(', find(target_fire_codes, current_event[headers.index('TARGET FIRE')],1),')')
    string = 'Weapon Code: '+ str(find(weapon_codes, current_event[headers.index('WEAPON CODE')], 1)) + ' (' + str(find(target_fire_codes, current_event[headers.index('TARGET FIRE')],1)) + ')'
    output.write(string + '\n')
    index = headers.index('ROUND TYPE 1')
    for entry_num in range(0,9):
        if current_event[index] != '':
            print('Ammo Type', entry_num+1, ':', find(weapon_codes, current_event[headers.index('WEAPON CODE')], entry_num+2), ' => Rounds:', current_event[index])
            string = 'Ammo Type ' + str(entry_num+1) + ': ' + str(find(weapon_codes, current_event[headers.index('WEAPON CODE')], entry_num+2)) + ' => Rounds: ' + str(current_event[index])
            output.write(string)
        index += 1
    output.write('\n-------------------------------------------\n')
    Close_Output_File(output)
    print()
    
# converts the julian date to gregorian. Takes in the julian date and returns a list [year, month, day] 
# Sample return [1968, 'May', 2]
def Julian_Converter(date):
    #lists to make methods cleaner
    years = [1967, 1968, 1969, 1970]
    months = ['Jan', 'Feb', 'March', 'April', 'May', 'June', 'July', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
    month_length = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    # assigns year based on the first digit
    date = str(date)
    new_date = []
    if(date[0] == '7'):
        new_date.append(years[0])
    if(date[0] == '8'):
        new_date.append(years[1])
    if(date[0] == '9'):
        new_date.append(years[2])
    if(date[0] == '0'):
        new_date.append(years[3])
    
    # sums the number of days in eac month until we are greater than the number represented by the second 
    # and so forth digits
    num_of_days = date[1:]
    day = 1
    count = 0
    for ii in range(0, len(month_length)):
        if(day <= int(num_of_days)):
            day += month_length[ii]
            count += 1
    new_date.append(count - 1)
    
    # subtracts the sum of the days in the months prior to the assigned month and subtracts from the second 
    # and so forth digits to get the gregorian day. It's not a bug it's a feature
    day = int(num_of_days)
    if(day < (365 - month_length[11]) ):
        for ii in range(0, new_date[1]):
            adjustment = month_length[ii]
            if(ii == 2 and new_date[0] == years[1]):
                adjustment += 1
            day = day - adjustment
    else:
        day = day - (365 - month_length[11])
        if(new_date[0] == years[1]):
            day -= 1
    new_date.append(day)
    new_date[1] = months[new_date[1]] #we reassign the month number with the month name after assigning the day so we can do math on it

    return str(new_date[1]) + ' ' + str(new_date[2]) + ', ' + str(new_date[0])

def find(file_lines, key, col_index):
    for i in range(1, len(file_lines)):
        row = file_lines[i][:-1].split(',')
        if row[0] == key:
            return row[col_index]
    return 'NOT FOUND'
            

if __name__ == '__main__':
    main()