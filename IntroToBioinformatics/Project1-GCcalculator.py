def GCcontent (dna) : 
    """ A calculator that determines the amount of "G's" and "C's" present out of the total amount of characters 
    in a given DNA sequence. Input is converted to uppercase and spaces are removed. If the modified input sequence
    is the same length as the total amount of "A's" "T's" "G's" and "C's", then the GC  content rounded to the 
    hundredths place is returned. If it is not, then a message asking the user to resubmit is returned.
    =============
    Unit testing
    =============
    
    >>> GCcontent("AATTGGCCGGatccgt")
    The %GC is: 0.56
    >>> GCcontent("AATCgc Cgt A")
    The %GC is: 0.5
    >>> GCcontent("AATGCTACFDGTAccsaaaggtc cy cctg")
    The input sequence contains characters other than {A,T,C,G}. Please correct the input and resubmit.
    """
    dna = dna.upper()
    dna = dna.replace(" ", "")
    numG = dna.count("G")
    numC = dna.count("C")
    numA = dna.count("A")
    numT = dna.count("T")
    x = (numG + numC) / (numG + numC + numA + numT)
    if len(dna) == (numG + numC + numA + numT):
        print("The %GC is:", round(x, 2)) 
    else:
        print("The input sequence contains characters other than {A,T,C,G}. Please correct the input and resubmit.")
