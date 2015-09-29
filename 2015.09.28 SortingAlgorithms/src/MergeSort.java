/**
 * An implementation of MergeSort
 */
public class MergeSort implements Sorter {

    public static final MergeSort ONLY = new MergeSort();

    @Override
    public void sort(int[] input) {

        sort(input, 0, input.length, new int[input.length]);
    }

    /**
     * Helper function for Merge Sorting
     * @param input The input array that needs to be sorted
     * @param start The starting position of the portion of the array to sort
     * @param end The ending position of the portion of the array to sort
     * @param workArray An array used to store temporary results
     */
    private void sort(int[] input, int start, int end ,int workArray[]){

        //if there is only one item in the current portion to sort, it is sorted
        if(end - start <= 1)
            return;

        //split and sort the first and second half
        sort(input, start, (end + start) / 2, workArray);
        sort(input, ((end + start) / 2), end, workArray);

        int firstPos = start;
        int secondPos = (end + start) / 2;

        //sort the current section of the array and store it in the temporary array
        for(int i = start; i < end; i++){
            if(firstPos < (end + start) / 2 && (secondPos >= end || input[firstPos] <= input[secondPos])){
                workArray[i] = input[firstPos];
                firstPos ++;
            } else {
                workArray[i] = input[secondPos];
                secondPos ++;
            }
        }

        //copy the newly sorted potion of the array from the working array to the input array
        System.arraycopy(workArray, start, input, start, end - start);
    }
}
