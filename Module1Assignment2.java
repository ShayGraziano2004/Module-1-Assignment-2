import java.util.Scanner;

public class CreditCardValidation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        long cardNumber = scanner.nextLong();

        if (isValid(cardNumber)) {
            System.out.println("The credit card number is valid.");
        } else {
            System.out.println("The credit card number is invalid.");
        }
    }

    public static boolean isValid(long number) {
        int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return (total % 10 == 0) && (getSize(number) >= 13) && (getSize(number) <= 16)
                && (prefixMatched(number, 4) || prefixMatched(number, 5)
                || prefixMatched(number, 37) || prefixMatched(number, 6));
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(Character.getNumericValue(numStr.charAt(i)) * 2);
        }
        return sum;
    }

    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(numStr.charAt(i));
        }
        return sum;
    }

    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static int getSize(long d) {
        return Long.toString(d).length();
    }

    public static long getPrefix(long number, int k) {
        if (getSize(number) <= k) {
            return number;
        } else {
            String numStr = Long.toString(number);
            return Long.parseLong(numStr.substring(0, k));
        }
    }
}
