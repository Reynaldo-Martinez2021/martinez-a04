package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortNames {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    //create a list<String>
    private final List<String> names = new ArrayList<>();

    //create a function to scan the input file and fill up the array
    //function will throw Exceptions and main will handle catching
    public void scanInputFile() throws FileNotFoundException{
        //create a filename to point to text file
        String fileName = "data/exercise41_input.txt";
        //create try block with scanner inside
        try(Scanner input = new Scanner(new FileReader(fileName))){
            //create awhile loop with input.nextLine
            while (input.hasNextLine()) {
                //add next line to the list
                names.add(input.nextLine());
            }
            //call the sortList function to alphabetically sort Arraylist
            sortList();
        }
    }

    //create a function to sort the arrays alphabetically
    public void sortList(){
        //use the collections sort lib to sort array
        Collections.sort(names);
    }

    //create a function to print out the correct output
    //function will throw Exceptions and main will handle catching
    public void printToOutputFile() throws FileNotFoundException{
        //create a file name in the correct folder 'data'
        File file = new File("data/exercise41_output.txt");
        //initialize the print Stream
        PrintStream stream = new PrintStream(file);
        //set the Sys out to stream
        System.setOut(stream);
        //create the print for total names using list size
        System.out.printf("Total of %d names%n-----------------%n", names.size());
        //create a for loop to print each element in its own line
        for(String element: names)
            System.out.println(element);
    }
}