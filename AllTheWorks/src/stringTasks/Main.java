package stringTasks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        nameGame();
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

    static private void nameGame(){//Не розбивав на методи через перевірки :D
        int action = 1;
        String names = "";
        while (action != 3){
            System.out.println("Enter the action: \n1-add\n2-subtract\n3-close\n4-show all");
            action = new Scanner(System.in).nextInt();
            String name ="";
            switch (action){
                case 1:
                    System.out.println("enter name:");
                    name = new Scanner(System.in).next();
                    if (name.charAt(0) != '+') {
                        System.out.println("bad format!");
                        break;
                    }
                    if (name.length() <= 1)
                    {
                        System.out.println("bad name!");
                        break;
                    }
                    names += name.substring(1, name.length()) + ", ";
                    break;
                case 2:
                    System.out.println("enter name:");
                    name = new Scanner(System.in).next();
                    if (name.charAt(0) != '-') {
                        System.out.println("bad format!");
                        break;
                    }
                    if (name.length() <= 1)
                    {
                        System.out.println("bad name!");
                        break;
                    }
                    if (!names.contains(name.substring(1, name.length()))){
                        System.out.println("there is no such name");
                        break;
                    }
                    names = names.replaceAll(name.substring(1, name.length()) + ", ", "");
                    break;
                case 3:
                    System.out.println("\nbye bye");
                    break;
                case 4:
                    System.out.println("all the names:\n");
                    System.out.println(names);
                    break;
                default:
                    break;
            }
        }
    }
}
