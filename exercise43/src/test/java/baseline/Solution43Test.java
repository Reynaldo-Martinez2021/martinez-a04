package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution43Test {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    @Test
    void validateConsoleInput() {
        //create a string for testing
        String testing = "awesomeco--";
        //create a string to simulate return
        String nextAction;
        //create an if else to determine if we return string or prompt for another
        if(testing.matches("^[A-Za-z0-9 ]*$") && !testing.isBlank())
            //set nextAction to testing
            nextAction = testing;
        else
            //else set it to sysout
            nextAction = "Not a valid input. Only letters and numbers.\n";
        //add an assertEquals
        assertEquals("Not a valid input. Only letters and numbers.\n", nextAction);
    }
}