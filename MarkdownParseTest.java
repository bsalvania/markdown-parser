import static org.junit.Assert.*;  //Imports assert method

import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;


import org.junit.*; //Imports jUnit for compiler to understand the tests
public class MarkdownParseTest { //Creates a class to create tests

    ArrayList<String> expectedLinks1;

    @Before
    public void setup() {
        expectedLinks1 = new ArrayList<>();
        expectedLinks1.add("https://something.com");
        expectedLinks1.add("some-thing.html");
        //expectedLinks1.add("some-thing.html");
    }

    @Test                       //Lets compiler know that this is a jUnit test
    public void addition() {    //Method to test an addition problem
        assertEquals(2, 1 + 1); //Checks if the actual result (right) matches the expected result (left)
    }

    @Test
    public void testGetLinks() throws IOException {
        Path fileName = Paths.get("test-file.md");
        try {
            String content = Files.readString(fileName); 
            ArrayList<String> links = MarkdownParse.getLinks(content);

            for (int i = 0; i < links.size(); i++)
            {
                assertEquals(expectedLinks1.get(i), links.get(i));
            }
        } catch (IOException e) {
            System.out.println("Exception thrown");
        }
    }

}


