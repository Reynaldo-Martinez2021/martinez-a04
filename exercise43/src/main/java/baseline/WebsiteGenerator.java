package baseline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WebsiteGenerator {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    //create a static final path
    private Path dataPath = Paths.get(".\\data");

    //create a method to make the folder directory
    boolean createFolder(Path folderPath){
        //create a new file
        File folder = createNewFile(folderPath);
        //if statement to check if directory is present
        if(!folder.exists()) return folder.mkdir();
        else return false;
    }

    File createNewFile(Path filePath){
        //create a new file from filePath
        return new File(String.valueOf(filePath));
    }


    //create a function driver to create the files for the website
    public void createWebsiteSkeleton(WebsiteInfo userInfo){
        //call the createWebsiteFolder
        createWebsiteFolder();
        //create an if else to check if the website name is new or not
        createUserWebsiteFolder(userInfo);
        //call the createIndexFile function
        createIndexHtmlFile(userInfo);
        //call the createJavascriptFolder
        createJavascriptFolder(userInfo);
        //call the createCssFolder
        createCssFolder(userInfo);
    }

    //function to create the website folder in data
    public void createWebsiteFolder(){
        //create new path
        Path websiteFolderPath = Paths.get(dataPath + "\\website");
        //update dataPath
        dataPath = websiteFolderPath;
        if(!Files.exists(websiteFolderPath))
            //call the createFolder
            createFolder(websiteFolderPath);
    }

    void createUserWebsiteFolder(WebsiteInfo userInfo) {
        //create a string to make sonar happy
        String backSlash = "\\";
        //create a path (parameter)
        Path websiteNamePath = Paths.get(dataPath + backSlash + userInfo.getNameOfWebsite());
        //update dataPath
        dataPath = websiteNamePath;
        //call the createFolder method
        if(!Files.exists(websiteNamePath)){
            createFolder(websiteNamePath);
            printToConsole(websiteNamePath);
        }
    }

    //function to write tags inside html file
    public void createIndexHtmlFile(WebsiteInfo userInfo){
        //update path
        Path indexHtmlFilePath = Paths.get(dataPath + "\\index.html");
        //check to see if it doesn't exist
        if(!Files.exists(indexHtmlFilePath)) {
            //create a file for the index.html
            File indexHtml = createNewFile(indexHtmlFilePath);
            //create an object buffered writer with new fileWriter in parameters
            try (FileWriter website = new FileWriter(indexHtml)) {
                //write the head tag
                website.write("<head>\n");
                //write the title tags and website name
                website.write("\t<title>" + userInfo.getNameOfWebsite() + "</title>\n");
                //write the meta tags with authors name
                website.write("\t<meta name= \"author\" content = \"" + userInfo.getAuthorName() + "\">\n");
                //write the closing head tag
                website.write("</head>");
                //call printToConsole
                printToConsole(indexHtmlFilePath);
            }catch(IOException e){
                System.out.print("Could not create indexHtml for " + userInfo.getNameOfWebsite());
            }
        }
    }

    //function to create a javaScript folder or not
    public void createJavascriptFolder(WebsiteInfo userInfo) {
        //check the js answer
        if(userInfo.getJavascriptAnswer()){
            //update path
            Path jsPath = Paths.get(dataPath + "\\js\\");
            //call the createFolder
            if(createFolder(jsPath))
                //call printToConsole
                printToConsole(jsPath);

        }
    }

    //function to create a css folder
    public void createCssFolder(WebsiteInfo userInfo){
        //check the cssAnswer
        if(userInfo.getCssAnswer()){
            //update path
            Path cssPath = Paths.get(dataPath + "/cs/");
            //call the createFolder
            if(createFolder(cssPath))
                //call printToConsole
                printToConsole(cssPath);
        }
    }

    //create a function to print to console
    private void printToConsole(Path path){
        //create a sys out
        System.out.print("Created " + String.valueOf(path).replace("\\","/").replace("/js", "/js/").replace("/cs","/cs/") + "\n");
    }
}