package baseline;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SortNamesTest {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     *
     * Ideas:
     * declare global variables to limit code redundancy
     *
     */

    @Test
    void testScanTxtFile() {
        //create an array of unsortedNames
        //create a list for expectedNames
        //add the unsortedArray to expectedNames
        //create a list for actualNames
        //create a filename to point to text file
        //create a scanner
        //loop through the text files
        //add next line to the list
        //assert equals the expectedList vs what we read in
    }

    @Test
    //test
    void testScanInputException(){
        //create a fake file name
        //use assertThrows in some way
    }

    @Test
    void sortList() {
        //create a list for expectedSortedNames
        //create an array of sortedNames
        //populate sortedNameArray into expectedSortedNames
        //create a list for actualSortedNames
        //create an unsortedArray
        //populate the unsortedNameArray into actualSortedNames
        //call the collections sort on actualSortedLis
        //assertEquals expected vs actual
    }
}