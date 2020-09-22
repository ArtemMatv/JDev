package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Input a number: ");
        int length = new Scanner(System.in).nextInt();

	    int[][] arr = new int[length][length];

        IArrWorker worker = new ArrWorker(arr);
	    worker.fillArray();
	    worker.printArray();
	    worker.printEven();

        //І зразу друге завдання, метод можна було не всовувати в інтерфейс, але ладно :)
	    int[] numbers = worker.createArray(0,9,3);
        System.out.print("\n");
	    for (int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}

interface IArrWorker{
    void fillArray();
    void printArray();
    void printEven();
    int[] createArray(int start, int end, int step);
}

class ArrWorker implements IArrWorker {
    private int[][] array;//Можлива реалізація без цього поля, передаючи масив прямо у метод

    public ArrWorker(int[][] arr){
        this.array = arr;
    }

    @Override
    public void fillArray() {
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = new Random().nextInt(9);
            }
        }
    }

    @Override
    public void printArray() {
        System.out.print("\nYour array: \n");
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    @Override
    public void printEven() {
        System.out.print("\nEven numbers from main diagonal: \n");
        for (int i = 0; i < array.length; i++){
            if (array[i][i] % 2 == 0)
                System.out.print(array[i][i] + " ");
        }
    }

    @Override
    public int[] createArray(int start, int end, int step) {
        if (end == start)
            return new int[]{ start };

        int length = (end > start ? end - start : start - end) / step + 1;
        int[] result = new int[length];

        for (int i = 0; i < length; i++, start+=step){
            result[i] = start;
        }

        return result;
    }
}
