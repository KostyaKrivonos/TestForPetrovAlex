import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Kostya Krivonos
 * 4/16/20
 * 7:07 PM
 */

public class Calculate {

    private static HashMap<Integer, BigInteger> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mes = "A program that calculates for any positive integers m and r, such that r ≤ m, the value of the function: f(m,r)=m!/r!(m-r)!";
        System.out.println(mes);

        System.out.println("ENTER m:");
        int m = scanner.nextInt();
        System.out.println("ENTER r:");
        int r = scanner.nextInt();

        System.out.println(String.format("Calculation result: %s", calculate(m, r)));
    }

    public static BigInteger calculate(int m, int r) {
        if (m <= 0 || r <= 0) {
            throw new IllegalArgumentException("Must be only natural numbers.");
        }
        if (r > m) {
            throw new IllegalArgumentException(" 'r' must be less than or equal to 'm'.");
        }

        return calcFact(m).divide(calcFact(r).multiply(calcFact(m - r)));
    }

    private static BigInteger calcFact(int number) {

        if (number == 0 || number == 1) {
            return BigInteger.ONE;
        }

        BigInteger res = cache.get(number);
        if (res != null) {
            return res;
        }

        res = BigInteger.valueOf(number).multiply(calcFact(number - 1));
        cache.put(number, res);

        return res;
    }
}
