package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList list = new ArrayList(8);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        list.remove(2);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
