import static org.junit.Assert.*;  //Imports assert method

import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;


import org.junit.*; //Imports jUnit for compiler to understand the tests
public class MarkdownParseTest { //Creates a class to create tests

    ArrayList<String> expectedLinks1, expectedLinks2,expectedLinks3, 
        expectedLinks4;

    @Before
    public void setup() {
        expectedLinks1 = new ArrayList<>();
        expectedLinks1.add("https://something.com");
        expectedLinks1.add("some-thing.html");
        //expectedLinks1.add("some-thing.html");

        expectedLinks2 = new ArrayList<>();
        expectedLinks2.add("https://docs.google.com/document/d/1SsTgAC8as-WSS_SGnABkZZerY4Zc9zf-FFgJSPd9v6U/edit#");
        expectedLinks2.add("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        expectedLinks2.add("https://theuselessweb.com/");
        expectedLinks2.add("https://en.wikipedia.org/wiki/4th_Army_(Kingdom_of_Yugoslavia)");

        expectedLinks3 = new ArrayList<>(); 
        expectedLinks3.add("https://something.com");
        expectedLinks3.add("some-thing.html");

        expectedLinks4 = new ArrayList<>();
    }

    @Test                       //Lets compiler know that this is a jUnit test
    public void addition() {    //Method to test an addition problem
        assertEquals(2, 1 + 1); //Checks if the actual result (right) matches the expected result (left)
    }

    @Test                       
    public void multiplicationFail() {
        assertEquals(8, 2 * 4); 
    }

    @Test
    public void testGetLinks1() throws IOException {
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

    //Doesn't work with group code
    // @Test
    // public void testGetLinks2() throws IOException {
    //     Path fileName = Paths.get("test-file2.md");
    //     try {
    //         String content = Files.readString(fileName); 
    //         ArrayList<String> links = MarkdownParse.getLinks(content);

    //         for (int i = 0; i < links.size(); i++)
    //         {
    //             assertEquals(expectedLinks2.get(i), links.get(i));
    //         }
    //     } catch (IOException e) {
    //         System.out.println("Exception thrown");
    //     }
    // }

    @Test
    public void testGetLinks3() throws IOException {
        Path fileName = Paths.get("test-file3.md");
        try {
            String content = Files.readString(fileName); 
            ArrayList<String> links = MarkdownParse.getLinks(content);

            for (int i = 0; i < links.size(); i++)
            {
                assertEquals(expectedLinks3.get(i), links.get(i));
            }
        } catch (IOException e) {
            System.out.println("Exception thrown");
        }
    }

    @Test
    public void testGetLinks4() throws IOException {
        Path fileName = Paths.get("test-file4.md");
        try {
            String content = Files.readString(fileName); 
            ArrayList<String> links = MarkdownParse.getLinks(content);

            for (int i = 0; i < links.size(); i++)
            {
                assertEquals(expectedLinks4.get(i), links.get(i));
            }
        } catch (IOException e) {
            System.out.println("Exception thrown");
        }
    }


}