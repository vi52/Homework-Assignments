#!/usr/bin/python3
# coding: utf-8

# This script is named "GCpercent.py"
# You can run it in the shell with:
# 	python GCpercent.py -f genomic_dna.fasta

import argparse
from Bio import SeqIO
""" A calculator that determines the amount of "G's" and "C's" present out of the total amount of nucleotides 
in a given DNA sequence from a fasta file. The fasta file cannot be a multifasta file. 
"""
parser = argparse.ArgumentParser(
    description="Calculates the GC content from a fasta file."
)
parser.add_argument(
    '-f', 
    '--fasta',
    dest="fastaFile",
    required=True,
    help="Enter the file name of the DNA sequence fasta file here.",
)
args = parser.parse_args()
genomic_dna = SeqIO.read(args.fastaFile, "fasta")
if args.fastaFile:
    genomic_data = genomic_dna.seq
    numG = genomic_data.count("G")
    numC = genomic_data.count("C")
    numA = genomic_data.count("A")
    numT = genomic_data.count("T")
    GC = (numG + numC) / (numG + numC + numA + numT)
    print(GC)
