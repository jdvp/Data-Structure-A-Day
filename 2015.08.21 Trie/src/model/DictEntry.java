package model;

/**
 * Created by JD on 8/20/2015.
 */
public class DictEntry {

    private String entry;
    private String value;

    public DictEntry(String word, String def){
        entry = word;
        value = def;
    }

    public String getEntry(){return entry;}

    public String getValue(){return value;}
}
