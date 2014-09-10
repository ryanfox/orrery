package orrery.util;

/**
 * @author ryanfox
 */
public class Validators {
    public static void checkPositive(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Argument must be greater than zero: " + value);
        }
    }

    public static void checkNonnegative(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Argument must be zero or positive: " + value);
        }
    }

    public static void checkRangeInclusive(double value, double lower, double upper) {
        if (value < lower) {
            throw new IllegalArgumentException("Argument must be greater than lower bound. Value: " + value +
                    " Bound: " + lower);
        }
        if (value > upper) {
            throw new IllegalArgumentException("Argument must be lower than upper bound. Value: " + value +
                    " Bound: " + upper);
        }
    }
}
