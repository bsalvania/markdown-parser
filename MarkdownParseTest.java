import static org.junit.Assert.*;
import java.nio.file.Path;
import org.junit.*;
import java.nio.file.Files;
import java.util.*;


public class MarkdownParseTest {
    ArrayList<String> expectedlinks; //ArrayList utilized by tests 1, 2, 3, and 4

    @Before
    public void setup() {
        //Populate array with desired output
        expectedlinks = new ArrayList<>();
        expectedlinks.add("https://something.com");
        expectedlinks.add("some-thing.html");
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    /*
    / Test markdown file w/ two links present
    */
    @Test
    public void testMarkdownParseFile1() {
        Path filePath = Path.of("test-file1.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            for (int i = 0; i < parsedLinks.size(); ++i) {
                assertEquals(expectedlinks.get(i), parsedLinks.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ two links and an image present
    */
    @Test
    public void testMarkdownParseFile2() {
        Path filePath = Path.of("test-file2.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            for (int i = 0; i < parsedLinks.size(); ++i) {
                assertEquals(expectedlinks.get(i), parsedLinks.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ two links, an image present, and no title
    */
    @Test
    public void testMarkdownParseFile3() {
        Path filePath = Path.of("test-file2.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            for (int i = 0; i < parsedLinks.size(); ++i) {
                assertEquals(expectedlinks.get(i), parsedLinks.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ two links and an image present, with extra space at the end
    */
    @Test
    public void testMarkdownParseFile4() {
        Path filePath = Path.of("test-file4.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            for (int i = 0; i < parsedLinks.size(); ++i) {
                System.out.println(parsedLinks.get(i));
                assertEquals(expectedlinks.get(i), parsedLinks.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ no links present
    */
    @Test
    public void testMarkdownParseFile5() {
        Path filePath = Path.of("test-file5.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            assertEquals(0, parsedLinks.size());
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ no links present, but empty brackets are present
    */
    @Test
    public void testMarkdownParseFile6() {
        Path filePath = Path.of("test-file6.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            assertEquals(0, parsedLinks.size());
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ no links present, but lines that look like links
    */
    @Test
    public void testMarkdownParseFile7() {
        Path filePath = Path.of("test-file7.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            assertEquals(0, parsedLinks.size());
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ only ")[" present, not a link
    */
    @Test
    public void testMarkdownParseFile8() {
        Path filePath = Path.of("test-file8.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            assertEquals(0, parsedLinks.size());
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

}