/**
 * Array operation that allows users to subtract one matrix from another
 */
public class ArraySubtraction extends AArrayOperation{

    /**
     * The constructor for array subtraction. Prompts the user for one matrix size (since matrices in matrix subtraction
     * must be the same size) and two matrices.
     *
     * @param userInput states whether we require user input (or if this a test)
     */
    public ArraySubtraction(boolean userInput) throws MatrixException {
        if(userInput) {
            System.out.println("You chose matrix subtraction. What size would you like the matrices to add to be? ");
            int[] size = getMatrixSize();
            System.out.println("Enter values for the first matrix");
            array1 = inputMatrix(size);
            System.out.println("Enter values for the second matrix");
            array2 = inputMatrix(size);
        }
    }

    /**
     * Constructor used if the user has specified to use the result of the last matrix operation
     * @param saved The result of the last operation
     * @throws MatrixException
     */
    public ArraySubtraction(int[][] saved) throws MatrixException {
        array1 = saved;
        System.out.println("You chose matrix subtraction with a saved matrix of size "+saved.length+"x"+saved[0].length);
        System.out.println("Enter values for the second matrix");
        array2 = inputMatrix(new int[]{saved.length, saved[0].length});
    }

    @Override
    public int[][] compute() {
        int result[][] = new int[array1.length][array1[0].length];

        //subtracts the second array from the first
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array1[0].length; j++){
                result[i][j] = array1[i][j] - array2[i][j];
            }
        }

        prettyPrintArrayOp("-",array1, array2, result);
        return result;
    }
}
