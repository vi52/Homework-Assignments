#!/usr/bin/python
# coding: utf-8

# This is 3 separate files compiled into one for assignment submission. Each
# comment block is located at the start of a new file.

# This is the start of Pet_class.py
"""
Author: Vicky Hu
Course number and name: CSC 212
Programming assignment: Project 3 Pets (Classes & Objects)
Program description: This program defines the class "Pet", where it creates
    objects that include attributes for the name of the pet, the species of
    the pet, the family type (i.e. spider, cat, etc.) of the pet, and the
    name of the owner of the pet. The class includes an __init__ method; a
    __str__ method that will output all of the information about the pet;
    the mutator methods: set_Name, set_Species, set_FamilyType, and
    set_Owner; as well as the accessor methods: get_Name, get_Species,
    get_FamilyType, and get_Owner.
"""


class Pet:
    # Initialize attributes with variables passed in
    def __init__(self, name, species, family, owner):
        self.__petName = name
        self.__petSpecies = species
        self.__petFamilyType = family
        self.__petOwnerName = owner

    # Define mutator methods
    def set_Name(self, name):
        self.__petName = name

    def set_Species(self, species):
        self.__petSpecies = species

    def set_FamilyType(self, family):
        self.__petFamilyType = family

    def set_Owner(self, owner):
        self.petOwnerName = owner

    # Define accessor methods
    def get_Name(self):
        return self.__petName

    def get_Species(self):
        return self.__petSpecies

    def get_FamilyType(self):
        return self.__petFamilyType

    def get_Owner(self):
        return self.__petOwnerName

    # Print all of the pet's attributes
    def __str__(self):
        return (
            f"Pet's name: "
            + self.__petName
            + "\nPet's species: "
            + self.__petSpecies
            + "\nPet's family type: "
            + self.__petFamilyType
            + "\nPet's owner: "
            + self.__petOwnerName
            + "\n"
        )

# This is the start of pet_test.py
"""
Author: Vicky Hu
Course number and name: CSC 212
Programming assignment: Project 3 Pets (Classes & Objects)
Program description: This program is intended to be used along side the class
    "Pet" that was defined in Pet_class.py and the information in petdata.txt.
    This program includes the functions get_data and main. The function
    get_data acts to read in the information from petdata.txt and create a
    list of lists from the file. The function main calls get_data and creates
    objects for each of the 9 pets.
"""

import Pet_class

def get_data():
    # Open petdata.txt for reading
    infile = open("petdata.txt", "r")
    # Read the contents of the file into a list
    pets = infile.readlines()
    # Close the file
    infile.close()
    # Remove '\n' from each element
    index = 0
    while index < len(pets):
        pets[index] = pets[index].rstrip("\n")
        index += 1
    # Create a 2D list in Pets_list
    Pets_list = []
    for item in pets:
        Pets_list.append(item.split())
    # Return the 2D list
    return Pets_list


def main():
    Pets_list = get_data()
    # Create an object for each of the 9 pets
    Pepper = Pet(
        Pets_list[0][0], Pets_list[0][1], Pets_list[0][2],Pets_list[0][3]
    )
    Ginger = Pet(
        Pets_list[1][0], Pets_list[1][1], Pets_list[1][2], Pets_list[1][3]
    )
    Rainbow = Pet(
        Pets_list[2][0], Pets_list[2][1], Pets_list[2][2], Pets_list[2][3]
    )
    Bi_coloured_rock_snake = Pet(
        Pets_list[3][0], Pets_list[3][1], Pets_list[3][2], Pets_list[3][3]
    )
    Lump = Pet(
        Pets_list[4][0], Pets_list[4][1], Pets_list[4][2], Pets_list[4][3]
    )
    Pikachu = Pet(
        Pets_list[5][0], Pets_list[5][1], Pets_list[5][2], Pets_list[5][3]
    )
    Kaa = Pet(
        Pets_list[6][0], Pets_list[6][1], Pets_list[6][2], Pets_list[6][3]
    )
    Sukeroku = Pet(
        Pets_list[7][0], Pets_list[7][1], Pets_list[7][2], Pets_list[7][3]
    )
    Spyder = Pet(
        Pets_list[8][0], Pets_list[8][1], Pets_list[8][2], Pets_list[8][3]
    )
    # Print the objects
    print(
        f"{Pepper}\n{Ginger}\n{Rainbow}\n{Bi_coloured_rock_snake}\
        \n{Lump}\n{Pikachu}\n{Kaa}\n{Sukeroku}\n{Spyder}"
    )

# This is the start of pet_test2.py
"""
Author: Vicky Hu
Course number and name: CSC 212
Programming assignment: Project 3 Pets (Classes & Objects)
Program description: This program is intended to be used along side the class
    "Pet" that was defined in Pet_class.py and the information in petdata.txt.
    This program is a second version of pet_test.py. It also includes the
    functions get_data and main. The function get_data still acts to read in
    the information from petdata.txt and create a list of lists from the file.
    The function main calls get_data and creates a list of objects for each
    element in the list made in get_data. Then, it prints the name of the pets
    and their corresponding owners for pets that are either snakes or insects.
"""

import Pet_class

def get_data():
    # Open petdata.txt for reading
    infile = open("petdata.txt", "r")
    # Read the contents of the file into a list
    pets = infile.readlines()
    # Close the file
    infile.close()
    # Remove '\n' from each element
    index = 0
    while index < len(pets):
        pets[index] = pets[index].rstrip("\n")
        index += 1
    # Create a 2D list in Pets_list
    Pets_list = []
    for item in pets:
        Pets_list.append(item.split())
    # Return the 2D list
    return Pets_list


def main():
    Pets_list = get_data()
    # Create a list of pet objects
    pets = []
    r = 0
    for row in Pets_list:
        pets.append(
            Pet_class.Pet(
                Pets_list[r][0], Pets_list[r][1],\
                Pets_list[r][2], Pets_list[r][3]
            )
        )
        r += 1
    # Search pets for pets that are of the family type snake or insect
    for item in pets:
        if item.get_FamilyType() == "snake"\
        or item.get_FamilyType() == "insect":
            # Print the pet's name and owner for pets that meet the conditions
            print(
                f"{item.get_Name()} is a pet snake or pet insect. \
                \nThe owner of {item.get_Name()} is: {item.get_Owner()} \n"
            )
