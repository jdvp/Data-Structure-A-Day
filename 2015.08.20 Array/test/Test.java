import junit.framework.TestCase;

/**
 * Created by JD on 8/20/2015.
 */
public class Test extends TestCase {
    public void testMatrixAddition(){
        int array1[][] = new int[][]{{1, 1, 1},
                                     {2, 5, 3}};

        int array2[][] = new int[][]{{23, 16, -12},
                                     {-2, -5, -3 }};

        int result[][] = new int[][]{{24, 17, -11},
                                     {0,  0,  0  }};
        AArrayOperation a = null;
        try {
            a = new ArrayAddition(false);
        } catch (Exception e){
            fail(e.toString());
        }
        int[][] computeResult = a.testCompute(array1, array2);
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 3; j++)
                assertEquals(result[i][j], computeResult[i][j]);
    }

    public void testMatrixSubtraction(){
        int array1[][] = new int[][]{{10, 10, 12},
                                     {21, 54, 34}};

        int array2[][] = new int[][]{{23, 16, -12},
                                     {-2, -5, -3 }};

        int result[][] = new int[][]{{-13, -6, 24},
                                     {23,  59, 37}};

        AArrayOperation a = null;
        try {
            a = new ArraySubtraction(false);
        } catch (Exception e){
            fail(e.toString());
        }
        int[][] computeResult = a.testCompute(array1, array2);
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 3; j++)
                assertEquals(result[i][j], computeResult[i][j]);
    }

    public void testMatrixMultiplication(){
        int array1[][] = new int[][]{{5,   -4},
                                     {-95, 4 },
                                     {16,  8}};

        int array2[][] = new int[][]{{-1},
                                     {1 }};

        int result[][] = new int[][]{{-9},
                                     {99},
                                     {-8 }};

        AArrayOperation a = null;
        try {
            a = new ArrayMultiplication(false);
        } catch (Exception e){
            fail(e.toString());
        }
        int[][] computeResult = a.testCompute(array1, array2);
            for(int j = 0; j < 3; j++)
                assertEquals(result[j][0], computeResult[j][0]);
    }
}
