package com.company;

//Тут повинно бути набагато більше методів, ось перші з них
public class Queue<T extends Comparable<T>> {
    private Node<T> _start;
    private Node<T> _end;
    private int _length;

    public Queue(){
        _start = null;
        _end = null;
        _length = 0;
    }

    public Queue(T item){
        _start = new Node<T>(item);
        _end = _start;
        _length = 1;
    }

    public int size(){
        return _length;
    }

    public void queue(T item){
        if (_start == null) {
            _start = new Node<T>(item);
            _end = _start;
        } else if (_length == 1){
            _end = new Node<T>(item);
            _start.next = _end;
        } else {
            Node newNode = new Node<T>(item);
            _end.next = newNode;
            _end = newNode;
        }
        _length++;
    }

    public T dequeue(){
        T result = _start.getValue();
        _start = _start.next;
        _length--;
        return result;
    }

    public boolean contains(T item){
        Node<T> elem = _start;
        while(elem != null){
            if (elem.getValue().equals(item))
                return true;
            elem = elem.next;
        }

        return false;
    }
}
