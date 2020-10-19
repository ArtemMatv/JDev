package GenericTask;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private int _length;

    public LinkedList(){
        head = null;
        _length = 0;
    }

    public LinkedList(T item){
        head = new Node<T>(item);
        _length = 1;
    }

    public void add(T item){
        if (head == null){
            head = new Node<T>(item);
        } else {
            Node<T> elem = head;
            while (elem.next != null){
                elem = elem.next;
            }
            elem.next = new Node<T>(item);

        }
        _length++;
    }

    public void removeItem(T item) throws Exception {
        if (head != null){
            if (head.getValue().compareTo(item) == 0) {
                head = head.next;
            }
            else {
                Node<T> elem = head;

                while (elem.next != null && !elem.next.getValue().equals(item)){
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
                Node<T> elem = head;
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
                if (elem.getValue().equals(item))
                    return true;
                elem = elem.next;
            }
        }
        return false;
    }

    public T get(int position) throws Exception {
        if(head != null) {
            if (position == 0) {
                return head.getValue();
            }
            else if (position > 0 && position < _length) {
                int i = 0;
                Node<T> elem = head;
                while (i < position - 1) {
                    elem = elem.next;
                    i++;
                }
                return elem.next.getValue();
            }
        } throw new Exception("There are no items! At all!");
    }
}
