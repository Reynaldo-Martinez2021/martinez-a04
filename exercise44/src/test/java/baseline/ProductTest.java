package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    /*
     *  UCF COP3330 Fall 2021 Assignment 4 Solutions
     *  Copyright 2021 Reynaldo Martinez
     *
     */

    @Test
    void testSetGetProductName(){
        //create an instance of Product
        Product app = new Product();
        //set widget for productName
        app.setProductName("Widget");
        //assertEquals with getProductName
        assertEquals("Widget", app.getProductName());
    }

    @Test
    void testSetGetPrice(){
        ///create an instance of Product
        Product app = new Product();
        //setPrice as 25.0
        app.setPrice(25.0);
        //assertEquals with getPrice
        assertEquals(25.0, app.getPrice());

    }

    @Test
    void testSetGetQuantity(){
        ///create an instance of Product
        Product app = new Product();
        //setQuantity with 5
        app.setQuantity(5);
        //assertEquals with getQuantity
        assertEquals(5, app.getQuantity());
    }
}