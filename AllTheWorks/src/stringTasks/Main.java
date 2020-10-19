package stringTasks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        countString();
    }

    static private void countString(){
        String input = new Scanner(System.in).nextLine();

        int result = 0;
        for (int i = 0; i < input.length(); i++){
            char act;
            if (!(input.charAt(i) >= 48 && input.charAt(i) <= 57)) {
                act = input.charAt(i);
                i++;
            }
            else
            {
                act = '+';
            }
            int start = i;
            while (i < input.length()-1 && (input.charAt(i) >= 48 && input.charAt(i) <= 57))
                i++;
            int number = Integer.parseInt(input.substring(start, i));

            switch (act){
                case '+': result += number; break;
                case '-': result -= number; break;
                case '/': result = result / number; break;
                case '*': result *= number; break;
                default: break;
            }
        }

        System.out.println(result);
    }
}
