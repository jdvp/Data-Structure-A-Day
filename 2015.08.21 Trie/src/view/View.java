package view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;

/**
 * This is the View of the Dictionary Search system.
 * It is responsible for getting input from the user as to which word to search.
 * It is also responsible for displaying the results to the user.
 *
 * @author JD Porterfield
 */
public class View extends JFrame {

    /**
     * The adapter used to communicate with the model
     */
    private IV2MAdapter model;

    /**
     * This is the area that will be used to display search results.
     */
    private JTextPane textArea;

    /**
     * The Constructor for this view object.
     * This sets the adapter and makes sure that the GUI is initialized.
     *
     * @param adapter The adapter used to communicate with the model
     */
    public View(IV2MAdapter adapter) {
        model = adapter;
        initGUI();
    }

    /**
     * Makes the GUI visible so that the user can interact with the system
     */
    public void start(){
        setVisible(true);
    }

    /**
     * Initializes the GUI components of the View.
     */
    public void initGUI(){
        setSize(1000,750);
        setTitle("Digital Dictionary");
        setLayout(new BorderLayout());
        setResizable(false);


        //make control panel
        final JPanel controlPanel = new JPanel(new FlowLayout());
        final JLabel label = new JLabel("Search here: ");
        final JTextField query = new JTextField(30);

        //add a document listener so the search results updates with each typed character
        query.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.searchFor(query.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.searchFor(query.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.searchFor(query.getText());
            }
        });
        controlPanel.add(label);
        controlPanel.add(query);
        add(controlPanel, BorderLayout.NORTH);

        //Create the area used to display search results and pdf links
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea = new JTextPane();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Displays text on the result area
     *
     * @param text The text to display
     */
    public void displayText(String text){
        try{
            Document doc = textArea.getDocument();
            doc.insertString(doc.getLength(), text, null);
        }
        catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clears the result area of text and hyperlinks
     */
    public void clearDisplay(){textArea.setText("");}
}
