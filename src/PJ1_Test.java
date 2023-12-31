/*  This program is used to test PJ2.Fracition class
 *  More info are given in Readme file
 */

import java.util.*;
import PJ1.*;

class PJ1_Test
{
    static private Scanner scanner;

    private static Fraction readFraction() {
        System.out.print( "\nTry to read a fraction x/y, please enter x y : " );
        int numerator = scanner.nextInt();
        int denominator = scanner.nextInt();
        Fraction f = new Fraction(numerator, denominator);
        System.out.println( "\t\tRead OK:"+f);
        return f;
    }

    private static void printOperations() {
        System.out.println("==============================================");
        System.out.println("\nOperations:");
        System.out.println("  0) exit \n  1) add \t2) subtract \t3) multiply \t4) divide\t5) compareTo");
        System.out.println("  6) equals \t7) simplify \t8) toDouble \t9) setFraction ");
        System.out.print( "\nEnter an operation number: ");
    }

    public static void main( String args[] )
    {
        scanner = new Scanner( System.in ); // scanner for input
        boolean continueLoop = true; // determines if more input is needed
        Fraction n1=null;
        Fraction n2=null;
        int op,x,y;

        do
        {
            try // read two numbers and calculate quotient
            {
                printOperations();
                op= scanner.nextInt();

                if (op == 0) {
                    break;
                } else if ((op >0) && (op <7)) {
                    n1 = readFraction();
                    n2 = readFraction();
                } else if ((op >= 7) && (op <= 8)) {
                    n1 = readFraction();
                } else if (op ==  9) {
                    n1 = new Fraction();
                } else {
                    System.out.print( "\nInvalid input... try again\n" );
                    continue;
                }

                System.out.println("\nTests:\n");
                switch (op) {
                    case 1:
                        System.out.println("\t" + n1 + " + " + n1 + " = " + n1.add(n1));
                        System.out.println("\t" + n2 + " + " + n2 + " = " + n2.add(n2));
                        System.out.println("\t" + n1 + " + " + n2 + " = " + n1.add(n2));
                        System.out.println("\t" + n2 + " + " + n1 + " = " + n2.add(n1));
                        break;
                    case 2:
                        System.out.println("\t" + n1 + " - " + n1 + " = " + n1.subtract(n1));
                        System.out.println("\t" + n2 + " - " + n2 + " = " + n2.subtract(n2));
                        System.out.println("\t" + n1 + " - " + n2 + " = " + n1.subtract(n2));
                        System.out.println("\t" + n2 + " - " + n1 + " = " + n2.subtract(n1));
                        break;
                    case 3:
                        System.out.println("\t" + n1 + " * " + n1 + " = " + n1.multiply(n1));
                        System.out.println("\t" + n2 + " * " + n2 + " = " + n2.multiply(n2));
                        System.out.println("\t" + n1 + " * " + n2 + " = " + n1.multiply(n2));
                        System.out.println("\t" + n2 + " * " + n1 + " = " + n2.multiply(n1));
                        break;
                    case 4:
                        System.out.println("\t" + n1 + " / " + n1 + " = " + n1.divide(n1));
                        System.out.println("\t" + n2 + " / " + n2 + " = " + n2.divide(n2));
                        System.out.println("\t" + n1 + " / " + n2 + " = " + n1.divide(n2));
                        System.out.println("\t" + n2 + " / " + n1 + " = " + n2.divide(n1));
                        break;
                    case 5:
                        System.out.println("\t" + n1 + " ct " + n1 + " = " + n1.compareTo(n1));
                        System.out.println("\t" + n2 + " ct " + n2 + " = " + n2.compareTo(n2));
                        System.out.println("\t" + n1 + " ct " + n2 + " = " + n1.compareTo(n2));
                        System.out.println("\t" + n2 + " ct " + n1 + " = " + n2.compareTo(n1));
                        break;
                    case 6:
                        System.out.println("\t" + n1 + " eq "+ n1 + " = " + n1.equals(n1));
                        System.out.println("\t" + n2 + " eq "+ n2 + " = " + n2.equals(n2));
                        System.out.println("\t" + n1 + " eq "+ n2 + " = " + n1.equals(n2));
                        System.out.println("\t" + n2 + " eq "+ n1 + " = " + n2.equals(n1));
                        break;

                    case 7:
                        System.out.print("\t" + n1 + " simplify= ");
                        System.out.println(n1.simplify());
                        break;
                    case 8:
                        System.out.println("\t" + n1 + " toDouble = " + n1.toDouble());
                        break;
                    case 9:
                        System.out.print( "read a fraction x/y, please enter x y : " );
                        x = scanner.nextInt();
                        y = scanner.nextInt();
                        System.out.print("\t" + x +"/"+ y + " setFraction = ");
                        n1.setFraction(x,y);
                        System.out.println(n1);
                        break;
                }

            } // end try
            catch ( FractionException fracitonException )
            {
                System.err.printf( "\nFraction Exception: %s\n", fracitonException );
            } // end catch
        } while ( continueLoop ); // end do...while
    } // end main
} // end class






