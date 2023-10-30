#!/usr/bin/python3
# coding: utf-8

# This script is named "Project4-GCskew.py"
# You can run it in the shell with:
#     python Project4-GCskew.py -g Genome_fastas/fasta_name.fasta -w 100 -n fasta_name

import argparse
from Bio import SeqIO
from Bio.SeqUtils import GC_skew
import pandas as pd
import matplotlib.pyplot as plt

def GCskew_plot():
    """
    Creates a cumulative GC Skew and chromosome position line graph and raw data table from a Pandas dataframe.
    Includes the parser arguments of fasta file input, optional window size, and the name of the organism in the fasta file for future file naming purposes. 
    Saves the data frame as a csv file and saves the line graph as a png. 
    """
    parser = argparse.ArgumentParser(
        description="Calculates the GC skew from a fasta file with an adjustable window size."
    )
    # this parse allows for the input of a fasta file
    parser.add_argument(
        "-g",
        "--genome",
        dest="fastaFile",
        required=True,
        help="Enter the file name of the DNA sequence fasta file here.",
    )
    # this parse allows the user to adjust the window size
    parser.add_argument(
        "-w", "--window_size", dest="WindowSize", help="Enter the window size here."
    )
    # this parse asks the user to input the name of the organism
    parser.add_argument(
        "-n",
        "--Genome_Name",
        dest="Name",
        required=True,
        help="Please enter the name of your organism that this genome belongs to with underscores instead of spaces.",
    )
    args = parser.parse_args()
    # reads the fasta file and saves it as a variable
    genomic_dna = SeqIO.read(args.fastaFile, "fasta")
    # saves the window size that was parsed as a variable, if no window size was specified, defaults to 100
    if args.WindowSize:
        WS = int(args.WindowSize)
    else:
        WS = 100
    # calculates GC skew from the input fasta and window size and saves as a variable
    GCS = GC_skew(genomic_dna.seq, WS)
    # constructs a dataframe with the columns "GC_skew", "GC_skew_cumsum", "Window Size", and "chr_pos"
    GCS_df = pd.DataFrame(GCS, columns=["GC_skew"])
    GCS_df["GC_skew_cumsum"] = GCS_df["GC_skew"].cumsum()
    GCS_df["Window Size"] = WS
    GCS_df["chr_pos"] = GCS_df["Window Size"].cumsum()
    # saves the dataframe, without "Window Size" as a .csv file into the folder "Output_CSVs"
    GCS_df.to_csv(
        "Output_CSVs/" + args.Name + "_GC_Skew.csv",
        columns=["chr_pos", "GC_skew", "GC_skew_cumsum"],
        index=False,
    )
    # creates a matplotlib simple line graph including labels and saves the figure into the folder "Output_Figures"
    plt.plot(GCS_df["chr_pos"], GCS_df["GC_skew_cumsum"], label="GC_skew_cumsum")
    leg = plt.legend()
    plt.title("GC Skew of the " + args.Name + " Genome")
    plt.xlabel(args.Name + " Genome (bp)")
    plt.ylabel("GC Skew")
    plt.savefig(
        "Output_Figures/" + args.Name + "_GC_skew_plot.png",
        dpi=300,
        facecolor="white",
        edgecolor="white",
        orientation="landscape",
        format=None,
        transparent=True,
        bbox_inches=None,
        pad_inches=0.4,
    )
GCskew_plot()
