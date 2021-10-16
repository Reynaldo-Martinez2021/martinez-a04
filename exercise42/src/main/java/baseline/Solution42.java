package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class Solution42 {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     *
     * Problem: Parsing a Data File
     * Construct a program that reads in data from a csv file
     *
     * Example Output
     * Last      First     Salary
     * --------------------------
     * Ling      Mai       55900
     * Johnson   Jim       56500
     * Jones     Aaron     46000
     * Jones     Chris     34500
     * Swift     Geoffrey  14200
     * Xiong     Fong      65000
     * Zarnecki  Sabrina   51500
     *
     * Constraints:
     * Write your own code to parse the data. Don't use a CSV parser
     */

    public static void main(String[] args){
        //create an application of the class
        Solution42 application = new Solution42();
        //create an application of ParseTextFile
        ParseTextFile parser = new ParseTextFile();
        //create a list for employeeData
        List<String> employeeData;
        //call scanInputFile and save value to created list
        employeeData = parser.parseInputFile();
        //call the printToOutputFile
        application.printToOutputFile(employeeData);
    }

    //create a function to print to the output file
    public void printToOutputFile(List<String> data){
        //create a file name in the correct folder 'data'
        File file = new File("data/exercise42_output.txt");
        //init print stream with try block
        try(PrintStream stream = new PrintStream(file)){
            //set the sys out to the stream
            System.setOut(stream);
            //use the string formatting for the table results
            System.out.printf("%-10s%-10s%s%n", "Last", "First", "Salary");
            //print out the dashed line
            System.out.print("--------------------------\n");
            //create a for loop to print every element with format
            for(String element: data){
                if(element.contains("\n"))
                    System.out.print(element);
                else
                    System.out.printf("%-10s", element);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}