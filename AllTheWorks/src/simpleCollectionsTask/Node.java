package simpleCollectionsTask;

public class Node{
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
