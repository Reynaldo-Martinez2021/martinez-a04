package baseline;

import java.io.*;
import java.util.Scanner;

public class ProcessTxtFiles {
    /*
     *  UCF COP3330 Fall 2021 Assignment 4 Solutions
     *  Copyright 2021 Reynaldo Martinez
     */

    //create a function to open two files for processing
    public void openFiles(){
        //call the getFileName and store it
        String userFileName = getFileName();
        //call the modifyNewFile
        modifyNewFile(userFileName);
    }

    //create a function to ask for file name
    private String getFileName(){
        //declare a scanner
        Scanner input = new Scanner(System.in);
        //create a return String
        String fileName = null;
        //create a booleanVariable
        boolean bool = true;
        //create do loop
        do{
            //Sys out a prompt
            System.out.print("Please enter a name for the file: ");
            //create a variable to hold the nextInput
            String consoleInput = input.nextLine();
            if(!consoleInput.isBlank())
            {
                //create a string with .txt
                String extension = ".txt";
                //add extensions to console input
                fileName = consoleInput + extension;
                //set bool to false
                bool = false;
            }else{
                //print that's not a valid input
                System.out.print("That is not a valid input. Please try again.\n");
            }
        }while(bool);

        return fileName;
    }


    public void modifyNewFile(String userFileName){
        //create a try block with inputReader and outputWriter inside
        try(
                BufferedReader inputReader = new BufferedReader(new FileReader("data/exercise45_input.txt"));
                BufferedWriter outputWriter = new BufferedWriter(new FileWriter("data/" + userFileName))
        ){
            //create a string to hold each line for processing
            String processFileString;
            //create awhile loop for the reader to read each line
            while((processFileString = inputReader.readLine()) != null){
                //replace the word utilize with use
                outputWriter.write(processFileString.replace("utilize", "use").replace("Utilize","use"));
                //add \n for the next line of output txt
                outputWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}