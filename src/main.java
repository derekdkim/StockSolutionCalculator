import java.util.Scanner;


public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Set-up input scanner.


        double c1 = 0, c2, v1, v2, result; //Set up operation variables;
        String operation; //menu to determine which is the desired variable;

        //Determine whicih operation to perform.
        System.out.println("Which variable would you like to calculate?");
        System.out.print("Enter c1 (initial concentration), c2 (final concentration), v1 (initial volume), or v2 (final volume): ");
        operation = input.nextLine();

        //Initial concentration calculation
        if (operation.equals("c1")) {

            //Enter c2.
            System.out.print("Enter the final concentration: ");
            c2 = input.nextDouble();

            //Enter v1.
            System.out.print("Enter the initial volume: ");
            v1 = input.nextDouble();

            //Enter v2.
            System.out.print("Enter the final volume: ");
            v2 = input.nextDouble();

            //Calculation
            result = (c2 * v2) / v1 ;

            //Display result.
            System.out.println(result);

        } else if (operation.equals("c2")) {

            //Enter c1.
            System.out.print("Enter the initial concentration: ");
            c2 = input.nextDouble();

            //Enter v1.
            System.out.print("Enter the initial volume: ");
            v1 = input.nextDouble();

            //Enter v2.
            System.out.print("Enter the final volume: ");
            v2 = input.nextDouble();

            //Calculation
            result = (c1 * v1) / v2 ;

            //Display result.
            System.out.println(result);

        } else if (operation.equals("v1")) {

            //Enter c1.
            System.out.print("Enter the initial concentration: ");
            c2 = input.nextDouble();

            //Enter c2.
            System.out.print("Enter the final concentration ");
            v1 = input.nextDouble();

            //Enter v2.
            System.out.print("Enter the final volume: ");
            v2 = input.nextDouble();

            //Calculation
            result = (c2 * v2) / c1 ;

            //Display result.
            System.out.println(result);

        } else if (operation.equals("v2")) {

            //Enter c1.
            System.out.print("Enter the initial concentration: ");
            c2 = input.nextDouble();

            //Enter c2.
            System.out.print("Enter the final concentration ");
            v1 = input.nextDouble();

            //Enter v1.
            System.out.print("Enter the initial volume: ");
            v2 = input.nextDouble();

            //Calculation
            result = (c1 * v1) / c2 ;

            //Display result.
            System.out.println(result);

        } else {
            System.out.println("Please select a valid operation.");
        }

    }
}
