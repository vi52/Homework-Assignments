#!/usr/bin/python
# coding: utf-8


"""
Author: Vicky Hu
Course number and name: CSC 212
Programming assignment: Project 5 Simulation (Queue)
Program description:
    This program is a simulation of a 60 minute time period of a bank queue.
    There is one teller and a queue of customers that potentially enter on
    every minute. An average of the wait and service times are calculated.
Design and implementation of this program:
    This program is comprised of two classes and one main function.
    The first class is the Queue class which is comprised of the __init__,
    isEmpty, enqueue, dequeue, and size methods. Of those, enqueue is the only
    one that accepts an argument. isEmpty, dequeue, and size all return
    values.
    The second class is the Customer class. It has an __init__ method;
    set_waitTime and set_serviceTime methods; and get_name, get_arrival,
    get_waitTime, and get_serviceTime methods.
    The main function does not pass or return any parameters but creates one
    object using the Queue class and several objects using the Customer class.
    • Code Design
    This program incorporates objects as well as lists.
    The main function is written as follows:
        set time to 0 minutes
        set teller to free
        customer counter begins at 1
        create bank queue object
        create wait time, service time, and remaining wait time empty lists
        teller is free at 0 minutes
        while time < 60 minutes:
            select 0 or 1 randomnly
            if 1 is selected:
                create customer object
                add customer to queue
            if teller is free and people are in the queue:
                take customer out of queue
                log customer's wait time
                randomnly generate the service time of the customer
                set teller to in-service
                calculate the time until the teller will be available
            if the time == when teller will be available:
                log wait time and service time in lists
                print customer's information
                set teller to available
            time passes by 1 minute
        calculate average wait and service times
        print out statistically information
        if there are still people in queue:
            calculate and add to list the wait time of everyone left in queue
        calculate average wait time of everyone left in queue
        print statistical information
    This program was created using Jupyter Lab notebooks, Black for Jupyter
    Lab to help with formatting, the lecture notes for queues on the CSC 212
    Blackboard page, and Google when encountering slight issues.
    • Testing
    Jupyter Lab notebooks was able to test the code as it was being written. I
    included several print statements throughout the code to ensure that
    customers were properly added to the queue, the right customers were
    being referred to, etc. This program does not account for bugs such as
    queues with negative values.
Reflection:
    The implementations process was non-linear. The code for the Queue class
    was taken from the CSC 212 Blackboard page. Then, I began writing main
    according to the requirements on the assignment directions. The Customer
    class was added in when I saw its necessity in the assignment directions.
    I had a slight issue with setting the teller as "free/available for
    service." I was very sick and out-of-it with cold medicine when I wrote
    this, so the thinking through the code portion was much more challenging.
    In the end, I managed to troubleshoot the bank teller's status and have
    everything work without any known major issues.
Questions for future improvements:
    Can you come up with a more sophisticated random number generation so that
    you can control the pace at which customers arrive?
        I could create a list with varying amounts of 0's and/or 1's to
        control the amount of customers that arrive. To have less customers
        arrive, there would be more 0's in the list and vice versa. The list
        would be randomnly chosen from to determine if a customer arrives in
        that minute.
    Think through if the bank is to hire another teller (one queue leading to
    2 teller windows), how would that change your program?
        That would change my program by first requiring me to set a variable
        for the second teller, then having to keep track of 2 service times. I
        would also need to create statements that adjust the second teller's
        status.
"""


import random
from statistics import mean

class Queue:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def enqueue(self, item):
        self.items.insert(0, item)

    def dequeue(self):
        return self.items.pop()

    def size(self):
        return len(self.items)


class Customer:
    def __init__(self, name, time):
        self.name = name
        self.time = time

    def set_waitTime(self, time):
        self.waitTime = time

    def set_serviceTime(self, time):
        self.serviceTime = time

    def get_name(self):
        return self.name

    def get_arrival(self):
        return self.time

    def get_waitTime(self):
        return self.waitTime

    def get_serviceTime(self):
        return self.serviceTime


def main():
    # Keeps track of minutes
    time = 0
    # Status of teller; 0 = free & 1 = in service
    teller = 0
    # Number of customers since the hour begun
    customer = 1
    bank_queue = Queue()
    # Lists
    waittime_list = []
    servicetime_list = []
    remainingWait_list = []
    free = 0
    while time < 60:
        # Determines if a customer enters; 0 = no & 1 = yes
        value = random.randint(0, 1)
        # If a customer enters, create a customer object & add to queue
        if value == 1:
            name = "Customer" + str(customer)
            obj = Customer(name, time)
            bank_queue.enqueue(obj)
            customer += 1
        # If teller is free & people are waiting
        if teller == 0 and bank_queue.size() > 0:
            # Customer is taken out of queue and serviced
            current_cust = bank_queue.dequeue()
            # Wait time is calculated
            current_cust.set_waitTime(
                int(time) - int(current_cust.get_arrival())
                )
            # Service time is selected
            service_time = random.randint(1, 10)
            current_cust.set_serviceTime(service_time)
            # Teller is set to in-service
            teller = 1
            # Calculate time for teller to be free
            free = time + service_time
        # If the teller is finishing servicing a customer
        if time == free and time != 0:
            # Add wait and service times to a list
            waittime_list.append(current_cust.get_waitTime())
            servicetime_list.append(current_cust.get_serviceTime())
            # Ouput customer's information
            print("The customer that was just serviced was: " +
                current_cust.get_name() + "\n" + "Wait time:",
                str(current_cust.get_waitTime()) + " minutes. \n" +
                "Service time: " + str(current_cust.get_serviceTime())
                + " minutes")
            # Set the teller to free
            teller = 0
        # Continue to next minute
        time += 1
    # Calculate and output averages of the past hour
    wt_avg = mean(waittime_list)
    st_avg = mean(servicetime_list)
    print("After 60 minutes had passed, the average wait time was:",
          round(wt_avg,2), "minutes. \n" "The average service time was:",
          round(st_avg,2), "minutes. \n" "There are still",
          bank_queue.size(), "customers waiting in line.")
    # If there are still people waiting in line after 60 minutes
    while bank_queue.size() > 0:
        # Calculate wait time till 60 minutes and add to list
        remaining_cust = bank_queue.dequeue()
        remaining_cust.set_waitTime(
            int(time) - int(remaining_cust.get_arrival())
            )
        remainingWait_list.append(remaining_cust.get_waitTime())
    # Calculate average wait time of remaining customers and print
    rwt_avg = mean(remainingWait_list)
    print("The average wait time of the remaining customers is:",
        round(rwt_avg,2), "minutes.")

main()
