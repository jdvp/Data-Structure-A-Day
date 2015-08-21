package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is the model of the Dictionary Search System.
 * It is responsible for parsing the dictionary and creating a dictionary trie
 *
 * @author JD Porterfield
 */
public class Model {

    /**
     * The adapter used to communicate with the view
     */
    IM2VAdapter view;

    /**
     * The root of the Trie for this project
     */
    Trie trie;

    /**
     * The Constructor for the Model object.
     * Sets the adapter to the view
     *
     * @param adapter The adapter used to communicate with the view
     */
    public Model(IM2VAdapter adapter)
    {
        view = adapter;
    }

    /**
     * Starts the model by loading in the dictionary
     */
    public void start(){
        trie = new Trie();

        File file = new File(this.getClass().getResource("Dictionary.txt").getPath().replaceAll("%20"," "));
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner fileReader = new Scanner(in);

        while(fileReader.hasNextLine()){
            String word = fileReader.next();
            String def = fileReader.nextLine();
            trie.addWord(word.toLowerCase(), word.toLowerCase(), def);
            //delete extra line
            fileReader.nextLine();
        }

        fileReader.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches the trie for the specified word. Calls on the view to display the results.
     *
     * @param query The phrase to search for
     */
    public void search(String query){

        view.clearDisplay();
        if(!query.equals("")) {
            Trie result = trie.find(query);
            if (result == null)
                view.displayText("No results found");
            else {
                String res = result.printSubtrees();
                if (res.equals(""))
                    view.displayText("No results found");
                else
                    view.displayText(res);

            }
        } else
            view.displayText("No results found");
    }
}
