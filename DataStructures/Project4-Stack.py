#!/usr/bin/python
# coding: utf-8

"""
Author: Vicky Hu
Course number and name: CSC 212
Programming assignment: Project 4 Postfix notation evaluation (Stack)
Program description:
    This program is a program that will take a single input and calculate the
    value of the expression if it is in valid postfix notation. If it is
    invalid, the user will be notified instead.
Design and implementation of this program:
    The program is comprised of a stack data structure that was defined
    through a class definition as well as a main function. Neither of the
    stack nor the main function require preconditions and do not return
    postconditions either.
    The stack has 6 methods.
        The first is an initiate method that defines the attribute self.items as
        an empty list.
        The second, isEmpty, returns a True or False if self.items is an empty
        list or not.
        The third, push, adds an item to the end of the stack.
        The fourth, pop, removes the item at the top of the stack.
        The fifth, peek, returns the item at the top of the stack.
        The sixth, size, returns the length/size of the stack.
    The function main is structured as follows:
        ask for user input
        for each token in the input,
            push the token into the stack if it is a number
            print an error if the token is not a number and there are less
            than two items in the stack
            calculate the expression if the token is an operator and there is
            at least two items in the stack
            print an error if none of the above parameters are met
        if the stack has one item left in it after running through all the
        tokens,
            print the item and claim that the input was valid
    otherwise, print that the input was invalid
    This program will be able to catch invalid inputs, but it only works on a
    one-run basis, so for each input, it must be rerun again. The valid input
    is only proper postfix notation. Also, it will not be able to tell what
    exactly makes the input invalid aside from instances of invalid
    characters.
    This program was created using Jupyter Lab notebooks, Black for Jupyter
    Lab to help with formatting, the lecture notes for stacks on the CSC 212
    Blackboard page, and Google when encountering slight issues.
    Jupyter Lab notebooks was able to test the code as it was being written
    and a final test was done by running the file through the terminal. I
    began testing by using "32*" as the input, then "531-*2+", then "33p",
    and other inputs such as "333+" which I know is not valid postfix
    notation.
Reflection:
    The implementation process was very simple. I began by taking the class
    Stack from the CSC 212 Blackboard page, then created main. I only had to
    Google search in two instances which were solved by using the methods
    .isnumeric() and eval(). Once main was completed, I went back to the
    for loop and added elifs to prevent places where code errors could occur
    and instead print that the input was invalid.
"""

class Stack:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items) - 1]

    def size(self):
        return len(self.items)

def main():
    s = Stack()
    # Take user input
    notation = input("Please submit an equation in postfix notation.")
    # Evaluate each token one by one
    for item in notation:
        # Push the token if it is a number
        if item.isnumeric() == True:
            s.push(item)
        # Print an error for an operator with less than 2 items in the stack
        elif s.size() < 2:
            print("Your expression is invalid. You have too many operators.")
            s.push(item)
        # Calculate given an operator & at least 2 items in the stack
        elif item == "/" or item == "+" or item == "-" or item == "*":
            second_operand = s.pop()
            first_operand = s.pop()
            s.push(str(eval(first_operand + item + second_operand)))
        # Print an error for an invalid character
        else:
            print('The character "' + item + '" is invalid.')
    # Determine the validity by the amount of items left in the stack
    if s.size() == 1:
        print("Your expression is valid! The answer to the equation is: ",
            s.peek())
    else:
        print(
            "Your expression is invalid. Please submit a valid expression."
                )


main()
