import java.util.*;

public class Main {
    private static final int GREETING_NUMBER = 7;
    private static final String NAME_TO_COMPARE = "Вячеслав";
    private static final String QUIT_QEY = "q";
    private static final String GREETING_NUMBER_MESSAGE = "Привет";
    private static final String WRONG_NUMBER_MESSAGE = String.format("Число меньше %s, я не скажу %s", GREETING_NUMBER, GREETING_NUMBER_MESSAGE);
    private static final String GREETING_NAME_MESSAGE = String.format("Привет, %s", NAME_TO_COMPARE);
    private static final String WRONG_NAME_MESSAGE = "Нет такого имени";
    private static final String ARRAY_KEY = "массив";
    private static final int MULTIPLE = 3;
    private static final String ENTER_ARRAY_VALUE_MESSAGE = String.format(
            "Введите значения массива через пробел(например:2 3 7 9) и я покажу числа, кратные %s", MULTIPLE);
    private static final String SPACE = " ";


    public static void main(String[] args) {

        System.out.printf("Если ввести число больше %s, то я скажу %s\n", GREETING_NUMBER, GREETING_NUMBER_MESSAGE);
        System.out.printf("Если ввести %s, то я скажу %s\n", NAME_TO_COMPARE, GREETING_NAME_MESSAGE);
        System.out.printf("Для ввода массива введите %s\n", ARRAY_KEY);
        System.out.printf("Для выхода введите %s\n", QUIT_QEY);

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine();

            if (isNumber(input)) {
                if (Integer.parseInt(input) > GREETING_NUMBER) {
                    System.out.println(GREETING_NUMBER_MESSAGE);
                } else {
                    System.out.println(WRONG_NUMBER_MESSAGE);
                }
            } else if (input.equals(ARRAY_KEY)) {
                System.out.println(ENTER_ARRAY_VALUE_MESSAGE);
                List<Integer> arr = Arrays.stream(scanner.nextLine().split(SPACE)).map(Integer::parseInt).toList();
                printNumbersAreMultiples(arr, MULTIPLE);
            } else {
                if (input.equals(NAME_TO_COMPARE)) {
                    System.out.println(GREETING_NAME_MESSAGE);
                } else {
                    System.out.println(WRONG_NAME_MESSAGE);
                }
            }
        } while ( !input.equals(QUIT_QEY));

    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static void printNumbersAreMultiples(List<Integer> arr, int multiple) {
        System.out.printf("Числа кратные %s: ", multiple);
        arr.stream()
                .filter(number -> number % multiple == 0)
                .forEach(number -> System.out.print(number + SPACE));
    }
}
