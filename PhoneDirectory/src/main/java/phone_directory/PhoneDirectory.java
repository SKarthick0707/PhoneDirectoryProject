package phone_directory;

import dictionary.Dictionary;
import dictionary.DictionaryFinder;
import dictionary.source.DictionarySource;
import dictionary.source.DictionarySourceFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneDirectory {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
            inputOptions();
            int input = in.nextInt();
            System.out.println("You entered: " + input);

            switch (input) {
                case 1:
                    System.out.println("Enter the file name to find: ");
                    String fileName = in.next();
                    String outputFile = findNumberFromFile(fileName);
                    System.out.println("Result is written in the file : "+outputFile);
                    break;
                case 2:
                    System.out.println("Enter the number to find: ");
                    String number = in.next();
                    findNumber(number);
                    break;
                case 3:
                    System.out.println("Enter the word to add in dictionary: ");
                    String word = in.next();
                    addWordToDictionary(word);
                    break;
                case 4:
                    System.out.println("Enter the word to delete from dictionary: ");
                    String wordToDelete = in.next();
                    deleteWordFromDictionary(wordToDelete);
                    break;
                case 5:
                    System.out.println("See you later, Bye....");
                    System.exit(0);
                    break;
            }

            System.out.println("==================");
            System.out.println("");
        }
    }

    public static String findNumberFromFile(String fileName) {
        List<String> inputNumbers = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                inputNumbers.add(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Issue in reading the file : " + fileName);
            e.printStackTrace();
        }

        String outputFileName = "src/main/resources/output_files/phone_number_output.txt";
        try {
            FileWriter fileWriter = new FileWriter(new File(outputFileName));
            BufferedWriter br = new BufferedWriter(fileWriter);

            for (String word : inputNumbers) {
                String result = _findNumber(word);

                if(result != null){
                    br.write(word + ": " + result);
                } else {
                    br.write(word + ": no match found");
                }

                br.newLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Issue while writing to the file : " + outputFileName);
            e.printStackTrace();
        }


        return outputFileName;
    }

    public static void findNumber(String number) {
        String result = _findNumber(number);
        if(result != null){
            System.out.println("Match found : "+result);
        } else {
            System.out.println("No match found for the given number: "+ number);
        }

    }

    public static String _findNumber(String number) {
        Dictionary dictionary = Dictionary.getDictionary(DictionarySourceFactory.getDictionarySource());
        DictionaryFinder dictionaryFinder = new DictionaryFinder(dictionary);
        return dictionaryFinder.findPhoneNumber(number);
    }

    public static void addWordToDictionary(String word) {
        DictionarySource dictionarySource = DictionarySourceFactory.getDictionarySource();
        dictionarySource.add(word);
        Dictionary dictionary = Dictionary.getDictionary(dictionarySource);
        dictionary.add(word);
    }

    public static void deleteWordFromDictionary(String word) {
        DictionarySource dictionarySource = DictionarySourceFactory.getDictionarySource();
        dictionarySource.delete(word);
        Dictionary dictionary = Dictionary.reset(dictionarySource);
    }

    public static void inputOptions() {
        System.out.println("Choose the options: ");
        System.out.println("1. Find the number from the file");
        System.out.println("2. Find the number");
        System.out.println("3. Add word to dictionary");
        System.out.println("4. Delete word from dictionary");
        System.out.println("5. Exit");
        System.out.println("Enter your option: ");
    }

}
