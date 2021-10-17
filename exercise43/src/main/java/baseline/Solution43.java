package baseline;

import java.util.Scanner;

public class Solution43 {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     *
     * Problem: Website generator
     * Create a program that generates a website skeleton:
     * Prompt for the name of the site.
     * Prompt for the author of the site.
     * Ask if the user wants a folder for JavaScript files.
     * Ask if the user wants a folder for CSS files.
     * Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.
     * The users should then find these files and directories created in the working directory of your program
     *
     * create these files in the data folder
     */

    //declare scanner
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        //create an instance of Solution43
        Solution43 app = new Solution43();
        //create an instance of WebsiteInfo
        WebsiteInfo userInfo = new WebsiteInfo();
        //create an instance of websiteGenerator
        WebsiteGenerator generate = new WebsiteGenerator();
        //call the get ConsoleInput
        userInfo.setNameOfWebsite(app.validateConsoleInput("Enter site name: "));
        //call the getConsoleInput and set the name of author
        userInfo.setAuthorName(app.validateConsoleInput("Enter the author name: "));
        //call getConsoleInput and ask user if they want javascript folder
        userInfo.setJavascriptFolder(app.validateConsoleInput("Do you want a folder for JavaScript? "));
        //call getConsoleInput and ask user if they want a css folder
        userInfo.setWantsCssFolder(app.validateConsoleInput("Do you want a folder for CSS? "));
        //call the website skeleton method
        generate.createWebsiteSkeleton(userInfo);
    }

    //create a function that returns string output
    public String validateConsoleInput(String prompt){
        //create a variable for do while loop
        boolean catchVariable = false;
        //create a testing string
        String testing;
        //create a do while loop to test for correct input
        do{
            //create a sys out
            System.out.print(prompt);
            //save the input to a testing string
            testing = input.nextLine();
            //check if the userInput is within the regex
            if(testing.matches("^[A-Za-z0-9 ]*$") && !testing.isBlank()){
                //if it is then set catchVariable to true
                catchVariable = true;
            }else{
                //if not print out not a valid input
                System.out.print("Not a valid input. Only letters and numbers.\n");
            }
        }while(!catchVariable);
        //return the string
        return testing;
    }

}