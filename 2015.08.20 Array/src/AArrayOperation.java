import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by JD on 8/20/2015.
 */
public abstract class AArrayOperation implements IArrayOperation{

    /**
     * Scanner used to get input from the user about the matrices
     */
    private Scanner in = new Scanner(System.in);

    /**
     * Integer arrays that will hold the user-input matrices
     */
    protected int array1[][];
    protected int array2[][];


    /**
     * Prompts the user to enter a matrix of the specified size
     * @param size the size of the matrix that the user should enter
     * @return an 2-dimensional int array that the user has entered
     */
    public int[][] inputMatrix(int size[]){
        int[][] result = new int[size[0]][size[1]];
        for(int i = 1; i <= size[0]; i++){
            System.out.println("Row "+i+": Enter "+size[1]+" numbers separated by spaces");
            String row = parseInput(in);
            for(int j = 0; j < size[1]; j++){
                result[i-1][j] = Integer.parseInt(row.split(" ")[j]);
            }
        }
        return result;
    }

    /**
     * Prompts the user to enter the size for a matrix
     * @return an array that determines the size of the matrix. Since the matrices are always 2-dimensional,
     * this should always be an array with n = 2
     * @throws MatrixException if the numbers entered aren't valid, a Matrix cannot be formed
     */
    public int[] getMatrixSize() throws MatrixException {
        System.out.println("Enter as two numbers divided by an x (e.g. 2x3)");
        String arrayDim = parseInput(in);

        if(arrayDim.split("x").length > 2)
            throw new MatrixException("Entered too many arguments. Expected 2 args, got "+arrayDim.split("x").length);
        int size[] = new int[2];
        for(int i = 0; i <= 1; i++) {
            size[i] = Integer.parseInt(arrayDim.split("x")[i]);
            if(size[i] <= 0 || size[i] <= 0){
                throw new MatrixException("0 or below is not a valid row or column count");
            }
        }
        return size;
    }

    /**
     * Wrapper for Scanner.nextLine to see if the user is ready to exit the program.
     * @param s The Scanner to get the user input
     * @return The user's input String if the user has not specified to exit the program
     */
    public static String parseInput(Scanner s){
        String out = s.nextLine();
        if(out.contains("exit")){
            System.exit(0);
        }
        return out;
    }

    /**
     * Prints the array calculation in an easy, human readable format.
     * @param op The operation that was used
     * @param a1 The first matrix used in the operation
     * @param a2 The second matrix used in the operation
     * @param res The result of doing the specified operation on the two matrices
     */
    protected void prettyPrintArrayOp(String op, int[][] a1, int[][] a2, int[][] res){

        //Create String containers for the arrays to be placed into
        //and also get the 'pretty' form of the individual matrices
        String s1[] = prettyPrintSingleArray(a1);
        String s2[] = prettyPrintSingleArray(a2);
        String s3[] = prettyPrintSingleArray(res);

        //if the matrices have a different amount of rows, then formatting must be done to ensure that
        //the matrices are centered in relation to each other's number of rows
        if(!(s1.length == s2.length)){

            //if the first matrix has less rows than the second
            if(s1.length < s2.length) {
                String tempS1[] = new String[s2.length];
                String tempS3[] = new String[s2.length];
                int diff = (s2.length - s1.length);
                int offset = diff / 2;


                char[] c = new char[s1[0].length()];
                Arrays.fill(c, ' ');

                //pad the top and bottom of the first matrix
                for (int i = 0; i < offset; i++)
                    tempS1[i] = new String(c);
                for (int i = offset; i < offset + a1.length; i++)
                    tempS1[i] = s1[i - offset];
                for (int i = offset + a1.length; i < tempS1.length; i++)
                    tempS1[i] = new String(c);

                c = new char[s3[0].length()];
                Arrays.fill(c, ' ');

                //pad the top and bottom of the last matrix
                for (int i = 0; i < offset; i++)
                    tempS3[i] = new String(c);
                for (int i = offset; i < offset + a1.length; i++)
                    tempS3[i] = s3[i -offset];
                for (int i = offset + a1.length; i < tempS3.length; i++)
                    tempS3[i] = new String(c);

                s1 = tempS1;
                s3 = tempS3;
            } else {
                //if the second matrix has less rows than the first
                String tempS2[] = new String[s1.length];
                int diff = (s1.length - s2.length);
                int offset = diff / 2;

                char[] c = new char[s2[0].length()];
                Arrays.fill(c, ' ');

                //pad the top and bottom of the second matrix
                for(int i = 0; i < offset; i++)
                    tempS2[i] = new String(c);
                for(int i = offset; i < offset + a2.length; i++)
                    tempS2[i] = s2[i - offset];
                for(int i = offset + a2.length; i < tempS2.length; i++)
                    tempS2[i] = new String(c);

                s2 = tempS2;
            }

        }

        //print the computation
        for(int i = 0; i < s1.length; i++){
            System.out.println(s1[i]+"\t"+(i == s1.length/2?op:" ")+"\t" +
                    s2[i]+"\t"+(i == s1.length/2?"=":" ")+"\t"+s3[i]);
        }
    }

    /**
     * Method that is used for prettily printing a single array.
     *
     * @param arr The array to print
     * @return A string version of the array to later be output
     */
    private String[] prettyPrintSingleArray(int[][] arr){

        String [] result = new String[arr.length];

        for(int i = 0; i < arr.length; i++){
            result[i] = "[";
            //Add padding to a digit if it takes up less space than the other numbers in its column.
            //This way, all of the columns are aligned to their left
            for(int j = 0; j < arr[0].length; j++){
                int dig = mostDigitsInColumn(arr, j);
                int myDig = ((int)(Math.log10(Math.abs(arr[i][j]))+ 1));
                if(arr[i][j] < 0)
                    myDig++;
                String thisInd = arr[i][j] + padding(dig - myDig);
                result[i] += thisInd;
                if(j != arr[0].length - 1)
                    result[i] += "  ";
            }
            result[i] += "]";
        }

        return result;
    }

    /**
     * Calculates the number of digits in the widest number in a specified column in a specified array.
     * @param arr The array from which we are taking a column.
     * @param col The column in which we are finding the widest number
     * @return The number of digits that the widest number has.
     */
    private int mostDigitsInColumn(int[][] arr, int col){
        int digits = 0;
        for(int i = 0; i < arr.length; i++){
            int thisNumDigits = (int)(Math.log10(Math.abs(arr[i][col])) + 1);
            if(arr[i][col] < 0)
                thisNumDigits++;
            if(thisNumDigits > digits)
                digits = thisNumDigits;
        }

        return digits;
    }

    /**
     * Returns the necessary amount of padding to ensure that a number aligns properly to others in the same column
     * @param num The number of spaces to add
     * @return A pad which consists of a number of spaces
     */
    private String padding(int num){

        String pad = "";

        for(int x = 0; x < num; x++)
            pad += " ";

        return pad;
    }

    public int[][] testCompute(int[][] arr1, int[][] arr2){
        array1 = arr1;
        array2 = arr2;
        return compute();
    }
}
