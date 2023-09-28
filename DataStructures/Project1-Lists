# !/usr/bin/python3

# This script was written by Vicky Hu for Project 1 of CSC 212-03 during the Spring 2023 semester.
# The goal of this project is to exercise lists in order to:
#     1. Read input from a text file
#     2. Use functions and pass lists between them
#     3. Effectively use list methods and, in this case, report the years with the largest and smallest population increase
# This script uses the text file "USPopulation.txt" which contains US population data from 1950 to 1990 in thousands.
# It ouputs the contents of USPopulation.txt as a list, the annual population increase as a list, the data for the largest
# population increase including years and population when occurred, and the data for the smallest population increase.


def getdata():
    """This function opens USPopulation.txt for reading.
    The contents of the file are added to a list for use and exonerous '\n's are removed.
    """
    # Open USPopulation.txt for reading
    infile = open("USPopulation.txt", "r")
    # Read the contents of the file into a list
    population = infile.readlines()
    # Close the file
    infile.close()
    # Remove '\n' from each element
    index = 0
    while index < len(population):
        population[index] = population[index].rstrip("\n")
        index += 1
    # Return the list population
    return population


def putdata(List):
    """This function prints the data that is passed to it."""
    # Prints the list passed to it
    print(List)


def annual_incr(List):
    """This function calculates the annual increase in population using the list generated in the getdata() function.
    The annual increase in population is stored as a list for further use.
    """
    # Create an empty list
    annual_increase = []
    # Append annual increase values into the list
    for i in range(len(List) - 1):
        annual_increase.append(int(List[i + 1]) - int(List[i]))
    # Return annual_increase list
    return annual_increase


def main():
    """This is the main function. It calls upon getdata(), putdata(), and annual_incr().
    It outputs the lists generated in getdata() and annual_incr()
    and also calculates and ouputs the years and populations where the largest and smallest annual population increases took place.
    """
    # Calls getdata() and assigns returned list to a variable
    List = getdata()
    # Passes List from getdata() to putdata() where it's printed
    print("The US population, in thousands, from 1950 to 1990 is:")
    putdata(List)
    # Calls annual_incr() and assigns the returned list to a variable
    annual_increase = annual_incr(List)
    # Prints the annual_increase list
    print("The annual increase, in thousands, from 1950 to 1990 is:")
    putdata(annual_increase)
    for i in range(len(List) - 1):
        # Determine where the highest population increase occurred in the list of populations
        if int(List[i + 1]) - int(List[i]) == max(annual_increase):
            # Print highest population increase data including years and populations it took place
            print(
                f"The highest population increase was {max(annual_increase)} in the years {1950 + i} to {1951 + i}. The population increased from {List[i]} to {List[i + 1]}."
            )
        # Determine where the smallest population increase occurred in the list of populations
        elif int(List[i + 1]) - int(List[i]) == min(annual_increase):
            # Print smallest population increase data including years and populations it took place
            print(
                f"The smallest population increase was {min(annual_increase)} in the years {1950 + i} to {1951 + i}. The population increased from {List[i]} to {List[i + 1]}."
            )
        # If the data does not equal the highest or smallest population increases, do not do anything and continue the loop


# Call the main function
main()
