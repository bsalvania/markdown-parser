//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

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

            //If statement checks if there is another open parentheses before
            //the end of the current line, and if so, go to the 2nd close
            //parenthese 
            if (openParen2 != -1 && closeParen > openParen2)
            {
                toReturn.add(markdown.substring(openParen + 1, closeParen2));
                currentIndex = closeParen2 + 1;
            }
            else if (markdown.charAt(openBracket-1)== '!') 
            {
                currentIndex = closeParen + 1;
            }
            else if (openParen == -1)
            {
                return toReturn;
            }
            else 
            {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
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

