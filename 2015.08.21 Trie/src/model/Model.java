package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

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
        String path = this.getClass().getResource("Dictionary.txt").getPath().replaceAll("%20"," ");

        //if the first character is invalid, delete it.
        if(!Character.isLetter(path.charAt(0)))
            path = path.substring(1);

        //use a stream to read in the file
        try (Stream<String> stream = Files.lines(Paths.get(path))){
            stream.forEach(string -> {
                try(Scanner line = new Scanner(string)) {
                    String word = line.next();
                    trie.addWord(word.toLowerCase(), word.toLowerCase(), line.nextLine());
                    line.close();
                } catch(Exception ignored){
                    //Just don't add the line if we get an error
                }
            });
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the dictionary file");
        } catch (IOException e) {
            System.out.println("Error reading the dictionary file");
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
