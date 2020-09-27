package com.company;

public class ArrayList {
    private int[] _array;
    private int _position;

    public ArrayList(){
        _array = new int[16];
        _position = 0;
    }

    public ArrayList(int capacity){
        if (capacity > 0){
            _array = new int[capacity];
            _position = 0;
        }
        else {
            _array = new int[16];
            _position = 0;
        }
    }

    public int getCapacity(){ //Чи варто зробити приватним? Я вважаю публічний нормальним
        return _array.length;
    }

    public void add(int item){
        if (getCapacity() == _position){
            int[] newArray = new int[getCapacity() + 8];

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
        if (_position + 8 < getCapacity() && getCapacity() > 16){
            int[] newArray = new int[getCapacity() - 8];
            for (int i = 0; i < _position - 1; i++){
                newArray[i] = _array[i];
            }
            _array = newArray;
        }
    }

    public int size(){
        return _position;
    }

    public boolean contains(int item){
        int i = 0;
        while (i < _position){
            if (_array[i] == item)
                return true;
            i++;
        }
        return false;
    }

    public int get(int position) throws Exception {
        if (position < _position && position >= 0){
            return _array[position];
        }
        else throw new Exception("Wrong position");
    }
}
