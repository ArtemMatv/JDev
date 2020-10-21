package firstDistantLab;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(getDigitSum(493193));
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
}
