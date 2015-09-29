/**
 * An implementation of BubbleSort
 */
public class BubbleSort implements Sorter {

    /**
     * A Singleton since I only want one BubbleSort object
     */
    public static final BubbleSort ONLY = new BubbleSort();


    @Override
    public void sort(int[] input) {

        for(int i = 0; i < input.length - 1; i++){

            //don't have to go all the way to the end, since we know the greatest remaining element will be shifted
            //to the end during each iteration
            for(int j = 0; j < input.length - (i + 1); j++)
            {
                if(input[j] > input[j + 1]){
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
    }
}
