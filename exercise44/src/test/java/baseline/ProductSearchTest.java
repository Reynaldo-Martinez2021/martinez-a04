package baseline;

class ProductSearchTest {

    //create a product function to fill hashMap
    //pass parameters to function
    Product createProduct(String name, double price, int quantity){
        //set all the values with passed parameters
        //return temp product
        return null;
    }

    @Test
    //create a boolean function that will take in a string and check it against hashmap
    void productSearch(){
        //create a testing hashMap to check if my loop works
        HashMap<Integer, Product> expectedHashMap = new HashMap<>();
        //fill hashMap with returned product

        //create a consoleInput
        //create an index for testing
        //create a for loop to check if consoleInput is inside hashMap
        //if consoleInput is insideHashMap print the format
        //assert equals
    }

    @Test
    void parseJsonFile() {
        //create a testing string of Jsonarray
        //create an instance of gson
        //create a reader that opens the json file
        //create json element from the reader
        //create a json string to toJson
        //create a jsonObject for products from file
        //parse the jsonObject to create an array
        //assertEquals with JsonCompare Lenient that im passing the correct JsonArray
    }

    @Test
    void parseJsonFileException(){
        //create a fake file
        //assertThrows in lambda
    }

    @Test
    void fillHashMap(){
        //create json string
        //create a new gson
        //create jsonArray from gson.fromJson
        //create a testing hashMap
        //fill hashMap with returned product
        //create actual ProductHashMap

        //create a for loop to split the array
        //create a product instance
        //create an object from each array index
        //set productName from array
        //set productPrice from array
        //set productQuantity from array
        //set the productInteger as i
        //assertTrue for expected vs actual
    }
}