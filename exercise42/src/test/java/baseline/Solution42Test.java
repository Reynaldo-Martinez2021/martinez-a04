package baseline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

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
        File file = new File("data/exercise42_output.txt");
        //use assertTrue to test it
        Assertions.assertTrue(file.exists());
    }

    @Test
    void checkOutputContents(){
        //check to see if the contents of the file are correct
        String expectedOutput = """
                Last      First     Salary
                --------------------------
                Ling      Mai       55900
                Johnson   Jim       56500
                Jones     Aaron     46000
                Jones     Chris     34500
                Swift     Geoffrey  14200
                Xiong     Fong      65000
                Zarnecki  Sabrina   51500
                """;
        //create a string to hold path
        String path = "data/exercise42_output.txt";
        //surround readString with try catch
        try{
            //create a string from the output file
            String actualOutput = Files.readString(Path.of(path), StandardCharsets.UTF_8);
            //get rid of the \r in the CRLf
            actualOutput = actualOutput.replaceAll("\r", "");
            //create an assertEquals
            assertEquals(expectedOutput, actualOutput);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}