import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberFormatter {
    private static final BufferedReader bf;
    private static final String REGEX_DIGITS = "^(-?|\\+?)\\d*$";

    static {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        NumberFormatter numberFormatter = new NumberFormatter();
        System.out.println(numberFormatter.parseInt(numberFormatter.inputString()));
    }

    public int parseInt(String string) {
        int result;
        switch (string.substring(0, 1)) {
            case "-": {
                result = convertStringInputWithMinus(string);
                break;
            }
            case "+": {
                result = convertStringInputWithPlus(string);
                break;
            }
            default: {
                result = convertStringInput(string);
                break;
            }
        }
        return result;
    }

    public String inputString() {
        String input;
        do {
            System.out.println("Please input string with numbers:");
            try {
                input = NumberFormatter.bf.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Input is invalid");
            }
        } while (!input.matches(REGEX_DIGITS));
        return input;
    }

    public int convertStringInput(String string) {
        int result = 0;
        int zero = '0';
        char[] charArray = string.toCharArray();
        int ten = getQuantityOfZero(charArray);
        for (char c : charArray) {
            result += (c - zero) * ten;
            ten /= 10;
        }
        return result;
    }

    public int convertStringInputWithMinus(String string) {
        int number = convertStringInput(string.replace("-", ""));
        return number - (number * 2);
    }

    public int convertStringInputWithPlus(String string) {
        return convertStringInput(string.replace("+", ""));
    }

    public int getQuantityOfZero(char[] array) {
        int ten = 1;
        if (array.length > 1) {
            for (int i = 0; i < array.length - 1; i++) {
                ten *= 10;
            }
        }
        return ten;
    }

}
