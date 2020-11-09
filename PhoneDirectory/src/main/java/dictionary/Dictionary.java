package dictionary;

import dictionary.source.DictionarySource;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private static Dictionary dictionary;

    public List<Data> charList;
    DictionarySource dictionarySource;


    private Dictionary(DictionarySource dictionarySource) {
        this.charList = new ArrayList<>();
        this.dictionarySource = dictionarySource;
        load();
    }

    private void load() {
        List<String> wordsList = dictionarySource.list();
        if (wordsList == null || wordsList.isEmpty()) {
            return;
        }
        for (String word : wordsList) {
            add(word);
        }
    }

    public void add(String word) {
        char[] chars = word.toCharArray();
        List<Data> charDataList = charList;
        boolean wordAdded = false;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            Data data = getData(charDataList, ch);

            if (data != null) {
                charDataList = data.getNextCharList();
            } else {
                data = new Data(ch);
                charDataList.add(data);
                charDataList = data.getNextCharList();
                wordAdded = true;
            }
            if (i == chars.length - 1) {
                data.isWord(true);
            }
        }
        if (!wordAdded) {
            System.out.println(word + " already present in the dictionary. Try to add new word.");
        }
    }


    public void print() {
        for (Data data : charList) {
            data.print();
        }
    }

    public static Data getData(List<Data> charList, Character character) {
        for (Data data : charList) {
            if (Character.toLowerCase(data.getC()) == Character.toLowerCase(character)) {
                return data;
            }
        }
        return null;
    }

    public List<Data> getCharList() {
        return charList;
    }


    //singleton object is created to share the dictionary through out the entire phone directory operations.
    public static Dictionary getDictionary(DictionarySource dictionarySource) {
        if (dictionary == null || !dictionary.dictionarySource.equals(dictionarySource)) {
            return dictionary = new Dictionary(dictionarySource);
        }
        return dictionary;
    }

    public static Dictionary reset(DictionarySource dictionarySource) {
        return dictionary = new Dictionary(dictionarySource);
    }


}
