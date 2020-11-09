package dictionary.source;

public class DictionarySourceFactory {

    public static DictionarySource getDictionarySource() {
        DictionarySource dictionarySource = new DictionaryFileSource();
        return dictionarySource;
    }


}
