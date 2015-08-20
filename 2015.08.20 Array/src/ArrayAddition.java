/**
 * Array Operation that allows users to add two matrices
 */
public class ArrayAddition extends AArrayOperation {

    /**
     * The constructor for array addition. Prompts the user for one matrix size (since matrices in matrix addition
     * must be the same size) and two matrices.
     *
     * @param userInput states whether we need user input or if this is a test
     */
    public ArrayAddition(boolean userInput) throws MatrixException {

        if(userInput) {
            System.out.println("You chose matrix addition. What size would you like the matrices to add to be? ");
            int[] size = getMatrixSize();
            System.out.println("Enter values for the first matrix");
            array1 = inputMatrix(size);
            System.out.println("Enter values for the second matrix");
            array2 = inputMatrix(size);
        }
    }

    /**
     * The constructor for array addition if the user has chosen to the array from the previous operation
     *
     * @param saved The previously saved array
     * @throws MatrixException
     */
    public ArrayAddition(int[][] saved) throws MatrixException {
        array1 = saved;
        System.out.println("You chose matrix subtraction with a saved matrix of size "+saved.length+"x"+saved[0].length);
        System.out.println("Enter values for the second matrix");
        array2 = inputMatrix(new int[]{saved.length, saved[0].length});
    }

    @Override
    public int[][] compute() {

        int result[][] = new int[array1.length][array1[0].length];

        //add the arrays
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array1[0].length; j++){
                result[i][j] = array1[i][j] + array2[i][j];
            }
        }


        prettyPrintArrayOp("+",array1, array2, result);
        return result;
    }


}
