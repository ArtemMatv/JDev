package com.company;

//Тут повинно бути набагато більше методів, ось перші з них
public class Queue {
    private Node _start;
    private Node _end;
    private int _length;

    public Queue(){
        _start = null;
        _end = null;
        _length = 0;
    }

    public Queue(int item){
        _start = new Node(item);
        _end = _start;
        _length = 1;
    }

    public int size(){
        return _length;
    }

    public void queue(int item){
        if (_start == null) {
            _start = new Node(item);
            _end = _start;
        } else if (_length == 1){
            _end = new Node(item);
            _start.next = _end;
        } else {
            Node newNode = new Node(item);
            _end.next = newNode;
            _end = newNode;
        }
        _length++;
    }

    public int dequeue(){
        int result = _start.getValue();
        _start = _start.next;
        _length--;
        return result;
    }

    public boolean contains(int item){
        Node elem = _start;
        while(elem != null){
            if (elem.getValue() == item)
                return true;
            elem = elem.next;
        }

        return false;
    }
}
