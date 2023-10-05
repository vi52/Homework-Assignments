#!/usr/bin/env python
# coding: utf-8


"""
Author: Vicky Hu
Course number and name: CSC 212
Programming assignment: Project 2 States and Capitals (Dictionaries)
Program description:
    This program is an educational game intended for users to learn the
    capitals of U.S. states. This exercise demonstrated the use of
    dictionaries through creating key value pairs of capitals and
    corresponding states. Dictionary methods values(), items(), and keys()
    were used. Looping through a dictionary was also demonstrated.
Design and implementation of this program:
    This program uses 5 functions: game_info(), get_data(), phase_one(),
    phase_two(), and main(). Of the functions, get_data() returns a dictionary
    it creates, phase_one() uses that dictionary, and phase_two() uses 2
    different lists as parameters and returns a variable. This program uses 2
    data structurs: a dictionary and a few lists.
    This program runs as follows:
        import random
        print a welcome statement and ask the user to hit enter
        read a text file and create a dictionary from the file
        ask the user to input states and print the corresponding capitals
        move on when given user input to move on
        output a state and ask the user to enter the capital for 5 rounds
        print the scorecard and either repeat at user-input states, outputting
            states, or stop
    This program runs on the assumption that user input is exactly as
    directed. Further, user-input capitals for Phase 2 are only marked correct
    if inputted with proper capitalization and spelling. This program was
    created and tested using Jupyter Lab notebooks. When cells had errors
    running, Starting Out With Python by Tony Gaddis was referenced to help
    troubleshoot those errors.
    This program appears to be able to run without giving any errors. It will
    run on Python IDLE in versions 3.6 and later due to f string formatting
    that was not recognized in earlier versions.
    The code of this program was formatted with the help of Black (a python
    formatter) for Jupyter Lab notebooks.
Reflection:
    The creation of this program was a very linear process. The functions were
    all written in order with the exceptions of game_info() which came last as
    a final touch, and main() which was written concurrently with the other
    functions. The first issue that was encountered was the creation of the
    dictionary. I don't believe the way I ended up doing it (by splitting a
    list into two lists) was the way I was supposed to do it, but I found it
    to be the easiest method. Other problems I encountered was in writing the
    loops. Those took a bit of trial and error to determine the best way to
    write them. The biggest error I had was getting the loop in main() to work
    correctly, but all that required was converting
        choice = phase_two(States_list, Capitals_list)
    to
        choice = str(phase_two(States_list, Capitals_list))
    Overall, I did not find this assignment challenging and I did not have any
    significant revisions.
"""

import random


def game_info():
    print(
        """Welcome to the States and Capitals game!
This is an educational game to teach you the capitals of U.S. states.
This game comes in two phases:
    1. Phase 1 is the practice phase.
       We will tell you the capital of the state you enter.
    2. Phase 2 is the quizlet.
       You have to tell us the capital of the state we ask you.
By the way, capitalization and spelling counts.
Good luck and have fun!"""
    )
    input("Press enter to continue.")


def get_data():
    """
    This function opens "capitals of states.txt" for reading.
    The contents of the file are added to a list and exonerous '\n's are
    removed.
    Then capitals and their corresponding states are separated into separate
    elements then separate lists.
    A dictionary is created with a state capital as the key and the
    corresponding state as the value. This dictionary is returned.
    """
    # Open capitals of states.txt for reading
    infile = open("capitals of states.txt", "r")
    # Read the contents of the file into a list
    CapitalState_list = infile.readlines()
    # Close the file
    infile.close()
    # Remove '\n' from each element
    index = 0
    while index < len(CapitalState_list):
        CapitalState_list[index] = CapitalState_list[index].rstrip("\n")
        index += 1
    # Create an empty list
    CSseparated_list = []
    # Split capitals and states into separate elements
    for item in CapitalState_list:
        CSseparated_list += item.split(", ")
    # Move capitals and states into their own lists
    Capitals = CSseparated_list[0::2]
    States = CSseparated_list[1::2]
    # Create an empty dictionary
    CapitalState_dict = dict()
    # Define a counter, i
    i = 0
    # Create a dictionary with capitals as the key and state as the value
    for city in Capitals:
        CapitalState_dict[city] = States[i]
        i += 1
    # Return the dictionary
    return CapitalState_dict


def phase_one(CSdict):
    """
    This function creates "Phase 1" of the game.
    In Phase 1, users input a state and are given the corresponding capital.
    This function uses the dictionary created in getdata() as the parameter.
    This function uses a while loop to continuously ask for a state.
    If users input "Exit", they will exit the loop.
    """
    state = input("Please enter a U.S. state:")
    # Create a loop, with an input of "Exit" stopping the loop
    while state != "Exit":
        # If the user input is a state, ouput the capital
        if state in CSdict.values():
            for k, v in CSdict.items():
                if v == state:
                    print(k)
            # Ask for the input again to continue looping
            state = input("Please enter a U.S. state:")
        # If the input is not a state, ask for it to be re-entered
        else:
            state = input(
                "Please enter a valid state or type 'Exit' "
                "to move onto Phase 2."
            )


def phase_two(States, Capitals):
    """
    This function defines "Phase 2" of the States and Capitals game.
    Here, users are randomly given a state and asked for the capital.
    This is repeated for 5 random states and users are given their scores at
    the end.
    This function uses the list of states and list of capitals created in
    main() as parameters. It returns a user input variable.
    This function uses a loop to continue the game for 5 rounds.
    After 5 rounds, users have the options to play again, stop playing, or
    return to Phase 1.
    """
    # Set counters for correct and incorrect guesses
    win = 0
    lose = 0
    # Create a loop that limits game to 5 guesses
    while win + lose < 5:
        # Pick a random number
        randomIndex = random.randint(0, 49)
        # Ask for user to guess the capital of the random state
        guess = input(f"What is the capital of {States[randomIndex]}?" )
        # If the guess is correct, add 1 to the win counter and print correct
        if guess == Capitals[randomIndex]:
            win += 1
            print("Correct!")
        # Otherwise add 1 to the lose counter and print the correct capital
        else:
            lose += 1
            print(f"Incorrect! The capital is: {Capitals[randomIndex]}.")
    # After 5 rounds, print the game score and ask for user input
    if win + lose >= 5:
        print(f"You guessed {win} capitals correctly and {lose} "
        "capitals incorrectly.")
        choice = input(
            "Would you like to play again? Enter 'Y', 'N', or "
            "'Phase 1' to return to the practice phase."
        )
        # Return user input
        return choice


def main():
    game_info()
    CSdict = get_data()
    phase_one(CSdict)
    # Separate states and capitals into separate lists
    States_list = list(CSdict.values())
    Capitals_list = list(CSdict.keys())
    choice = str(phase_two(States_list, Capitals_list))
    # Create a loop that stops if the user inputs "N"
    while choice != "N":
        # If user wants to play again, re-execute phase_two()
        if choice == "Y":
            choice = phase_two(States_list, Capitals_list)
        # To return to Phase 1, re-execute phase_one() then phase_two()
        elif choice == "Phase 1":
            phase_one(CSdict)
            choice = str(phase_two(States_list, Capitals_list))
        # Allows the user to re-attempt their selection
        else:
            choice = input("Please enter a valid selection.")
    # Print a goodbye outside the loop (meaning user has chosen "N")
    print("Thanks for playing! Play again soon!")


# Execute the main function
main()
