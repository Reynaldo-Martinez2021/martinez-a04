package baseline;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyTest {
    /*
     *  UCF COP3330 Fall 2021 Assignment 4 Solutions
     *  Copyright 2021 first_name last_name
     *
     */

    @Test
    void txtFileToMap() throws FileNotFoundException {
        //create a expectedList
        Map<String, Integer> expectedList = new HashMap<>();
        //add in the values
        expectedList.put("snake", 1);
        expectedList.put("mushroom", 2);
        expectedList.put("badger", 7);

        //create an actualList
        Map<String, Integer> actualList = new HashMap<>();

        //create a scanner
        Scanner textReader = new Scanner(new FileReader("data/exercise46_input.txt"));
        //create awhile loop to read one word at a time
        while (textReader.hasNext()) {
            //create a string variable to hold the textReader
            String word = textReader.next();
            //check if map doesn't contain the word
            if (!actualList.containsKey(word)) {
                //if it does add word and frequency of 1
                actualList.put(word, 1);
            } else {
                //put the existing word in the map and add one to the frequency
                actualList.put(word, actualList.get(word) + 1);
            }
        }
        //assertEquals to hashMaps
        assertEquals(expectedList, actualList);
    }

    @Test
    void txtFileToMapException(){
        //assertThrows in lambda
        assertThrows(FileNotFoundException.class, ()->new FileReader("data/iFeelBetter.txt"));
    }

    @Test
    void sortByValue() {
        //create a sorted Expected
        Map<String, Integer> expectedList = new HashMap<>();
        //add in the values
        expectedList.put("badger", 7);
        expectedList.put("mushroom", 2);
        expectedList.put("snake", 1);

        //create an unsortedList
        Map<String, Integer> unsortedList = new HashMap<>();
        //add in the values
        unsortedList.put("snake", 1);
        unsortedList.put("mushroom", 2);
        unsortedList.put("badger", 7);

        //create list from elements of unsortedList
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortedList.entrySet());

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

        assertEquals(expectedList, temporaryMap);
    }
}
