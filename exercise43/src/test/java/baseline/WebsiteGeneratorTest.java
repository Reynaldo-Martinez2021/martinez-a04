package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGeneratorTest {

    //create a method to make the folder directory
    //fix it to shut sonar up
    void createFolder(Path folderPath){
        //create a new file
        //if statement to check if directory is present
    }

    File createNewFile(Path filePath) {
        //create a new file and return it
    }

    @Test
    void createWebsiteFolder() {
        //create a path to website folder inside data
        //create new path
        //assertTrue to see if website folder exists
    }

    @Test
    void createUserWebsiteNameFolder() {
        //create a path (parameter)
        //create a new file path
            //call create folder
        //assertTrue if folder was created
    }

    @Test
    void createIndexHtmlFile() throws IOException {
        //create a new path
        //create a new file
        //check if it doesn't exist
            //create an object bufferedWriter with new fileWriter
            //write the head tag
            //write the title tags and website name
            //write the meta tags with authors name
            //write the closing head tag
            //String output = indexHtml.toString().replace("\\", "/");
        //assertTrue
    }

    @Test
    void indexHtmlContents() throws IOException {
        //create string of indexHtml

        //create a string to get path
        //read file into string
        //get rid of \r and \t
        //assertEquals expected vs actual
    }

    @Test
    void createIndexHtmlException() {
        //assertThrows the IOException
    }

    @Test
    void createJavascriptFolder() {
        //create a parameter path
        //create a new Path
        //call the createFolder method
        //assertTrue with a call to createFolder
    }

    @Test
    void createCssFolder() {
        //create a parameter path
        //create a new Path
        //call the createFolder method
        //assertTrue with a call to createFolder
    }
}