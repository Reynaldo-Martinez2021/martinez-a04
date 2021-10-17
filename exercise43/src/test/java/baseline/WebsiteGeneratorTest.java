package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGeneratorTest {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    //create a method to make the folder directory
    //fix it to shut sonar up
    void createFolder(Path folderPath){
        //create a new file
        File folder = createNewFile(folderPath);
        //if statement to check if directory is present
        if (!folder.exists()) {
            try {
                Files.createDirectories(folderPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    File createNewFile(Path filePath) {
        //create a new file from filePath
        return new File(String.valueOf(filePath));
    }

    @Test
    void createWebsiteFolder() {
        //create a path to website folder inside data
        Path paths = Paths.get(".\\testData");
        //create new path
        Path websiteFolderPath = Paths.get(paths + "\\website");
        //check if file exists
        if (!Files.exists(websiteFolderPath))
            //call create folder
            createFolder(websiteFolderPath);
        //assertTrue to see if website folder exists
        assertTrue(Files.exists(websiteFolderPath));
    }

    @Test
    void createUserWebsiteNameFolder() {
        //create a path (parameter)
        Path paths = Paths.get(".\\testData\\website");
        //create a new file path
        Path websiteNamePath = Paths.get(paths + "\\awesomeco");
        //check if file exists
        if (!Files.exists(websiteNamePath))
            //call create folder
            createFolder(websiteNamePath);
        //assertTrue if folder was created
        assertTrue(Files.exists(websiteNamePath));
    }

    @Test
    void createIndexHtmlFile() throws IOException {
        //create a new path
        Path indexHtml = Paths.get(".\\testData\\website\\awesomeco\\index.html");
        //check if it doesn't exist
        if (!Files.exists(indexHtml)) {
            //create a new file
            File indexHtmlFile = createNewFile(indexHtml);
            //create an object bufferedWriter with new fileWriter
            FileWriter writer = new FileWriter(indexHtmlFile);
            //write the head tag
            writer.write("<head>\n");
            //write the title tags and website name
            writer.write("\t<title>" + "awesomeco" + "</title>\n");
            //write the meta tags with authors name
            writer.write("\t<meta name= \"author\" content = \"" + "Max Pain" + "\">\n");
            //write the closing head tag
            writer.write("</head>");
            //close writer
            writer.close();
            //assertTrue
            assertTrue(indexHtmlFile.exists());
        }
    }

    @Test
    void indexHtmlContents() throws IOException {
        //create string of indexHtml
        String expectedOutput = """
                <head>
                \t<title>awesomeco</title>
                \t<meta name= "author" content = "Max Pain">
                </head>""";

        //read file into string
        String actualOutput = Files.readString(Path.of(".\\testData\\website\\awesomeco\\index.html"));
        //get rid of \r
        actualOutput = actualOutput.replaceAll("\r", "");
        //assertEquals expected vs actual
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void createIndexHtmlException() {
        //assertThrows the IOException
        assertThrows(IOException.class, () -> new FileWriter("testAta/thisSucks.html"));
    }

    @Test
    void createJavascriptFolder() {
        //create a parameter path
        Path path = Paths.get(".\\testData\\website\\awesomeco");
        //create a new Path
        Path jsPath = Paths.get(path + "\\js\\");
        //call the createFolder method
        createFolder(jsPath);
        //assertTrue with a call to createFolder
        assertTrue(Files.exists(jsPath));
    }

    @Test
    void createCssFolder() {
        //create a parameter path
        Path path = Paths.get(".\\testData\\website\\awesomeco");
        //create a new Path
        Path cssPath = Paths.get(path + "\\css\\");
        //call the createFolder method
        createFolder(cssPath);
        //assertTrue with a call to createFolder
        assertTrue(Files.exists(cssPath));
    }
}