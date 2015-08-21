package model;

import java.util.ArrayList;

/**
 * My Java Implementation of a Trie
 */
public class Trie {
    private Character myLetter;
    private ArrayList<Trie> children;
    private DictEntry entry;

    /**
     * Constructor that creates a Trie node. Takes in a character which defines the "path" that this node is on.
     * The character is null if this is the root
     * @param c
     */
    public Trie(Character c){
        myLetter = c;
        children = new ArrayList<>();
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
        if(word.equals(""))
            entry = new DictEntry(origWord, def);
        else{
            Trie trie;
            int ind = children.indexOf(new Trie(word.charAt(0)));
            if(ind == -1) {
                trie = new Trie(word.charAt(0));
                children.add(trie);
            } else {
                trie = children.get(ind);
            }
            trie.addWord(origWord, word.substring(1), def);
        }
    }

    /**
     * Gets the letter that is associated with this node
     * @return
     */
    public Character getLetter(){return myLetter;}

    @Override
    public boolean equals(Object other){
        if(other instanceof Trie) {
            if (myLetter.equals(((Trie)other).getLetter()))
                return true;
            return false;
        }
        return false;
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
            int ind = children.indexOf(new Trie(word.charAt(0)));
            if(ind == -1)
                return null;
            return children.get(ind).find(word.substring(1));
        }
    }

    /**
     * Returns the dictionary entry for this node
     *
     * @return
     */
    public DictEntry getEntry(){
        return entry;
    }

    public String printSubtrees(){
        String s = "";
        if(entry != null){
            s += entry.getEntry() + " : " + entry.getValue()+"\n";
        }
        String alpahabet = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = alpahabet.toCharArray();
        for(char c : chars){
            int ind = children.indexOf(new Trie(c));
            if(ind == -1)
                continue;
            else {
                s += children.get(ind).printSubtrees();
            }
        }

        return s;
    }
}
