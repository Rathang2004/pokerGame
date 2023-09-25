/*************************************************************************************
 *
 * This class represents a fraction whose numerator and denominator are integers.
 *
 * Requirements:
 * 1. Implement interfaces: FractionInterface and Comparable (i.e. compareTo())
 * 2. Implement methods equals() and toString() from class Object
 * 3. Must work for both positive and negative fractions
 * 5. Must simplify result fraction for operations add(), subtract(), multiply() and divide()
 * 6. Must throw FractionException objects in case of errors,
 *    do not throw other exception objects
 * 7. Must not add new or modify existing data fields
 * 8. Must not add new public methods
 * 9. May add private methods
 *
 * Hints:
 *
 * 1. To reduce a fraction such as 4/8 to lowest terms, you need to divide both
 *    the numerator and the denominator by their greatest common denominator.
 *    The greatest common denominator of 4 and 8 is 4, so when you divide
 *    the numerator and denominator of 4/8 by 4, you get the fraction 1/2.
 *    The recursive method GCD() which finds the greatest common denominator of
 *    two positive integers is given (see code)
 *
 * 2. You need to downcast reference parameter FractionInterface to Fraction if
 *    you want to use it as Fraction. See add, subtract, multiply and divide methods
 *
 * 3. Use "this" to access this object if it is needed
 *
 ************************************************************************************/

package PJ1;

import java.sql.SQLOutput;

public class Fraction implements FractionInterface, Comparable<Fraction>
{
    // integer numerator and denominator
    private	int num; // instance variable

    private	int den; // instance variable



    public Fraction()
    {
        num = 0; // we set numerator as a default of 0
        den = 1; // we set denominator as a default of 1
        toString(); // prints the fraction when this method is called
        // implement this method!
        // set fraction to default = 0/1
    }	// end default constructor

    public Fraction(int num, int den)
    {
        this.num = num; //  the numerator is set to what is declared in the object
        this.den = den; //  the denominator is set to what is declared in the object
        if (den == 0) // if denominator is 0, it throws a exception; cause fractions can't have 0 for den
        {
            throw new FractionException("Error: Denominator is 0.");
        }
        else
        {
            toString();// prints fraction
        }
        // implement this method!
        // return FractionException if initial denominator is 0
    }	// end constructor

    public void setFraction(int newNum, int newDen)
    {
        num = newNum; // sets the value of a numerator
        den = newDen; // sets the value of a denominator
        if (newDen == 0) // throws exception if u try to set it to 0
        {
            throw new PJ1.FractionException("Divisor is 0.");
        }
        else
        {
            toString(); // prints the fraction
        }
        // implement this method!
        // return FractionException if initial denominator is 0
    }	// end setFraction
    public FractionInterface simplify()
    {
        // I created a gcf formula, but later saw prof u gave a method
        // but u said it's ok that I can just use this so I kept it
        int gcf = 1;
        // we create temporary num and den values to to alter them to find gcf.
        int temp1 = this.num;
        int temp2 = this.den;
        if(temp1 < 0) // sets num to +
        {
              temp1 = num * -1;
        }
        if(temp2 < 0) // sets den to +
        {
            temp2 = den * -1;
        }
        // loops through and finds the gcf, by finding  greatest number that presents a remainder
        // of 0 for both num and den
        for(int i = 1; i <= temp1; i++)
        {
            if((temp1 % i == 0) && (temp2 % i == 0))
            {
                gcf = i;
            }
        }
        // next 3 cases essentially just change the - # to the den
        if(num < 0 && den < 0)
        {
            temp1 = num / gcf * -1;
            temp2 = den / gcf * -1;
        }
        else if(den < 0)
        {
            temp1= num / gcf * -1;
            temp2 = den / gcf * -1;
        }
        else
        {
            temp1 = num / gcf;
            temp2 = den / gcf;
        }
        Fraction object1 = new Fraction(temp1,temp2);
        // implement this method!
        // 1. Adjusts the signs of the num and den so that the num's sign
        //    is the sign of the fraction and the den's sign is positive value.
        // 2. Reduce the number: compute GCD of num & den
        //    num/GCD and den/GCD
        // return this fraction object
        return object1;

    }

    public double toDouble()
    {
        // implement this method!
        // return double floating point value
        double answer = (1.0 * num) / den; // casts int into double
        return answer;
    }	// end toDouble

    public FractionInterface add(FractionInterface secondFraction)
    {
        // implement this method!
        // a/b + c/d is (ad + cb)/(bd)
        /**int num2 = secondFraction.getNumerator();
        int den2 = secondFraction.getDenominator();
        int finalNum = (num*den2 + num2*den);
        int finalDen = (den*den2);
        FractionInterface finalAns = new Fraction();
        finalAns.setFraction(finalNum, finalDen);
        return finalAns;**/
        // downcast to Fraction
        // then that allows us to use that object to call the num and den
         Fraction other = (Fraction) secondFraction;
         Fraction temp = new Fraction(this.num, this.den);
         int newNum = (temp.num * other.den) + (other.num *temp.den);
         int newDen = (temp.den * other.den);
         temp.setFraction(newNum, newDen); // sets fraction
         return(temp.simplify()); // simplifies it



    }	// end add

    public FractionInterface subtract(FractionInterface secondFraction)
    {
        // implement this method!
        // a/b - c/d is (ad - cb)/(bd)
        // same process as add method but it's subracting
        Fraction other = (Fraction) secondFraction;
        Fraction temp = new Fraction(this.num, this.den);
        int newNum = (temp.num * other.den) - (other.num *temp.den);
        int newDen = (temp.den * other.den);
        temp.setFraction(newNum, newDen);
        return(temp.simplify());
    }	// end subtract

    public FractionInterface multiply(FractionInterface secondFraction)
    {
        // implement this method!
        // a/b * c/d is (ac)/(bd)
        // same process as add method but it's multiplying
        Fraction other = (Fraction) secondFraction;
        Fraction temp = new Fraction(this.num, this.den);
        int newNum = (temp.num * other.num);
        int newDen = (temp.den * other.den);
        temp.setFraction(newNum, newDen);
        return(temp.simplify());
    }	// end multiply

    public FractionInterface divide(FractionInterface secondFraction)
    {
        // implement this method!
        // return FractionException if secondFraction is 0
        // a/b / c/d is (ad)/(bc)
        // // same process as add method but it's dividing
        Fraction other = (Fraction) secondFraction;
        Fraction temp = new Fraction(this.num, this.den);
            int newNum = (temp.num * other.den);
            int newDen = (temp.den * other.num);
            temp.setFraction(newNum, newDen);
            return (temp.simplify());
    }	// end divide



    public boolean equals(Object other)
    {
        // implement this method!
        // we first create a fraction object from a generic object
        // then we simplify it
        // and then we compare the values of our current object's num and den to
        // the new object's num and den
        Fraction other1 = (Fraction) other;
        other1 = (Fraction) other1.simplify();
        Fraction temp = new Fraction(this.num,this.den);
        temp = (Fraction) temp.simplify();
        return ((temp.num == other1.num) && (temp.den == other1.den));
    } // end equals



    public int compareTo(Fraction other)
    {
        // implement this method!
        // we create a double so we can easily just compare the decimal points
        // then we just print -1,1,and 0 based on our case
        double double1 = toDouble();
        double double2 = other.toDouble();
        if(double1 < double2)
        {
            return -1;
        }
        else if(double1 > double2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
//if it's less return negative,
        // if it's postive more
        // if it's 0 it's 0;
    } // end compareTo


    public String toString()
    {
        return num + "/" + den; // prints fraction
    } // end toString



    //-----------------------------------------------------------------
    //  private methods start here
    //-----------------------------------------------------------------

    /** Task: Computes the greatest common divisor of two integers.
     *  @param integerOne	 an integer
     *  @param integerTwo	 another integer
     *  @return the greatest common divisor of the two integers */
    private int GCD(int integerOne, int integerTwo)
    {
        int result;

        if (integerOne % integerTwo == 0)
            result = integerTwo;
        else
            result = GCD(integerTwo, integerOne % integerTwo);

        return result;
    }	// end GCD

    // YOU CAN ADD MORE PRIVATE METHODS HERE.....

    //-----------------------------------------------------------------
    //  Here are my tests:
    //-----------------------------------------------------------------

    public static void main(String[] args)
    {
        FractionInterface firstOperand = null;
        FractionInterface secondOperand = null;
        FractionInterface result = null;
        double doubleResult = 0.0;

        Fraction nineSixteenths = new Fraction(9, 16);  // 9/16
        Fraction oneFourth = new Fraction(1, 4);        // 1/4

        System.out.println("\n=========================================\n");
        firstOperand = new Fraction();
        firstOperand.setFraction(20,-35);
        System.out.println("1. Set fraction is \t\t" + firstOperand);
        System.out.println("\tExpected result :\t20/-35\n");

        System.out.print("2. Simplify fraction is \t" + firstOperand );
        FractionInterface tmp = firstOperand.simplify();
        System.out.println(" " + tmp);
        System.out.println("\tExpected result :\t20/-35 -4/7\n");


        firstOperand = new Fraction(-51, -36);
        System.out.print("3. Simplify fraction is \t" + firstOperand);
        tmp = firstOperand.simplify();
        System.out.println(" " + tmp);
        System.out.println("\tExpected result :\t-51/-36 17/12\n");



        firstOperand = new Fraction(250, -35);
        System.out.print("4. Simplify fraction is \t" + firstOperand );
        tmp = firstOperand.simplify();
        System.out.println(" " + tmp);
        System.out.println("\tExpected result :\t250/-35 -50/7\n");

        System.out.println("\n=========================================\n");
        // 7/8 + 9/16
        firstOperand = new Fraction(7, 8);
        result = firstOperand.add(nineSixteenths);
        System.out.print("5. The sum of " + firstOperand + " and " +
                nineSixteenths + " is \t\t" + result);
        System.out.println("\n\tExpected result :\t\t23/16\n");

        // 9/16 - 7/8
        firstOperand = nineSixteenths;
        secondOperand = new Fraction(7, 8);
        result = firstOperand.subtract(secondOperand);
        System.out.print("6. The difference of " + firstOperand	+
                " and " +	secondOperand + " is \t" + result);
        System.out.println("\n\tExpected result :\t\t-5/16\n");


        // 15/-2 * 1/4
        firstOperand = new Fraction(15, -2);
        result = firstOperand.multiply(oneFourth);
        System.out.print("7. The product of " + firstOperand	+
                " and " +	oneFourth + " is \t" + result);
        System.out.println("\n\tExpected result :\t\t-15/8\n");

        // (-21/2) / (3/7)
        firstOperand = new Fraction(-21, 2);
        secondOperand= new Fraction(3, 7);
        result = firstOperand.divide(secondOperand);
        System.out.print("8. The quotient of " + firstOperand	+
                " and " +	secondOperand + " is \t" + result);
        System.out.println("\n\tExpected result :\t\t-49/2\n");

        // -21/2 + -7/-8
        firstOperand = new Fraction(-21, 2);
        secondOperand= new Fraction(-7, -8);
        result = firstOperand.add(secondOperand);
        System.out.print("9. The sum of " + firstOperand	+
                " and " +	secondOperand + " is \t" + result);
        System.out.println("\n\tExpected result :\t\t-77/8\n");


        System.out.println("\n=========================================\n");
        // 0/10, 5/(-15), (-22)/7
        firstOperand = new Fraction(0, 10);
        doubleResult = firstOperand.toDouble();
        System.out.println("10. The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
        System.out.println("\tExpected result \t\t\t0.0\n");

        firstOperand = new Fraction(1, -3);
        doubleResult = firstOperand.toDouble();
        System.out.println("11. The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
        System.out.println("\tExpected result \t\t\t-0.333333333...\n");

        firstOperand = new Fraction(-15, -6);
        doubleResult = firstOperand.toDouble();
        System.out.println("12. The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
        System.out.println("\tExpected result \t\t\t\t2.5\n");

        firstOperand = new Fraction(-21, 2);
        System.out.println("First = " + firstOperand);
        // equality check
        System.out.println("13. check First equals First: ");
        if (firstOperand.equals(firstOperand))
            System.out.println("Identity of fractions OK");
        else
            System.out.println("ERROR in identity of fractions");

        secondOperand = new Fraction(42, -4);
        System.out.println("\nFirst = " + firstOperand);
        System.out.println("Second = " + secondOperand);
        System.out.println("14. check First equals Second: ");
        if (firstOperand.equals(secondOperand))
            System.out.println("Equality of fractions OK: equal");
        else
            System.out.println("ERROR in equality of fractions: equal");


        secondOperand = new Fraction(-42, -4);
        System.out.println("\nFirst = " + firstOperand);
        System.out.println("Second = " + secondOperand);
        System.out.println("15. check First equals Second: ");
        if (firstOperand.equals(secondOperand))
            System.out.println("ERROR in equality of fractions: not equal");
        else
            System.out.println("Equality of fractions OK: not equal");

        // comparison check
        // comparison check
        secondOperand = new Fraction(42, -4);
        Fraction first  = (Fraction)firstOperand;
        Fraction second = (Fraction)secondOperand;

        System.out.println("\nFirst = " + first);
        System.out.println("Second = " + second);
        System.out.println("16. check First compareTo Second: ");
        if (first.compareTo(second) == 0)
            System.out.println("Fractions == operator OK");
        else
            System.out.println("ERROR in fractions == operator");

        second = new Fraction(7, 8);
        System.out.println("\nFirst = " + first);
        System.out.println("Second = " + second);
        System.out.println("17. check First compareTo Second: ");
        if (first.compareTo(second) < 0)
            System.out.println("Fractions < operator OK");
        else
            System.out.println("ERROR in fractions < operator");

        System.out.println("\nFirst = " + first);
        System.out.println("Second = " + second);
        System.out.println("18. check Second compareTo First: ");
        if (second.compareTo(first) > 0)
            System.out.println("Fractions > operator OK");
        else
            System.out.println("ERROR in fractions > operator");

        System.out.println("\n=========================================");

        System.out.println("\n19. check FractionException: 1/0");
        try {
            Fraction a1 = new Fraction(1, 0);
            System.out.println("Error! No FractionException");
        }
        catch ( FractionException fe )
        {
            System.err.printf( "Exception: %s\n", fe );
        } // end catch
        System.out.println("Expected result : FractionException!\n");


        System.out.println("\n20. check FractionException: division");
        try {
            Fraction a2 = new Fraction();
            Fraction a3 = new Fraction(1, 2);
            a3.divide(a2);
            System.out.println("Error! No FractionException");
        }
        catch ( FractionException fe )
        {
            System.err.printf( "Exception: %s\n", fe );
        } // end catch
        System.out.println("Expected result : FractionException!\n");


    }	// end main
} // end Fraction

