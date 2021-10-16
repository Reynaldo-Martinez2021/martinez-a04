package baseline;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    @Test
    void printToOutputFile(){
        //create a filePath
        String filePath = " ";
        //assertThrows
        assertThrows(FileNotFoundException.class, ()->{
            PrintStream stream = new PrintStream(filePath);
            stream.close();
        });
    }
}