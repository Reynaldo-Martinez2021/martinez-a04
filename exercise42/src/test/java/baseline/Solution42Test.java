package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    @Test
    void printToOutputFileException(){
        //create a filePath
        String filePath = " ";
        //assertThrows
        assertThrows(FileNotFoundException.class, ()->{
            PrintStream stream = new PrintStream(filePath);
            stream.close();
        });
    }

    @Test
    void outputFileCreated(){
        //check to see if the file was created
        //use assertTrue to test it
    }

    @Test
    void checkOutputContents(){
        //check to see if the contents of the file are correct
        //create a string to hold path
        //surround readString with try catch
        //create string from output
        //get rid of the \r in the CRLf
        //create an assertEquals
        
    }
}