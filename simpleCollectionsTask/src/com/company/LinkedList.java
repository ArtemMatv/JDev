package com.company;

public class LinkedList {
    private Node head;
    private int _length;

    public LinkedList(){
        head = null;
        _length = 0;
    }

    public LinkedList(int item){
        head = new Node(item);
        _length = 1;
    }

    public void add(int item){
        if (head == null){
            head = new Node(item);
        } else {
            Node elem = head.next;
            while (elem != null){
                elem = elem.next;
            }
            elem = new Node(item);
        }
        _length++;
    }

    public void removeItem(int item) throws Exception {
        if (head != null){
            if (head.getValue() == item) {
                head = head.next;
            }
            else {
                Node elem = head;

                while (elem.next != null && elem.next.getValue() != item){
                    elem = elem.next;
                }

                if (elem.next != null)
                    elem.next = elem.next.next;
                else throw new Exception("There is no such item!");
            }
            _length--;
        } else throw new Exception("List does not contain any elements");
    }

    public void removePosition(int position) throws Exception {
        if(head != null) {
            if (position == 0) {
                head = head.next;
                _length--;
            }
            else if (position > 0 && position < _length) {
                int i = 0;
                Node elem = head;
                while (i < position - 1) {
                    elem = elem.next;
                    i++;
                }
                elem.next = elem.next.next;
                _length--;
            } else throw new Exception("Bad position");
        } else throw new Exception("List does not contain any elements");
    }

    public int size(){
        return _length;
    }

    public boolean contains(int item){
        if (head != null){
            Node elem = head;

            while (elem.next != null){
                if (elem.getValue() == item)
                    return true;
                elem = elem.next;
            }
            return false;
        } else return false;
    }
}

class Node{
    private int _value;
    public Node next;

    public Node(int value){
        _value = value;
        next = null;
    }

    public int getValue(){
        return _value;
    }
}
