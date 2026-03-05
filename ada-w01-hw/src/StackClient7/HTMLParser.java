package StackClient7;

import java.util.Scanner;
import java.util.Stack;

public class HTMLParser {

    Scanner scanner;
    Stack<String> tagStack = new Stack<>();

    public HTMLParser(Scanner scanner) {
        this.scanner = scanner;
    }

    public void parseFile() throws HTMLParseException {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (isTag(line)) {
                // it is a tag
                String tagName = getTagName(line);
                if (isClosingTag(line)) {
                    //closing tag

                    String stackTag = tagStack.pop();

                    if (!tagName.equals(stackTag)) {
                        throw new HTMLParseException("Expected closing tag for " + tagName + " " + stackTag);
                    }
                    //System.out.println("Closing tag " + getTagName(line));
                } else {
                    //opening tag
                    //System.out.println("Opening tag " + getTagName(line));
                    tagStack.push(getTagName(line));
                }
            }
        }
    }

    private String getTagName(String line) {
        return line.substring(line.indexOf("<") + (isClosingTag(line) ? 2 : 1), line.indexOf(">"));
    }


    private boolean isClosingTag(String line) {
        return line.contains("</");
    }

    private boolean isTag(String line) {
        return line.contains("<") && line.contains(">");
    }
}
