package baseline;

public class Solution46 {
    /*
     *  UCF COP3330 Fall 2021 Assignment 4 Solutions
     *  Copyright 2021 first_name last_name
     *
     *  Problem: Word Frequency Finder
     *
     *  Read in file and count the frequency of words
     *  Construct a histogram displaying the words and the frequency
     *  Display histogram to screen
     *
     *  Constraints:
     *  Ensure that the most used word is at the top of the report and the least used words are at the bottom.
     *
     *  read each string in the input file
     *  if word is new add it to string list
     *  count each occurrence of words
     *  keep track of minimum and max words
     */

    public static void main(String[] args) {
        //create an instance of wordFrequency
        WordFrequency application = new WordFrequency();
        //call the readTxtFile function
        application.txtFileToMap();
    }
}