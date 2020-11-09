package dictionary.source;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DictionaryFileSource implements DictionarySource {

    private List<String> stringList = new ArrayList<>();
    private static final String fileName = "src/main/resources/input_files/dictionary.txt";

    public DictionaryFileSource() {
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            Scanner sc = new Scanner(fis);
            load(sc);
            sc.close();
        } catch (IOException e) {
            System.out.println("Issue in reading the file");
            e.printStackTrace();
        }
    }

    private void load(Scanner sc) {
        while (sc.hasNextLine()) {
            stringList.add(sc.nextLine());
        }
    }

    @Override
    public boolean add(String data) {
        if (stringList.contains(data)) {
            System.out.println("Given word is already present in the dictionary. Try to add new word...");
            return false;
        }

        try {
            BufferedWriter br = getWriter(true);
            br.write(data);
            br.newLine();
            br.close();
            stringList.add(data);
        } catch (IOException e) {
            System.out.println("Issue in writing to the file");
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String get(String data) {
        if (stringList.contains(data)) {
            return data;
        }
        return null;
    }

    @Override
    public List<String> list() {
        return stringList;
    }

    @Override
    public boolean delete(String data) {
        if (!stringList.contains(data)) {
            System.out.println("Given word is not present in the dictionary. Try to delete another word...");
            return false;
        }
        stringList.remove(data);

        try {
            BufferedWriter br = getWriter(false);
            for (String word : stringList) {
                br.write(word);
                br.newLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Issue while deleting from the file");
            e.printStackTrace();
        }
        return false;
    }

    private BufferedWriter getWriter(boolean append) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(fileName), append);
        BufferedWriter br = new BufferedWriter(fileWriter);
        return br;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        DictionaryFileSource that = (DictionaryFileSource) o;
        return Objects.equals(stringList, that.stringList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringList);
    }
}
