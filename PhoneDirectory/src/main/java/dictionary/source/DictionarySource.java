package dictionary.source;

import java.util.List;

public interface DictionarySource {

    public boolean add(String data);

    public String get(String data);

    public List<String> list();

    public boolean delete(String data);

}
