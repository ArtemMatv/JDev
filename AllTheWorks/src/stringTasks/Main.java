package stringTasks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    }

    static private void countString() {
        String input = new Scanner(System.in).nextLine();

        int result = 0;

        int i = 0;

        while (i < input.length()) {

            char act;
            if (!(input.charAt(i) >= 48 && input.charAt(i) <= 57)) {
                act = input.charAt(i);
                i++;
            } else {
                act = '+';
            }

            int start = i;
            while (i < input.length() && (input.charAt(i) >= 48 && input.charAt(i) <= 57))
                i++;

            int number = Integer.parseInt(input.substring(start, i));

            switch (act) {
                case '+':
                    result += number;
                    break;
                case '-':
                    result -= number;
                    break;
                case '/':
                    result = result / number;
                    break;
                case '*':
                    result *= number;
                    break;
                default:
                    break;
            }
        }
        System.out.println(result);

    }

    static private int[] fillArray(int length){
        int[] result = new int[length];

        int av = length / 2;
        int increaser = 0;

        if (length%2 != 1) {
            increaser = 1;
            av-=1;
        }

        for (int i = 0; i <= av; i++){
            result[av + increaser + i] = i;
            result[av - i] = i;
        }
        return result;
    }
}
