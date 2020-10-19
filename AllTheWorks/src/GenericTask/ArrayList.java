package GenericTask;

import java.lang.reflect.Array;

public class ArrayList<T extends Comparable<T>> {
    private T[] _array;
    private int _position;

    public ArrayList(T item){
        _array = (T[])Array.newInstance(item.getClass(), 16);
        _position = 0;
    }

    public int getCapacity(){ //Чи варто зробити приватним? Я вважаю публічний нормальним
        return _array.length;
    }

    public void add(T item){
        if (getCapacity() == _position){
            T[] newArray = (T[])Array.newInstance(item.getClass(),getCapacity() + 8);

            for (int i = 0; i < getCapacity(); i++){
                newArray[i] = _array[i];
            }
            _array = newArray;
        }
        _array[_position++] = item;
    }

    public void remove(int position){
        if (_position > position && position >= 0){
            for (int i = position; i < _position - 1; i++){
                _array[i] = _array[i + 1];
            }
            _position--;
        }
        if (_position + 12 < getCapacity() && getCapacity() > 16){
            T[] newArray = (T[])Array.newInstance(_array[0].getClass(),getCapacity() - 8);
            for (int i = 0; i < _position - 1; i++){
                newArray[i] = _array[i];
            }
            _array = newArray;
        }
    }

    public int size(){
        return _position;
    }

    public boolean contains(T item){
        int i = 0;
        while (i < _position){
            if (_array[i].compareTo(item) == 0)
                return true;
            i++;
        }
        return false;
    }

    public T get(int position) throws Exception {
        if (position < _position && position >= 0){
            return _array[position];
        }
        else throw new Exception("Wrong position");
    }
}
