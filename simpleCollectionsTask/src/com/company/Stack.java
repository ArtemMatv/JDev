package com.company;

public class Stack {
    private Node _head;
    private int _length;

    public Stack(){
        _head = null;
        _length = 0;
    }

    public Stack(int item){
        _head = new Node(item);
        _length = 1;
    }

    public int size(){
        return _length;
    }

    private void push(int item){
        Node newNode = new Node(item);
        newNode.next = _head;
        _head = newNode;
    }

    private int pop(){
        int result = _head.getValue();
        _head = _head.next;
        return result;
    }
}
