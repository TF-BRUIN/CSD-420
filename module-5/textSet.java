package com.mycompany.csd420_asgnt05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Truman Forey || 4/13/2025 || CSD 420 Assignment 5.2
 * 
 * This program is an experiment with Java's set functions and parsing
 * the text of a normal .txt file. This program will first attempt to load a
 * 'collection_of_words.txt' (already placed in the .zip file) and do multiple
 * steps to convert that text into a machine-friendly format. The words parsed
 * will be put into a set that will automatically sort the words alphabetically
 * and then be printed. Then that set will be copied, turn into an array, and 
 * then reversed and printed.
 */

public class textSet {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String fileName = "collection_of_words.txt";
        try {
            File collectionOfWords = new File(fileName);
            Scanner fileReader = new Scanner(collectionOfWords);
            Set<String> wordSet = new HashSet<>();

            String lineOfText01 = ""; // declaring type up here to make each call a little bit cleaner
            String lineOfText02 = ""; // probably couldve used more indicative names but whatever
            String lineOfText03 = "";
            
            while (fileReader.hasNextLine()) {
                lineOfText01 = fileReader.nextLine();
                lineOfText02 = lineOfText01.replaceAll("[.,]","");
                lineOfText03 = lineOfText02.toLowerCase();
                // probably a way to condense each step into 1 line, but I like making each step separate
                String[] splitWords = lineOfText03.split(" ");
                
                for (String item : splitWords) {
                    wordSet.add(item); // apparently there's an easier way to make this, 
                                        // but I decided to just keep it simple
                }
            }
            
            Set<String> finalSet = new TreeSet<>(wordSet); // creating a treeset in this way automatically sorts it out

            System.out.println(finalSet);
            
            List<String> reversedList = new ArrayList<>(finalSet);
            //Set<String> reversedSet = new HashSet<>(finalSet); 
            // decided to use a normal ArrayList instead of finagling a set into reverse order
            
            Collections.reverse(reversedList);
            System.out.println(reversedList);
                      
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
