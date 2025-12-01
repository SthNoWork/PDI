//Compare the execution of a factorial function implemented procedurally and using recursion
//Let define input to this function as 3, 6, 10 and 50.
//What are the result output?

import java.math.BigInteger;

public class Lab5Ex5 {

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))
            return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        int[] numbers = { 3, 6, 10, 50 };

        for (int n : numbers) {
            BigInteger result = factorial(BigInteger.valueOf(n));
            System.out.println(n + "! = " + result);
        }
    }
}
