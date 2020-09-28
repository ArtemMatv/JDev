package com.company;

class Node<T> {
    private T _value;
    public Node<T> next;

    public Node(T value){
        _value = value;
        next = null;
    }

    public T getValue(){
        return _value;
    }
}
