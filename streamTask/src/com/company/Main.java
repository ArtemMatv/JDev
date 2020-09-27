package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    { }

    private static void firstTask(){
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        List<String> strArray =  myList.stream()
                .filter(e -> e.charAt(0) == 'c')
                .map(e -> e.toUpperCase())
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        strArray.forEach(e -> System.out.println(e));

    }

    private static void secondTask(){
        System.out.print("Enter n: ");
        int length = new Scanner(System.in).nextInt();

        int[] arr = new int[length];

        for(int i = 0; i < length; i++){
            arr[i] = new Random().nextInt(9);
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n");
        System.out.println(
                Arrays.stream(arr)
                        .filter(e -> e%2 == 0)
                        .average()
                        .getAsDouble()
        );
    }
}
