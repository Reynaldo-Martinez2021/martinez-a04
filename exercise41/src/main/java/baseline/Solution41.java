package baseline;

import java.io.FileNotFoundException;

public class Solution41 {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     *
     * Problem: Name Sorter
     * Read in the exercise41 input.txt file and sort the list alphabetically
     * Make sure when creating an array list use List<String> for polymorphism aspects
     * Print the sort list to a file called 'exercise41_output.txt'
     *
     * Example Output:
     * Total of 7 names
     * -----------------
     * Johnson, Jim
     * Jones, Aaron
     * Jones, Chris
     * Ling, Mai
     * Swift, Geoffrey
     * Xiong, Fong
     * Zarnecki, Sabrina
     *
     * Constraints: don't hard code the number of names
     *
     * To figure out the number of names you can loop through the text file to see
     * how many \n's there are
     */

    public static void main(String[] args){
        //create an application of SortNames
        SortNames application = new SortNames();
        //call the scanInputFile inside try catch
        try {
            application.scanInputFile();
            //catch the fileNotFoundException and print reason
        } catch (FileNotFoundException e) {
            System.out.print("Could not find exercise41_input.txt");
        }
        //call the printToOutputFile within try catch block
        try {
            application.printToOutputFile();
        } catch (FileNotFoundException e) {
            //catch the fileNotFoundException and print reason
            System.out.print("Could not open exercise41_output.txt");
        }
    }
}