#!/usr/bin/env python
# coding: utf-8


"""
Author: Vicky Hu
Course number and name: CSC 212
Programming assignment: Project 6 Roster & Registration (Linked List)
Program description:
    This program uses the files studentNames21203.txt and
    studentCourses21203.txt to create an alphabetized by last name linked list
    of the students and the courses they are registered for next term. The
    program will output the list of students in order, the list of students
    and their courses, the list of students and their courses after a student
    drops out, and a roster of all the students in the list registered for
    MAT 252.
Design and implementation of this program:
    My program is comprised of two classes and a main function. The first
    class, StudentRec, is comprised of the methods __init__, setName, getName,
    register, setNext, getNext, getRegistered, and __str__. __init__, setName,
    register, and setNext all take a variable that will be assigned to an
    attribute. The methods getName, getNext, and getRegistered all return a
    value.
    The second class, OrderedList, is comprised of the methods __init__,
    isEmpty, add, size, search, and remove.The add, search, and remove methods
    are passed a variable, and the isEmpty, size, and search methods return
    values.
    The main function begins by reading in the studentNames21203.txt file to a
    list, creating node objects from the list and then a linked list object,
    reading in the studentCourses21203.txt file to a dictionary, adding that
    information to the linked list, removing students that hypothetically
    dropped out, and outputting a roster of students taking MAT 252. It is
    designed as the following:
    def main():
        Create empty linked list
        Read in studentNames21203.txt to a list
        Remove '\n' from each element in the list
        Add each name as a node to the linked list
        Output each node of the list in order
        Read in studentCourses21203.txt to a dictionary while removing '\n'
        from each value
        Register students for courses
        Output each node of the list in order
        Remove "Lens,Google"
        Output each node of the list in order
        Remove "Siri,Apple"
        Output each node of the list in order
        Remove "Alexa,Amazon"
        Find and print students taking MAT 252 next term
    This program was created using Jupyter Lab notebooks, Black for Jupyter
    Lab to help with formatting, the lecture notes for linked lists on the CSC
    212 Blackboard page, and Google when encountering issues.
    Jupyter Lab notebooks was able to test the code as it was being written. I
    included several print statements throughout the code during the
    development process to ensure that all the methods are functional and the
    list was being properly created. This program does not work as intended in
    instances such as attempting to use the remove method with an item not in
    the list. It will output an error in such a case.
Reflection:
    I used the code for creating nodes and ordered lists that was available in
    the lecture notes on the CSC 212 Blackboard site to begin this project. I
    then tested each method and had to make slight adjustments (such as
    converting current.getName() to a string) to ensure that each worked.
    Then, I coded the main function by working through each requirement in the
    assignment pdf. My biggest challenges were getting the add method to work
    (which required converting current.getName() to a string) and the search
    function to find the names of the students so I could register them for
    their courses (which was not working because I had added the nodes in
    incorrectly). One adjustment I would like to make would be creating a
    function that would output the contents of the linked list because I
    repeated the same chunk of code in the main function 4 times.
"""

class StudentRec:
    def __init__(self, name):
        self.Name = name
        self.courseSchedule = None
        self.next = None

    def setName(self, name):
        self.Name = name

    def getName(self):
        return self.Name

    def register(self, courses):
        self.courseSchedule = courses

    def setNext(self, newnext):
        self.next = newnext

    def getNext(self):
        return self.next

    def getRegistered(self):
        return self.courseSchedule

    def __str__(self):
        return f"{self.Name} has the course schedule: {self.courseSchedule}"


class OrderedList:
    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head == None

    def add(self, item):
        current = self.head
        previous = None
        stop = False
        while current != None and not stop:
            if str(current.getName()) > str(item):
                stop = True
            else:
                previous = current
                current = current.getNext()
        temp = StudentRec(item)
        if previous == None:
            temp.setNext(self.head)
            self.head = temp
        else:
            temp.setNext(current)
            previous.setNext(temp)

    def size(self):
        current = self.head
        count = 0
        while current != None:
            count = count + 1
            current = current.getNext()
        return count

    def search(self, item):
        current = self.head
        found = False
        stop = False
        while current != None and not found and not stop:
            if str(current.getName()) == str(item):
                found = True
            else:
                if str(current.getName()) > str(item):
                    stop = True
                else:
                    current = current.getNext()
        return current

    def remove(self, item):
        current = self.head
        previous = None
        found = False
        while not found:
            if current.getName() == item:
                found = True
            else:
                previous = current
                current = current.getNext()
        if previous == None:
            self.head = current.getNext()
        else:
            previous.setNext(current.getNext())


def main():
    # Create empty linked list
    linkedList = OrderedList()
    # Open studentNames21203.txt for reading
    infile = open("studentNames21203.txt", "r")
    # Read the contents of the file into a list
    names = infile.readlines()
    # Close the file
    infile.close()
    # Remove '\n' from each element
    index = 0
    while index < len(names):
        names[index] = names[index].rstrip("\n")
        index += 1
    # Add each name as a node to the linked list
    for item in names:
        linkedList.add(item)
    # Output each node of the list in order
    print("These students are in this linked list:")
    current = 1
    node = linkedList.head
    while current <= linkedList.size():
        print(node.getName())
        current += 1
        node = node.getNext()
    print("\n")
    # Open studentCourses21203.txt for reading
    infile = open("studentCourses21203.txt", "r")
    # Read the contents of the file into a dictionary
    courses = {}
    for line in infile:
        x = line.rstrip("\n")
        (key, val) = x.split(" ", 1)
        courses[key] = val
    # Close the file
    infile.close()
    # Register students for courses
    for k in courses:
        linkedList.search(k).register(courses[k])
    # Output each node of the list in order
    print("These are the students and their courses in this linked list:")
    current = 1
    node = linkedList.head
    while current <= linkedList.size():
        print(node)
        current += 1
        node = node.getNext()
    print("\n")
    # Remove "Lens,Google"
    linkedList.remove("Lens,Google")
    # Output each node of the list in order
    print(
        "These are the students and their courses in this linked list "
        'after "Lens, Google" dropped the class:'
    )
    current = 1
    node = linkedList.head
    while current <= linkedList.size():
        print(node)
        current += 1
        node = node.getNext()
    print("\n")
    # Remove "Siri,Apple"
    linkedList.remove("Siri,Apple")
    # Output each node of the list in order
    print(
        "These are the students and their courses in this linked list "
        'after "Siri, Apple" dropped the class:'
    )
    current = 1
    node = linkedList.head
    while current <= linkedList.size():
        print(node)
        current += 1
        node = node.getNext()
    print("\n")
    # Remove "Alexa,Amazon"
    linkedList.remove("Alexa,Amazon")
    # Output each node of the list in order
    print(
        "These are the students and their courses in this linked list "
        'after "Alexa, Amazon" dropped the class:'
    )
    current = 1
    node = linkedList.head
    while current <= linkedList.size():
        print(node)
        current += 1
        node = node.getNext()
    print("\n")
    # Find and print students taking MAT 252 next term
    print("These students are registered for MAT 252 next term:")
    node = linkedList.head
    current = 1
    course = "MAT252"
    while current <= linkedList.size():
        if str(course in str(node.getRegistered())) == str(True):
            print(node.getName())
        node = node.getNext()
        current += 1


main()
