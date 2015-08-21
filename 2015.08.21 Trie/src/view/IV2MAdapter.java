package view;


/**
 * The adapter used by the view to communicate
 * with the model
 *
 * @author JD Porterfield
 */
public interface IV2MAdapter {

    /**
     * Null adapter
     */
    IV2MAdapter NULL_ADAPTER = new IV2MAdapter() {

        public void searchFor(String query){}
    };


    /**
     * Calls on the model to search for a specified input query
     *
     * @param query The query that we are searching for
     */
    void searchFor(String query);
}