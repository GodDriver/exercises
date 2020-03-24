def secure_container():
    """
    How many different passwords within the range given in your puzzle input meet these
    criteria?
    How many different passwords within the range given in your puzzle input meet all
    of the criteria?
    """
    
    start, finish = 172851, 675869
    
    different_passwords = 0
    different_passwords_part_two = 0

    for password in range(start, finish + 1):
        password = str(password)
        quantity = 0
        never_decrease = 0
        lst = []
        for num in password:
            count = password.count(num)
            lst.append(count)
        for i in range(len(password) - 1):
            if password[i + 1] == password[i]:
                quantity += 1
            if password[i + 1] < password[i]:
                never_decrease += 1
        if quantity > 0 and never_decrease == 0:
            different_passwords += 1
            if 2 in lst:
                different_passwords_part_two += 1
    print(f"Different passwords are {different_passwords}.")
    print(f"Different passwords in Part Two are {different_passwords_part_two}.")
secure_container()
