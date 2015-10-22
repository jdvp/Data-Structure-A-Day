import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Used to test the multiple sort routines that I made
 */
public class Test extends TestCase {

    public void testBubbleSort(){
        int sortMe[] = {5, 4, 13, 2, 4, 6, 9, 10, 12, 34};
        int answer[] = {2, 4, 4, 5, 6, 9, 10, 12, 13, 34};
        BubbleSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }

    public void testBubbleEmpty(){
        int sortMe[] = {};
        int answer[] = {};
        BubbleSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }

    public void testBubbleSortReverse(){
        int sortMe[] = {99, 94, 54, 34, 23, 12, 11, 8, 4, 2, 1};
        int answer[] = {1, 2, 4, 8, 11, 12, 23, 34, 54, 94, 99};
        BubbleSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }

    public void testMergeSort(){
        int sortMe[] = {5, 4, 13, 2, 4, 6, 9, 10, 12, 34};
        int answer[] = {2, 4, 4, 5, 6, 9, 10, 12, 13, 34};
        MergeSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }

    public void testMergeEmpty(){
        int sortMe[] = {};
        int answer[] = {};
        MergeSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }

    public void testMergeSortReverse(){
        int sortMe[] = {99, 94, 54, 34, 23, 12, 11, 8, 4, 2, 1};
        int answer[] = {1, 2, 4, 8, 11, 12, 23, 34, 54, 94, 99};
        MergeSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }

    public void testQuickSort(){
        int sortMe[] = {5, 4, 13, 2, 4, 6, 9, 10, 12, 34};
        int answer[] = {2, 4, 4, 5, 6, 9, 10, 12, 13, 34};
        QuickSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }

    public void testQuickEmpty(){
        int sortMe[] = {};
        int answer[] = {};
        QuickSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }

    public void testQuickSortReverse(){
        int sortMe[] = {99, 94, 54, 34, 23, 12, 11, 8, 4, 2, 1};
        int answer[] = {1, 2, 4, 8, 11, 12, 23, 34, 54, 94, 99};
        QuickSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }


    public void testQuickSortLotsOfDuplicates(){
        int sortMe[] = {5, 4, 4, 4, 4, 4, 4, 13, 2, 6, 1, 1, 4, 4, 4, 4, 4, 6, 9, 10, 12, 34};
        int answer[] = {1, 1, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 6, 9, 10, 12, 13, 34};
        System.out.println("Arrays.toString(sortMe) = " + Arrays.toString(sortMe));
        QuickSort.ONLY.sort(sortMe);
        assertTrue(Arrays.equals(sortMe, answer));
    }

}
