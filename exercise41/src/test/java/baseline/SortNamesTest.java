package baseline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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
     */

    @Test
    void scanInputFile() {
        //create an array to avoid repeating .add() of the inputTxtFile of names
        String[] unsortedArray = {
                "Ling, Mai",
                "Johnson, Jim",
                "Zarnecki, Sabrina",
                "Jones, Chris",
                "Jones, Aaron",
                "Swift, Geoffrey",
                "Xiong, Fong"

        };
        //create a list for expectedNames
        List<String> expectedNames = new ArrayList<>();
        //add the unsortedArray to expectedNames
        Collections.addAll(expectedNames, unsortedArray);
        //create a list for actualNames
        List<String> actualNames = new ArrayList<>();
        //create a filename to point to text file
        String fileName = "data/exercise41_input.txt";
        //create a try block for the FileReader
        try(Scanner input = new Scanner(new FileReader(fileName))){
            //create while loop to check if input hasNextLine
            while(input.hasNextLine()){
                //add next line to the list
                actualNames.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.print("Could not find file");
        }
        //assert equals the expectedList vs what we read in
        assertEquals(expectedNames, actualNames);
    }

    @Test
    void scanInputFileException(){
        //create a fake file name
        String fileName = "data/thisSucks.txt";
        //assertThrows using a lambda
        //should return the FileNotFoundException
        assertThrows(FileNotFoundException.class, ()->{
            FileReader reader = new FileReader(fileName);
            reader.close();
        });
    }

    @Test
    void sortList() {
        //create a list for expectedSortedNames
        List<String> expectedSortedList = new ArrayList<>();
        //create an array of sortedNames
        String[] sortedArray = {
                "Johnson, Jim",
                "Jones, Aaron",
                "Jones, Chris",
                "Ling, Mai",
                "Swift, Geoffrey",
                "Xiong, Fong",
                "Zarnecki, Sabrina"
        };
        //populate sortedNameArray into expectedSortedNames
        Collections.addAll(expectedSortedList, sortedArray);
        //create a list for actualSortedNames
        List<String> actualSortedList = new ArrayList<>();
        //create an unsortedArray
        String[] unsortedArray = {
                "Ling, Mai",
                "Johnson, Jim",
                "Zarnecki, Sabrina",
                "Jones, Chris",
                "Jones, Aaron",
                "Swift, Geoffrey",
                "Xiong, Fong"

        };
        //populate the unsortedNameArray into actualSortedNames
        Collections.addAll(actualSortedList, unsortedArray);
        //call the collections sort on actualSortedList
        Collections.sort(actualSortedList);
        //assertEquals expected vs actual
        assertEquals(expectedSortedList, actualSortedList);
    }

    @Test
    void outputFileCreated(){
        //check to see if file was created
        File file = new File("data/exercise41_output.txt");
        //use assertTrue to test it
        Assertions.assertTrue(file.exists());
    }

    @Test
    void checkOutputContents(){
        //check to see if the contents of file are correct
        String expectedOutput = """
                Total of 7 names
                -----------------
                Johnson, Jim
                Jones, Aaron
                Jones, Chris
                Ling, Mai
                Swift, Geoffrey
                Xiong, Fong
                Zarnecki, Sabrina
                """;
        //create a string to hold path
        String path = "data/exercise41_output.txt";
        //surround readString with a try catch
        try {
            //create a string from the output file
            String actualOutput = Files.readString(Path.of(path), StandardCharsets.UTF_8);
            //get rid of the \r in the CRLF
            actualOutput = actualOutput.replaceAll("\r","");
            //create an assertEquals
            assertEquals(expectedOutput, actualOutput);
        } catch (IOException e) {
            System.out.print("File does not exist");
        }
    }
}