import csv
import os

def main():
    header_names      = ['SUB-UNIT UIC', 'SUB-UNIT NAME', 'MAJOR COMMAND UIC', 'MAJOR COMMAND NAME', 
                         'WEAPON CODE', 'WEAPON DENSITY', 'MISSION CODE', 'INTENSITY CODE', 'TERRAIN CODE',
                         'TARGET FIRE', 'WEATHER CODE', 'DAY-NIGHT CODE', 'NOT USED', 
                         'JULIAN DATE OF ACTION', 'ROUND TYPE 1', 'ROUND TYPE 2', 'ROUND TYPE 3', 
                         'ROUND TYPE 4', 'ROUND TYPE 5', 'ROUND TYPE 6', 'ROUND TYPE 7', 'ROUND 8', 'ROUND 9']
    indices           = [0, 5, 20, 25, 40, 42, 46, 47, 48, 49, 50, 51, 52,
                         62, 66, 72, 78, 84, 90, 96, 102, 108, 114, 120]
    mission_types     = ['RECON IN FORCE', 'CLEAR AND SECURE', 'CORDON AND SEARCH', 'SECURITY', 
                        'BASE CAMP DEFENSE', 'NOT UNDER ATTACK', 'TRAINING', 'LOSS']
    intensity_types   = ['HEAVY', 'MODERATE', 'LIGHT', 'INACTIVE', 'LOSS']
    terrain_types     = ['JUNGLE', 'OPEN', 'FOREST/PLANTATIONS', 'MARSH/RICE PADDY', 
                         'HIGH GRASS', 'MOUNTAINOUS', 'CITY/VILLAGE', 'GULLIES', 'LOSS']
    target_fire_types = ['CONFIRMED TGTS', 'ACQURED TGTS', 'COUNTERBATTERY TGTS', 'PREPERATION TGTS',
                         'ARVN SUPPORT TGTS', 'INTERDICTION', 'SPECIAL PURPOSE TGTS', 'OTHER', 'NA/LOSS']
    weather_types     = ['CLEAR', 'RAIN', 'FOG', 'OVERCAST', 'NA', 'LOSS']
    day_night_types   = ['DAYLIGHT', 'DARKNESS', 'NA', 'LOSS']

    with open('Given Assignment Files\\RG338.COLEDV.AM68', 'r') as read_file:
        file_data = read_file.readlines()

        Sub_Unit(header_names, file_data)
        Major_UIC(header_names, file_data)
        Major_Name(header_names, file_data)
        Cleaned(header_names, indices, file_data)
        Print_Stats()
        Activity_Codes('CSV Files\\COLEDV_Mission_Codes.csv', mission_types)
        Activity_Codes('CSV Files\\COLEDV_Intensity_Codes.csv', intensity_types)
        Activity_Codes('CSV Files\\COLEDV_Terrain_Codes.csv', terrain_types)
        Activity_Codes('CSV Files\\COLEDV_Target_Fire_Codes.csv', target_fire_types)
        Activity_Codes('CSV Files\\COLEDV_Weather_Codes.csv', weather_types)
        Activity_Codes('CSV Files\\COLEDV_Day_Night_Codes.csv', day_night_types)
        Weapon_Codes()


def Sub_Unit(header_names, file_data):
    with open('CSV Files\\COLEDV_Sub_Unit.csv', mode='w', newline='') as write_to_file:
            file_writer = csv.writer(write_to_file, delimiter=',')
            
            file_writer.writerow([header_names[0]] + [header_names[1]])

            # Filters for unique sub-unit uic's and makes a 
            # relational table to its sub-unit name
            current = ''
            for i in range(0, len(file_data)):
                prev = current
                current = file_data[i][0:5].strip()
                if current != prev:
                    file_writer.writerow([current] + [file_data[i][5:20].strip()])


def Major_UIC(header_names, file_data):
    with open('CSV Files\\COLEDV_Major_UIC.csv', mode='w', newline='') as write_to_file:
            file_writer = csv.writer(write_to_file, delimiter=',')
            
            file_writer.writerow(['ID Number'] + [header_names[2]])

            # Filters for unique major_uic's and 
            # then makes a table with an id number relating to the uic
            prev = [];
            for i in range(0, len(file_data)):
                current = file_data[i][20:25].strip()
                if  current not in prev:
                    prev.append(current)
                    index = len(prev)
                    if (index < 10):
                        index = '0' + str(index)
                    file_writer.writerow([index] + [current])


def Major_Name(header_names, file_data):
    with open('CSV Files\\COLEDV_Major_Name.csv', mode='w', newline='') as write_to_file:
            file_writer = csv.writer(write_to_file, delimiter=',')
            
            file_writer.writerow(['ID Number'] + [header_names[3]])

            # Filters for unique major_name's and 
            # then makes a table with an id number relating to the name
            prev = [];
            for i in range(0, len(file_data)):
                current = file_data[i][25:40].strip()
                if  current not in prev:
                    prev.append(current)
                    index = len(prev)
                    if (index < 10):
                        index = '0' + str(index)
                    file_writer.writerow([index] + [current])


def Cleaned(header_names, indices, file_data):
    with open('CSV Files\\COLEDV_Major_UIC.csv', mode='r', newline='') as read_uic_file:
        major_uic_ids = read_uic_file.readlines()
        
        with open('CSV Files\\COLEDV_Major_Name.csv', mode='r', newline='') as read_name_file:
            major_name_ids = read_name_file.readlines()

            with open('CSV Files\\COLEDV_Cleaned.csv', mode='w', newline='') as write_to_file:
                file_writer = csv.writer(write_to_file, delimiter=',')

                # We skip Sub_Unit Name and Not Used Columns
                headers = []
                i = 0
                while i in range(0, len(header_names)):
                    if header_names[i] == 'SUB-UNIT NAME' or header_names[i] == 'NOT USED':
                        i += 1
                    headers.append(header_names[i])
                    i += 1
                file_writer.writerow(headers)

                for i in range(0, len(file_data)):
                    data = []
                    j = 0
                    while j in range(0, len(indices) - 1):
                        
                        # If we get indices 5 or 52, it is the 'sub_unit_names' and 'not used' categories,
                        # so we skip these two.  See header loop above for more clarification.
                        if indices[j] == 5 or indices[j] == 52:
                            j += 1

                        # current selection is the data from one row with the columns being
                        # the intervals from the 177.1DP
                        current_section = file_data[i][indices[j]:indices[j+1]].strip()
                        current_section = current_section.lstrip('0')

                        # If we get index 20, it is the major_uic's, we then replace with their ids
                        if indices[j] == 20:
                            for k in range(1,len(major_uic_ids)):
                                if major_uic_ids[k][3:].strip() == current_section:
                                    current_section = major_uic_ids[k][0:2].strip()
                        
                        # If we get index 25, it is the major_names, we then replace with their ids
                        if indices[j] == 25:
                            for k in range(1,len(major_name_ids)):
                                if major_name_ids[k][3:].strip() == current_section:
                                    current_section = major_name_ids[k][0:2].strip()
                        
                        data.append(current_section)
                        j += 1
                    file_writer.writerow(data)


def Activity_Codes(file_name, types):
    with open(file_name, mode='w', newline='') as write_to_file:
        file_writer = csv.writer(write_to_file, delimiter=',')
        file_writer.writerow(['Activity ID'] + ['Activity Type'])
        for i in range(0,len(types)):
            if types[i] == 'LOSS':
                file_writer.writerow([9] + [types[i]])
            else:
                file_writer.writerow([i+1] + [types[i]])

def Weapon_Codes():

    with open('CSV Files\\COLEDV_Weapon_Codes.csv', mode='w', newline='') as write_to_file:
        file_writer = csv.writer(write_to_file, delimiter=',')
        file_writer.writerow(['Weapon Code'] + ['Weapon Name'] + ['Type 1'] + ['Type 2'] + 
                             ['Type 3'] + ['Type 4'] + ['Type 5'] + ['Type 6'] + ['Type 7'] + 
                             ['Type 8'] + ['Type 9'])

        file_writer.writerow(['01'] + ['8in'] + ['HE'] + ['M404FC'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['02'] + ['175mm'] + ['HE'] + [] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['03'] + ['155mm'] + ['HE'] + ['ILL'] + ['SMK/WP'] + ['M449'] + 
                             ['FCXM-631'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['04'] + ['105mm'] + ['HE'] + ['ILL'] + ['SMK-WP'] + ['APERS'] + 
                             ['M546'] + ['XM-629'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['05'] + ['90mm TANK/RR'] + ['HEAT'] + ['HE-T'] + ['APERS'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['06'] + ['107mm MTR'] + ['HE'] + ['ILL'] + ['SMK/WP'] + ['XM-630'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['07'] + ['81 MM MTR'] + ['HE'] + ['ILL'] + ['SMK/WP'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['08'] + ['106mm'] + ['HE'] + ['HEAT'] + ['APERS'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['09'] + ['20mm VULCAN'] + ['ALL'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['10'] + ['M-42'] + ['HEIT'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['11'] + ['M-79'] + ['HE'] + ['MULTI'] + ['M386'] + ['FCM1397'] + 
                             ['FCXM51E1'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['12'] + ['M-5'] + ['HE'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['13'] + ['2.75 ROCKET'] + ['HE'] + ['WP'] + ['ALL CLR'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['14'] + ['50 CAL MG'] + ['ALL'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['15'] + ['7.62 MG'] + ['ALL'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['16'] + ['7.62 MINIGUN'] + ['ALL'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['17'] + ['7.62 RIFLE'] + ['ALL'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['18'] + ['5.56 RIFLE'] + ['ALL'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['19'] + ['GRENADE FRAG'] + ['ALL'] + ['CLRM26A1'] + ['M26A2'] + ['M33FC'] + 
                             ['M7A3'] + ['M54'] + ['M25A2'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['20'] + ['66mm ROCKET'] + ['HEAT'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['21'] + ['FLARE'] + ['M24'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['22'] + ['MINE'] + ['M18A1'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['23'] + ['CS'] + ['158/159'] + ['E8LCHR'] + ['CS-1'] + ['CS-2'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
        file_writer.writerow(['24'] + ['THICKENER BULK'] + ['LBS'] + ['N/A'] + ['N/A'] + ['N/A'] + 
                             ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'] + ['N/A'])
                             

def Print_Stats():
    original_size = os.stat('Given Assignment Files\\RG338.COLEDV.AM68').st_size / 10**6
    cleaned_size = os.stat('CSV Files\\COLEDV_Cleaned.csv').st_size / 10**6
    print('Original File Size: ', round(original_size,4), ' MB')
    print('Cleaned File Size: ', round(cleaned_size,4), ' MB')
    print('Memory Saved: ', round(original_size - cleaned_size,4), ' MB')
    print('% Memory Saved: ', round((original_size - cleaned_size) * 100 / original_size, 4), '%')


if __name__ == '__main__':
    main()