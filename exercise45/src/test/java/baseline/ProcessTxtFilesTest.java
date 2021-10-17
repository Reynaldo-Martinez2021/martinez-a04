package baseline;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTxtFilesTest {

    @Test
    void testFileName(){
        //call the getFileName and store it
        String userFileName = getFileName();
        //assertEquals if file name is correct
        assertEquals("thisIsAwesome.txt", userFileName);
    }

    //create a function to ask for file name
    private String getFileName() throws NullPointerException{
        //create a string for returning
        String userFileName = null;
        //create a return String
        String consoleInput = "thisIsAwesome";
        //check if fileName is blank
        if(consoleInput.isBlank())
            //print that's not a valid input
            System.out.print("That is not a valid input. Please try again.\n");
        else{
            //create a string with .txt
            String extension = ".txt";
            //add extensions to console input
            userFileName = consoleInput + extension;
        }
        return userFileName;
    }


    @Test
    void modifyNewFile() throws Exception{
        //create the fake parameters
        String userFileName = "testingData/thisIsAwesome.txt";
        //create string to hold exercise45 contents
        String inputContents = """
                One should never utilize the word "utilize" in writing. Use "use" instead.
                For example, "She uses an IDE to write her Java programs" instead of "She
                utilizes an IDE to write her Java programs".""";

        //create a string to hold expected output
        String expectedOutput = """
                One should never use the word "use" in writing. Use "use" instead.
                For example, "She uses an IDE to write her Java programs" instead of "She
                uses an IDE to write her Java programs".""";

        //create inputReader and outputWriter
        BufferedReader inputReader = new BufferedReader(new FileReader("testingData/testingExercise45_input.txt"));
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(userFileName));
        //write to file from inputContents replacing utilize
        outputWriter.write(inputContents.replace("utilize", "use").replace("Utilize","use"));
        //close inputReader and outputWriter
        outputWriter.close();
        inputReader.close();

        //create a string from file
        String actualOutput = Files.readString(Path.of(userFileName), StandardCharsets.UTF_8);
        //assertEquals expectedOutput vs actualOutput
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testNewFile(){
        //create a file to point to
        Path testingPath = Paths.get("testingData/thisIsAwesome.txt");
        //assertTrue the file exists
        assertTrue(Files.exists(testingPath));
    }

    @Test
    void modifyFilesException(){
        //create fake file
        String fileName = "testingData/iAmDepressed.txt";
        //assertThrows
        assertThrows(FileNotFoundException.class, ()-> new FileReader(fileName));
    }
}