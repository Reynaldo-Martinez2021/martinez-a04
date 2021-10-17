package baseline;

public class WebsiteGenerator {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    //create a static final path

    //create a method to make the folder directory
    boolean createFolder(Path folderPath){
        //create a new file
        //if statement to check if directory is present
    }

    File createNewFile(Path filePath){
        //create a new file from filePath
    }


    //create a function driver to create the files for the website
    public void createWebsiteSkeleton(WebsiteInfo userInfo){
        //call the createWebsiteFolder
        //create an if else to check if the website name is new or not
        //call the createIndexFile function
        //call the createJavascriptFolder
        //call the createCssFolder
    }

    //function to create the website folder in data
    public void createWebsiteFolder(){
        //create new path
        //update dataPath
        //call the createFolder
    }

    void createUserWebsiteFolder(WebsiteInfo userInfo) {
        //create a string to make sonar happy
        //create a path (parameter)
        //update dataPath
        //call the createFolder method
    }

    //function to write tags inside html file
    public void createIndexHtmlFile(WebsiteInfo userInfo){
        //update path
        //check to see if it doesn't exist
        //create a file for the index.html
        //create an object buffered writer with new fileWriter in parameters
        //write the head tag
        //write the title tags and website name
        //write the meta tags with authors name
        //write the closing head tag
        //call printToConsole

    }

    //function to create a javaScript folder or not
    public void createJavascriptFolder(WebsiteInfo userInfo) {
        //check for jsAnswer
        //update path
        //if folder is created
        //call printToConsole
    }

    //function to create a css folder
    public void createCssFolder(WebsiteInfo userInfo){
        //check for cssAnswer
        if(userInfo.getCssAnswer()){
            //update path
            //call the createFolder
            //call printToConsole
        }
    }

    //create a function to print to console
    private void printToConsole(Path path){
        //create a sys out
    }
}
