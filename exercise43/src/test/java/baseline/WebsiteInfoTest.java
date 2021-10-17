package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteInfoTest {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    @Test
    void testSetGetNameOfWebsite() {
        //create an instance of websiteGenerator
        WebsiteInfo app = new WebsiteInfo();
        //set the name of website
        app.setNameOfWebsite("awesomeco");
        //assertEquals with get
        assertEquals("awesomeco", app.getNameOfWebsite());
    }

    @Test
    void testSetGetAuthorName() {
        //create an instance of websiteGenerator
        WebsiteInfo app = new WebsiteInfo();
        //set the authors name
        app.setAuthorName("Max Pain");
        //assertEquals with expected String
        assertEquals("Max Pain", app.getAuthorName());
    }

    @Test
    void testSetGetCssAnswer(){
        //create an instance of websiteGenerator
        WebsiteInfo app = new WebsiteInfo();
        //set the css answer
        app.setWantsCssFolder("n");
        //assertEquals with expected boolean
        assertFalse(app.getCssAnswer());
    }

    @Test
    void testSetGetJavascriptAnswer() {
        //create an instance of websiteGenerator
        WebsiteInfo app = new WebsiteInfo();
        //set the js folder answer
        app.setJavascriptFolder("Y");
        //assertEquals with expected boolean
        assertTrue(app.getJavascriptAnswer());
    }
}