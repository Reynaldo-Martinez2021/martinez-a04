package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequency {
    /*
     *  UCF COP3330 Fall 2021 Assignment 4 Solutions
     *  Copyright 2021 first_name last_name
     *
     */

    //create a function that will store the txt file in a list
    public void txtFileToMap() {
        //create a list
        Map<String, Integer> txtFileWords = new HashMap<>();

        //create try block with scanner
        try(Scanner textReader = new Scanner(new File("data/exercise46_input.txt"))) {
            //create awhile loop to read one word at a time
            while (textReader.hasNext()) {
                //create a string variable to hold the textReader
                String word = textReader.next();
                //check if map doesn't contain the word
                if (!txtFileWords.containsKey(word)) {
                    //if it does add word and frequency of 1
                    txtFileWords.put(word, 1);
                } else {
                    //put the existing word in the map and add one to the frequency
                    txtFileWords.put(word, txtFileWords.get(word) + 1);
                }
            }
            //call the quick sort algo for a map
            Map<String, Integer> sortedMap = sortByValue(txtFileWords);
            //call the consoleOutput function to print results
            consoleOutput(sortedMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //create a function to sort the hashMap
    public Map<String, Integer> sortByValue(Map<String, Integer> integerHashMap){
        //create a list from elements of hashmap
        List<Map.Entry<String, Integer>> list = new LinkedList<>(integerHashMap.entrySet());

        //sort the list
        list.sort((o1, o2) ->
                //compare o2 to 01.
                (o2.getValue()).compareTo(o1.getValue())
        );

        //put the data from sorted list to hashmap
        HashMap<String, Integer> temporaryMap = new LinkedHashMap<>();
        //create a for loop to add the words to map
        for(Map.Entry<String, Integer> word : list){
            temporaryMap.put(word.getKey(), word.getValue());
        }
        return temporaryMap;
    }

    //create a function to print to console
    public void consoleOutput(Map<String, Integer> sortedMap){
        //create a for loop to print the word
        for(Map.Entry<String, Integer> word: sortedMap.entrySet()){
            System.out.printf("%-10s", word.getKey() + ":");

            //create a nested loop to print the number of asterisks
            for(int i = 0; i < word.getValue(); i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
