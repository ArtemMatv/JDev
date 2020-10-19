package simpleCollectionsTask;

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
        _end = _start.next;
        _length = 1;
    }

    public boolean isEmpty(){
        return _start == null;
    }

    public int size(){
        return _length;
    }

    public void queue(int item){
        if (isEmpty()) {
            _start = new Node(item);
            _end = _start.next;
        } else {
            _end = new Node(item);
            _end = _end.next;
        }
        _length++;
    }

    public int dequeue() throws Exception {
        if (!isEmpty()) {
            int result = _start.getValue();
            _start = _start.next;
            _length--;
            return result;
        } else throw new Exception("Queue is empty!");
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
