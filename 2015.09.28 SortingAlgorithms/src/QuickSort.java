/**
 * An implementation of QuickSort
 */
public class QuickSort implements Sorter{

    public static final QuickSort ONLY = new QuickSort();

    @Override
    public void sort(int[] input) {
        sort(input, 0, input.length);
    }

    /**
     * Helper function to QuickSort.
     *
     * Note that extra space required is only O(1) since there is only one temporary variable used in switching the
     * integers in the array.
     *
     * @param input The input array that needs to be sorted
     * @param start The starting position of the section of the array currently being sorted
     * @param end The ending position of the section of the array currently being sorted
     */
    private void sort(int[] input, int start, int end){
        if(end - start <= 1)
            return;

        //choose a pivot
        int pivot = input[start];

        int i = start;
        int j = end - 1;
        int partition;

        //find the partition and swap elements if they are on the wrong side of the partition
        while(true){
            while(input[j] > pivot)
                j--;

            while(input[i] < pivot)
                i++;

            if(i < j && !(input[i] == input[j])){
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            } else {
                partition = j;
                break;
            }
        }

        //split the array and do QuickSort on each half
        sort(input, start, partition);
        sort(input, partition + 1, end);
    }
}
