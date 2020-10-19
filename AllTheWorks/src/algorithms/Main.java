package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        //test sortOdd()
        int[] arr = new int[] {9, 1, 2, 7, 5, 14, 5};
        sortOdd(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        //test sortOdd()


        //test uniqeNumber()
        System.out.println(uniqeNumber(new double[] {2,2,3,2,2,2,2,2}));
        //test uniqeNumber()
    }

    private static int[] sortOdd(int[] array){
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 1) {
                indexes.add(i);
            }
        }

        for (int i = 0; i < indexes.size(); i++){
            for (int j = 1; j < indexes.size(); j++){
                if(array[indexes.get(j)] < array[indexes.get(j-1)]) {
                    int temp = array[indexes.get(j)];
                    array[indexes.get(j)] = array[indexes.get(j - 1)];
                    array[indexes.get(j - 1)] = temp;
                }
            }
        }

        return array;
    }

    static private double uniqeNumber(double[] array){
        double[] arr = Arrays.stream(array).sorted().toArray();
        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }
}
