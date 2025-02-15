//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Tester {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;


        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            int openParen2 = markdown.indexOf("(", openParen + 1);
            int closeParen2 = markdown.indexOf(")", closeParen + 1);
            // System.out.println("index: " + currentIndex);
            // System.out.println("openParen: " + openParen);
            // System.out.println("openParen2: " + openParen2);
            // System.out.println("closeParen: " + closeParen);
            //System.out.println("closeParen2: " + closeParen2);

            //If statement checks if there is another open parenthese before
            //the end of the current line, and if so, go to the 2nd close
            //parenthese 
            if (openParen2 != -1 && closeParen > openParen2)
            {
                //int closeParen2 = markdown.indexOf(")", closeParen + 1);
                toReturn.add(markdown.substring(openParen + 1, closeParen2));
                currentIndex = closeParen2 + 1;
            }
            else 
            {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
            // = closeParen + 1;

        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}

