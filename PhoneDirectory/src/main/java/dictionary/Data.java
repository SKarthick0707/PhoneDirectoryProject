package dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Data {

    Character c;
    boolean isWord = false;
    List<Data> nextCharList;

    public Data(Character c) {
        this.c = c;
        this.nextCharList = new ArrayList<>();
    }

    public Character getC() {
        return c;
    }

    public List<Data> getNextCharList() {
        return nextCharList;
    }

    public void print() {
        System.out.println("printing character : "+ c);
        if(isWord()){
            System.out.println("This is the completion of the word");
        }
        System.out.println("Iterating the next characters");
        for(Data data : nextCharList){
            data.print();
        }
    }

    public boolean isWord() {
        return isWord;
    }

    public void isWord(boolean word) {
        isWord = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Data data = (Data) o;
        return Objects.equals(c, data.c);
    }

}
