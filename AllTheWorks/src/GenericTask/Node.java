package GenericTask;

class Node<T extends Comparable<T>> {
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
