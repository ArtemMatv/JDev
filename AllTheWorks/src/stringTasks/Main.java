package stringTasks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        countString();
    }

    static private void countString(){
        String input = new Scanner(System.in).nextLine();

        int result = 0;
<<<<<<< Updated upstream
        for (int i = 0; i < input.length(); i++){
=======
        int i = 0;

        while ( i < input.length()){
>>>>>>> Stashed changes
            char act;
            if (!(input.charAt(i) >= 48 && input.charAt(i) <= 57)) {
                act = input.charAt(i);
                i++;
            }
            else
            {
                act = '+';
            }
<<<<<<< Updated upstream
            int start = i;
            while (i < input.length()-1 && (input.charAt(i) >= 48 && input.charAt(i) <= 57))
                i++;
=======

            int start = i;

            while (i < input.length() && (input.charAt(i) >= 48 && input.charAt(i) <= 57))
                i++;

>>>>>>> Stashed changes
            int number = Integer.parseInt(input.substring(start, i));

            switch (act){
                case '+': result += number; break;
                case '-': result -= number; break;
                case '/': result = result / number; break;
                case '*': result *= number; break;
                default: break;
            }
        }
<<<<<<< Updated upstream

        System.out.println(result);
=======
        System.out.println(result);

>>>>>>> Stashed changes
    }
}
