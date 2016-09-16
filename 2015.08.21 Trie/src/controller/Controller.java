package controller;

import model.IM2VAdapter;
import model.Model;
import view.IV2MAdapter;
import view.View;

import java.awt.*;

/**
 * This is the controller of the system.
 * It is capable of creating and maintaining the model and the view of the system.
 *
 * @author JD Porterfield
 */
public class Controller {


    /**
     * The Model object of the system
     */
    private Model model = new Model(IM2VAdapter.NULL_ADAPTER);
    /**
     * The View object of the system
     */
    private View view = new View(IV2MAdapter.NULL_ADAPTER);

    /**
     * The constructor for a controller object. The purpose of this constructor is to make sure that the model
     * and view are properly created and related to each other through proper adapters.
     */
    public Controller(){
        model = new Model(new IM2VAdapter() {

            public void displayText(String text){
                view.displayText(text);
            }

            public void clearDisplay(){
                view.clearDisplay();
            }

        });

        view = new View(query -> model.search(query));
    }

    /**
     * Calls on the model and void to start
     */
    public void start(){
        model.start();
        view.start();
    }

    /**
     * Creates and starts a Controller object
     *
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                Controller controller = new Controller();
                controller.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
