package baseline;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ProductSearchTest {

    //create a product function to fill hashMap
    //pass parameters to function
    Product createProduct(String name, double price, int quantity){
        //set all the values with passed parameters
        Product temp = new Product();
        //return temp product
        temp.setProductName(name);
        temp.setPrice(price);
        temp.setQuantity(quantity);
        return temp;
    }

    @Test
    void testConsoleValidation(){
        //create a boolean variable
        boolean testing = true;
        //create a userString
        String userInput = " ";
        //create if statement to make sure input is valid
        if(userInput.matches("^[A-Za-z ]*$") && !userInput.isBlank())
            //set bool to false
            testing = false;
        assertTrue(testing);
    }

    @Test
    void productSearch(){
        //create a testing hashMap to check if my loop works
        HashMap<Integer, Product> expectedHashMap = new HashMap<>();
        Product temp = createProduct("Widget", 25.0, 5);
        expectedHashMap.put(0, temp);
        temp = createProduct("Thing", 15.0, 5);
        expectedHashMap.put(1, temp);
        temp = createProduct("Doodad", 5, 10);
        expectedHashMap.put(2, temp);

        //create a consoleInput
        String consoleInput = "widget";
        //create an index for testing
        int index = 0;
        //create a for loop to check if consoleInput is inside hashMap
        for(int i = 0; i < expectedHashMap.size(); i++){
            //if consoleInput is insideHashMap print the format
            if(consoleInput.toLowerCase(Locale.ROOT).equals(expectedHashMap.get(i).getProductName().toLowerCase(Locale.ROOT))){
                index = i;
                break;
            }
        }
        //assert equals
        assertEquals("Widget", expectedHashMap.get(index).getProductName());
    }

    @Test
    void parseJsonFile() throws FileNotFoundException, JSONException {
        //create a testing array
        String expected = "[{name:Widget,price:25.00,quantity:5},{name:Thing,price:15.00,quantity:5},{name:Doodad,price:5.00,quantity:10}]";
        //create an instance of gson
        Gson gson = new Gson();
        //create a reader that opens the json file
        Reader reader = new FileReader("data/exercise44_input.json");
        //create json element from the reader
        JsonElement json = gson.fromJson(reader, JsonElement.class);
        //create a json string to toJson
        String jsonInString = gson.toJson(json);
        //create a jsonObject for products from file
        JsonObject jsonObject = gson.fromJson(jsonInString, JsonObject.class);
        //parse the jsonObject to create an array
        JsonArray productJsonArray = jsonObject.get("products").getAsJsonArray();
        //assertEquals with JsonCompareMode.LENIENT that im passing the correct JsonArray
        JSONAssert.assertEquals(expected, String.valueOf(productJsonArray), JSONCompareMode.LENIENT);
    }

    @Test
    void parseJsonFileException(){
        //create a fake file
        String fileName = "data/thisSucks.json";
        //assertThrows in lambda
        assertThrows(FileNotFoundException.class, ()-> new FileReader(fileName));
    }

    @Test
    void fillHashMap(){
        //create json string
        String data = """
                [
                    {"name": "Widget", "price": 25.00, "quantity": 5 },
                    {"name": "Thing", "price": 15.00, "quantity": 5 },
                    {"name": "Doodad", "price": 5.00, "quantity": 10 }
                  ]""";
        //create a new gson
        Gson gson = new Gson();
        //create jsonArray from gson.fromJson
        JsonArray productJsonArray = gson.fromJson(data, JsonArray.class);

        //create a testing hashMap
        HashMap<Integer, Product> expectedHashMap = new HashMap<>();
        Product temp = createProduct("Widget", 25.0, 5);
        expectedHashMap.put(0, temp);
        temp = createProduct("Thing", 15.0, 5);
        expectedHashMap.put(1, temp);
        temp = createProduct("Doodad", 5, 10);
        expectedHashMap.put(2, temp);

        //create actual ProductHashMap
        HashMap<Integer, Product> actualHashMap = new HashMap<>();

        //create a for loop to split the array
        for(int i = 0; i < productJsonArray.size(); i++){
            //create a product instance
            Product product = new Product();
            //create an object from each array index
            JsonObject object = productJsonArray.get(i).getAsJsonObject();
            //set productName from array
            product.setProductName(object.get("name").getAsString());
            //set productPrice from array
            product.setPrice(object.get("price").getAsDouble());
            //set productQuantity from array
            product.setQuantity(object.get("quantity").getAsInt());
            //set the productInteger as i
            actualHashMap.put(i, product);
        }
        //assertTrue for expected vs actual
        assertEquals(expectedHashMap.keySet(), actualHashMap.keySet());
    }
}