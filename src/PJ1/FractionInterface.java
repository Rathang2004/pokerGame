
/* This file specifies methods for FractionInterface	*/
/* Do not modify this file!!                  			*/

package PJ1;

public interface FractionInterface
{
    /** Task: Sets this fraction to the given values.
     *        Do not reduce and moveMinusSign the fraction object.
     *  @param num is the integer numerator
     *  @param den is the integer denominator
     *  @throw FractionException if denominator is 0  */
    public void setFraction(int num, int den);

    /** Task: Simplify this fraction.
     *       change the fraction so that the minus sign is indicated by numerator.
     *       then, reduce this fraction to lowest term, i.e divide the numerator
     *       and denominator by their Greatest Common Divisor
     *       exmaple: -6/-10 --> 3/5  6/-10 --> -3/5
     * @return this fraction object */
    public FractionInterface simplify();

    /** Task: return this fraction in double value
     *  @return the double floating point value of a fraction */
    public double toDouble();

    /** Task: Adds two fractions.
     *  @param secondFraction is a fraction that is the second operand of the addition
     *  @return a new simplify fraction which is the sum of this fraction and
     *          the secondFraction. */
    public FractionInterface add(FractionInterface secondFraction);

    /** Task: Subtracts two fractions.
     *  @param secondFraction a fraction that is the second operand of the subtraction
     *  @return a new simplify fraction which is the difference of this fraction and
     *          the second operand  */
    public FractionInterface subtract(FractionInterface secondFraction);

    /** Task: Multiplies two fractions.
     *  @param secondFraction a fraction that is the second operand of the multiplication
     *  @return a new simplify fraction which is the product of this fraction and
     *          the second operand  */
    public FractionInterface multiply(FractionInterface secondFraction);

    /** Task: Divides two fractions.
     *  @param secondFraction a fraction that is the second operand of the division
     *  @return a new simplify fraction which is the quotient of this fraction and
     *          the second operand
     *  @throw FractionException if secondFraction is 0 */
    public FractionInterface divide(FractionInterface secondFraction);


}
