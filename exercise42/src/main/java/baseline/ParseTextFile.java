package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseTextFile {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     *
     */

    //create a function to scan the input file and fill up List then returns it
    public List<String> parseInputFile(){
        //create a list
        List<String> data = new ArrayList<>();
        //create a fileName to point to the text file
        String filename = "data/exercise42_input.txt";
        //declare a scanner in the try block
        try(Scanner input = new Scanner(new File(filename))){
            //use delimiter to check for comma or newLine
            input.useDelimiter(",|\r\n");
            //create a variable to track every third element
            int elementCount = 0;
            //loop to check if fileName has next
            while(input.hasNext()) {
                elementCount++;
                //check to see if elementCount is 3
                if(elementCount == 3){
                    //add a newLine to every third element
                    data.add(input.next() + "\n");
                    //set element count to 0
                    elementCount = 0;
                }else
                    //add each item to list
                    data.add(input.next());
            }
        } catch (FileNotFoundException e) {
            System.out.print("Could not open exercise42_input.txt");
        }
        return data;
    }
}