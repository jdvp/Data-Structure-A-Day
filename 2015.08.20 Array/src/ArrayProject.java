import java.util.Scanner;

/**
 * I will learn about Arrays in this project. This file will be used to run the program.
 */
public class ArrayProject {

    public static void main(String args[]){

        System.out.println("WELCOME TO THE MATRIX WIZARD FOR MATRIX OPERATIONS");
        System.out.println("Type 'exit' and enter to exit at any time.");
        System.out.println("**************************************************");
        
        int[][] storedMatrix = new int[0][0];
        boolean savedMatrix = false;
        while(true) {
            System.out.println("\n\nWhich array operation would you like to use? \n\tMatrix Addition : 0\n\tMatrix Subtraction : 1" +
                    "\n\tMatrix Multiplication : 2");

            int[][] result = new int[0][0];
            try {

                IArrayOperation op;
                if(savedMatrix) {
                    switch (Integer.parseInt(parseInput(new Scanner(System.in)))) {
                        case 0:
                            op = new ArrayAddition(storedMatrix);
                            result = op.compute();
                            break;
                        case 1:
                            op = new ArraySubtraction(storedMatrix);
                            result = op.compute();
                            break;
                        case 2:
                            op = new ArrayMultiplication(storedMatrix);
                            result = op.compute();
                            break;
                        default:
                            System.out.println("Not a valid choice");
                    }
                } else {
                    switch (Integer.parseInt(parseInput(new Scanner(System.in)))) {
                        case 0:
                            op = new ArrayAddition(true);
                            result = op.compute();
                            break;
                        case 1:
                            op = new ArraySubtraction(true);
                            result = op.compute();
                            break;
                        case 2:
                            op = new ArrayMultiplication(true);
                            result = op.compute();
                            break;
                        default:
                            System.out.println("Not a valid choice");
                    }
                }

                savedMatrix = false;

                System.out.println("Would you like to use the result for another computation? y/n");
                String choice = parseInput(new Scanner(System.in));
                if(choice.equals("y")) {
                    storedMatrix = result;
                    savedMatrix = true;
                } else if(!choice.equals("n"))
                    throw new MatrixException("Not a valid choice");

            } catch (Exception e){
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }

    }

    public static String parseInput(Scanner s){
        String out = s.nextLine();
        if(out.contains("exit")){
            System.exit(0);
        }
        return out;
    }
}

class MatrixException extends Exception{
    public MatrixException(String s){
        super(s);
    }
}