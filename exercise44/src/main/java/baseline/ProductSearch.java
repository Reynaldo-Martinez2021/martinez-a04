package baseline;

import com.google.gson.JsonArray;

public class ProductSearch {
    /*
     *  UCF COP3330 Fall 2021 Assignment 4 Solutions
     *  Copyright 2021 Reynaldo Martinez
     */

    //create a hashmap

    //declare a scanner for processConsoleInput

    //create a function to print out the Product user is searching
    public void processConsoleInput(){
        //call the parseJsonFile and inside parseJsonFile it will call fillHashMap
        //ready to start processing console input
        //create a boolean variable
        //create a do while loop which the while will rely on a false
        //Sys out a print
        //create a variable to hold the next input
        //create if statement to make sure input is valid
        //create a boolean variable to hold the result of productSearch
        //create an if statement for productExists
        //if product exists set bool equal to false
        //print sorry the product isn't there
        //print that's not a valid input
    }

    //create a boolean function that will take in a string and check it against hashmap
    public boolean productSearch(String consoleInput){
        //create a variable to hold the returnValue of containsKey
        //create a for loop to check if consoleInput is inside hashMap
        //if consoleInput is insideHashMap print the format
        //set the productExists variable to true
        //return productExists
    }

    //create a function to parse the JSON file into a json array
    public void parseJsonFile() {
        //create an instance of gson
        //create a reader that opens the json file
        //create json element from the reader
        //create a json string to toJson
        //create a jsonObject for products from file
        //parse the jsonObject to create an array
        //call the fillHashMap function
    }

    //create a function to then split the array to a hashmap
    private void fillHashMap(JsonArray){
        //create a for loop to split the array
        //create a product instance
        //create an object from each array index
        //set productName from array
        //set productPrice from array
        //set productQuantity from array
        //set the productInteger as i
    }

}
