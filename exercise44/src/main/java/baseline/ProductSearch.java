package baseline;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class ProductSearch {
    /*
     *  UCF COP3330 Fall 2021 Assignment 4 Solutions
     *  Copyright 2021 Reynaldo Martinez
     */

    //create a hashmap
    private final HashMap<Integer, Product> productHashMap = new HashMap<>();

    //declare a scanner for processConsoleInput
    static final Scanner input = new Scanner(System.in);

    //create a function to print out the Product user is searching
    public void processConsoleInput(){
        //call the parseJsonFile and inside parseJsonFile it will call fillHashMap
        parseJsonFile();
        //ready to start processing console input
        //create a boolean variable
        boolean bool = true;
        //create a do while loop which the while will rely on a false
        do{
            //Sys out a print
            System.out.print("What is the product name? ");
            //create a variable to hold the next input
            String consoleInput = input.nextLine();
            //create if statement to make sure input is valid
            if(consoleInput.matches("^[A-Za-z ]*$") && !consoleInput.isBlank()){
                //create a boolean variable to hold the result of productSearch
                boolean productExists = productSearch(consoleInput);
                //create an if statement for productExists
                if(productExists){
                    //if product exists set bool equal to false
                    bool = false;
                }else{
                    //print sorry the product isn't there
                    System.out.print("Sorry, that product was not found in our inventory.\n");
                }
            }else{
                //print that's not a valid input
                System.out.print("That is not a valid input. Please try again.\n");
            }
        }while(bool);
    }

    //create a boolean function that will take in a string and check it against hashmap
    public boolean productSearch(String consoleInput){
        //create a variable to hold the returnValue of containsKey
        boolean productExists = false;
        //create a for loop to check if consoleInput is inside hashMap
        for(int i = 0; i < productHashMap.size(); i++){
            //if consoleInput is insideHashMap print the format
            if(consoleInput.toLowerCase(Locale.ROOT).equals(productHashMap.get(i).getProductName().toLowerCase(Locale.ROOT))){
                System.out.printf("Name: %s%nPrice: %.2f%nQuantity: %d%n",productHashMap.get(i).getProductName(),productHashMap.get(i).getPrice()
                        ,productHashMap.get(i).getQuantity());
                //set the productExists variable to true
                productExists = true;
            }
        }
        //return productExists
        return productExists;
    }

    //create a function to parse the JSON file into a json array
    public void parseJsonFile() {
        //create an instance of gson
        Gson gson = new Gson();
        //create a reader that opens the json file
        try (Reader reader = new FileReader("data/exercise44_input.json")) {
            //create json element from the reader
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            //create a json string to toJson
            String jsonInString = gson.toJson(json);
            //create a jsonObject for products from file
            JsonObject jsonObject = gson.fromJson(jsonInString, JsonObject.class);
            //parse the jsonObject to create an array
            JsonArray productJsonArray = jsonObject.get("products").getAsJsonArray();
            //call the fillHashMap function
            fillHashMap(productJsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //create a function to then split the array to a hashmap
    private void fillHashMap(JsonArray productArray){
        //create a for loop to split the array
        for(int i = 0; i < productArray.size(); i++){
            //create a product instance
            Product product = new Product();
            //create an object from each array index
            JsonObject object = productArray.get(i).getAsJsonObject();
            //set productName from array
            product.setProductName(object.get("name").getAsString());
            //set productPrice from array
            product.setPrice(object.get("price").getAsDouble());
            //set productQuantity from array
            product.setQuantity(object.get("quantity").getAsInt());
            //set the productInteger as i
            productHashMap.put(i, product);
        }
    }
}