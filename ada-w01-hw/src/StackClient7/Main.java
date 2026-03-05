package StackClient7;

import javax.swing.text.html.HTML;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            HTMLParser parser = new HTMLParser(fileScanner);

            parser.parseFile();

            fileScanner.close();
        } catch (HTMLParseException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        scanner.close();
    }
}