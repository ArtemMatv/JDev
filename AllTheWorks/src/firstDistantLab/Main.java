package firstDistantLab;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
    }

    //Write a function, which takes a non-negative integer (seconds) as input and returns
    //the time in human-readable format
    private static String getTimeFromSeconds(int seconds) throws Exception {
        if (seconds < 0 || seconds > 359999)
            throw new Exception("Seconds must be in range 0-359999");

        int hours = seconds/3600;
        seconds = seconds%3600;

        int minutes = seconds/60;
        seconds = seconds%60;


        return (hours > 9 ? String.valueOf(hours) : "0" + hours) + ":" +
                (minutes > 9 ? String.valueOf(minutes) : "0" + minutes) + ":" +
                seconds;
    }

    //Given n, take a sum of the digits of n. If value has more than one digit,
    //continue reducing in this way until a single-digit number is produced.
    //The input will be a non-negative integer
    private static int getDigitSum(int number){
        int result = 0;
        int prosess = number;
        while (prosess != 0){
            result += prosess%10;
            prosess = (prosess - prosess%10)/10;
        }
        if (result >= 10)
            return getDigitSum(result);

        return result;
    }

    //Given a sentence. Find the longest word in that sentence
    //and return it's length
    private static int getTheLongestWordLength(String sentence){
        return ((String)
                (Arrays.stream(sentence.split(" "))
                        .sorted(Comparator.comparing(String::length)
                                .reversed())
                        .toArray()[0])
            ).length();
    }

    //Implement method hasNoLetters. Method returns true if none of the letters in
    //the blacklist are present in the phrase. If at least one letter from
    //blacklist is present in the phrase return false. Comparison should be
    //case insensitive. Meaning 'A' == 'a'
    private static boolean hasNoLetters(String phrase, String blacklist){
        phrase = phrase.toLowerCase();
        blacklist = blacklist.toLowerCase();

        for(int i = 0; i < blacklist.length(); i++)
            if (phrase.contains(blacklist.substring(i, i + 1)))
                return false;

        return true;
    }

    //Implement method findMultiples(x, n) which returns an array
    //of the first x multiples of the real number n.
    private static int[] findMultiples(int x, int n) throws Exception {
        if (x < 1 || n < 1)
            throw  new Exception("'x' and 'n' must be more than 0!");

        int[] result = new int[x];

        for (int i = 0; i < x; i++){
            result[i] = n*(i+1);
        }

        return result;

    }

    //Given an array of strings, reverse them and their order in such way
    //that their length stays the same as the length of the original inputs
    private static String[] reverseArray(String[] array){
        String input = new StringBuilder().append(String.join("", array)).reverse().toString();

        String[] result = new String[array.length];

        int pointer = 0;
        for (int i = 0; i < result.length; i++){
            result[i] = input.substring(pointer, pointer + array[i].length());
            pointer += array[i].length();
        }

        return result;
    }
}
