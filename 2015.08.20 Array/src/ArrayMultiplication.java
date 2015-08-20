/**
 * Array operation that allows users to multiply matrices
 */
public class ArrayMultiplication extends AArrayOperation{

    /**
     * Constructor that asks the user for sizes and creates the matrices to multiply
     *
     * @param userInput determines whether the user needs to input the matrices or if this is a test
     * @throws MatrixException
     */
    public ArrayMultiplication(boolean userInput) throws MatrixException {
        if(userInput) {
            System.out.println("You chose matrix multiplication. What size would you like the first matrix to be? ");
            int[] size = getMatrixSize();
            System.out.println("Enter values for the first matrix");
            array1 = inputMatrix(size);
            getSecondMatrix(size[1]);
        }
    }

    /**
     * Constructor used if the user decides to use the last matrix for this operation
     *
     * @param saved The result of the last matrix operation
     * @throws MatrixException
     */
    public ArrayMultiplication(int[][] saved) throws MatrixException {
        array1 = saved;
        System.out.println("You chose matrix multiplication with a saved matrix.");
        getSecondMatrix(array1[0].length);
    }

    @Override
    public int[][] compute() {

        int[][] result = new int[array1.length][array2[0].length];

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){

                result[i][j] = 0;
                for(int x = 0; x < array1[0].length; x++){
                        result[i][j] += (array1[i][x] * array2[x][j]);
                }
            }
        }

        prettyPrintArrayOp("*", array1, array2, result);

        return result;
    }

    /**
     * Gets the second matrix regardless of how the first was input (saved or user-input)
     *
     * @param rows the number of rows that the second matrix must have
     */
    private void getSecondMatrix(int rows) throws MatrixException {
        System.out.println("What size would you like the second matrix to be? Number of rows must equal "+rows);
        int[] size = getMatrixSize();

        if(size[0] != rows)
            throw new MatrixException("Number of columns in first matrix must equal number of rows in second matrix");

        System.out.println("Enter values for the second matrix");
        array2 = inputMatrix(size);
    }
}
