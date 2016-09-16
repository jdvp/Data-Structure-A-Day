package model;

/**
 * My Java Implementation of a Trie
 */
public class Trie {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private Trie[] children;
    private DictEntry entry;

    /**
     * Constructor that creates a Trie node. Takes in a character which defines the "path" that this node is on.
     * The character is null if this is the root
     */
    public Trie(){
        children = new Trie[26];
        entry = null;
    }

    /**
     * Adds a word to the Trie through recursion.
     *
     * @param origWord The word as it was originally (just for ease in storing the word)
     * @param word The word as is left to find a position in the tree
     * @param def The definition of the word
     */
    public void addWord(String origWord, String word, String def){
        try {
            if (word.equals(""))
                entry = new DictEntry(origWord, def);
            else {
                Trie trie = children[alphabet.indexOf(word.charAt(0))];
                if (trie == null) {
                    trie = new Trie();
                    children[alphabet.indexOf(word.charAt(0))] = trie;
                }
                trie.addWord(origWord, word.substring(1), def);
            }
        }catch (Exception e){
            //Caught word with unacceptable character. Characters must be only a-z
        }
    }

    /**
     * Returns a dictionary entry according to the specified word
     *
     * @param word The entry to find
     * @return The dictionary definition of the input word
     */
    public Trie find(String word){
        if(word.equals(""))
            return this;
        else{
            Trie trie = children[alphabet.indexOf(word.charAt(0))];
            if(trie == null)
                return null;
            return trie.find(word.substring(1));
        }
    }

    public String printSubtrees(){
        String s = "";
        if(entry != null){
            s += entry.getEntry() + " : " + entry.getValue()+"\n";
        }

        for(Trie trie : children){
            if(trie != null)
                s += trie.printSubtrees();
        }

        return s;
    }
}
