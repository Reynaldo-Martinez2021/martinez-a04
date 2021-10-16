package baseline;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ParseTextFileTest {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    @Test
    void parseInputFile() {
        //create an expectedArray
        String[] txtFileArray = {
                "Ling","Mai","55900\n",
                "Johnson","Jim","56500\n",
                "Jones","Aaron","46000\n",
                "Jones","Chris","34500\n",
                "Swift","Geoffrey","14200\n",
                "Xiong","Fong","65000\n",
                "Zarnecki","Sabrina","51500\n",

        };
        //create an expectedList
        List<String> expectedList = new ArrayList<>();
        //add expectedArray to expectedList with collections
        Collections.addAll(expectedList, txtFileArray);

        //create a list for actual
        List<String> actualList = new ArrayList<>();
        //create a stringFile name
        String fileName = "data/exercise42_input.txt";

        //create a scanner try block
        try(Scanner input = new Scanner(new FileReader(fileName))){
            //create a delimiter checking for comma or newLine
            input.useDelimiter(",|\r\n");
            //create a variable to track every third element
            int elementCount = 0;
            //loop to check if fileName has next
            while(input.hasNext()) {
                //increase elementCount
                elementCount++;
                //check to see if elementCount is 3
                if(elementCount == 3){
                    //add a newLine to every third element
                    actualList.add(input.next() + "\n");
                    //set element count to 0
                    elementCount = 0;
                }else
                    //add each item to list
                    actualList.add(input.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //assertEquals the expectedList vs actualList
        assertEquals(expectedList, actualList);
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
}