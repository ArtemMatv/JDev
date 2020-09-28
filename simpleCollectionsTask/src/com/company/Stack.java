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

    public void push(int item){
        Node newNode = new Node(item);
        newNode.next = _head;
        _head = newNode;
        _length++;
    }

    public int pop() throws Exception {
        if (_head == null)
            throw new Exception("There are no elements");
        int result = _head.getValue();
        _head = _head.next;
        _length--;
        return result;
    }

    public boolean contains(int item){
        Node elem = _head;
        while(elem != null){
            if (elem.getValue() == item)
                return true;
            elem = elem.next;
        }

        return false;
    }
}
