package GenericTask;

public class Stack<T extends Comparable<T>> {
    private Node<T> _head;
    private int _length;

    public Stack(){
        _head = null;
        _length = 0;
    }

    public Stack(T item){
        _head = new Node<T>(item);
        _length = 1;
    }

    public int size(){
        return _length;
    }

    public void push(T item){
        Node<T> newNode = new Node<T>(item);
        newNode.next = _head;
        _head = newNode;
        _length++;
    }

    public T pop() throws Exception {
        if (_head == null)
            throw new Exception("There are no elements");
        T result = _head.getValue();
        _head = _head.next;
        _length--;
        return result;
    }

    public boolean contains(T item){
        Node<T> elem = _head;
        while(elem != null){
            if (elem.getValue().equals(item))
                return true;
            elem = elem.next;
        }

        return false;
    }
}
