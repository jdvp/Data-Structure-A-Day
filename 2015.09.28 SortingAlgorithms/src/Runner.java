import java.util.Arrays;

/**
 * Created by JD on 9/28/2015.
 */
public class Runner {

    public static void main(String args[]){
        int sortMe[] = {5, 4, 13, 2, 4, 6, 9, 10, 12, 34};

        BubbleSort.ONLY.sort(sortMe);
        System.out.println("Arrays.toString(sortMe) = " + Arrays.toString(sortMe));
    }
}
