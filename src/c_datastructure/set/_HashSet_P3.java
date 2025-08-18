package c_datastructure.set;

import c_datastructure.list._LinkedList;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class _HashSet_P3<E> implements Iterable<E>{

    private int arraySize = 17;
    private Object[] table;
    private int size = 0;

    public _HashSet_P3() {
        this.table = new Object[arraySize];
    }

    public _HashSet_P3(int initialCapacity) {
        this.table = new Object[initialCapacity];
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public int size(){
        return size;
    }

    private int hash(E data){
        // 0 ~ 21억 사이의 값이 반환이 된다.
        int hashCode = Math.abs(data.hashCode());

        // 정수 N을 arraySize로 나눈 나머지는 0 ~ arraySize-1
        return hashCode % arraySize;
    }

    private void resize() {
        arraySize *= 2;
        Object[] temp = new Object[arraySize];

        for(int i = 0; i < table.length; i++){
            if(table[i] == null) continue;
            _LinkedList<E> row = (_LinkedList<E>) table[i];
            int index = hash(row.get(0));
            temp[index] = row;
        }

        table = temp;
    }

    public boolean add(E data) {

        if (size == arraySize - 1) {
            resize();
        }

        int index = hash(data);
        _LinkedList<E> row = (_LinkedList<E>) table[index];

        if (row == null) {
            createNewRow(data, index);
            size++;
            return true;
        }

        if (row.contains(data)) return false;
        row.add(data);
        size++;
        return true;

    }

    private void createNewRow(E data, int index) {
        _LinkedList<E> newRow = new _LinkedList<>();
        newRow.add(data);
        table[index] = newRow;
    }

    public boolean remove(E data){
        int index = hash(data);
        _LinkedList<E> row = (_LinkedList<E>) table[index];

        if(row == null){
            return false;
        }

        for (int i = 0; i < row.size(); i++) {
            if(row.get(i).equals(data)){
                row.remove(i);
                size--;

                if(row.isEmpty()){
                    table[index] = null;
                }

                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for(int i = 0; i < table.length; i++){
            if(table[i] == null) continue;
            _LinkedList<E> row = (_LinkedList<E>) table[i];
            for (E e : row) {
                sb.append(e).append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int cnt;
            private int pointer = -1;
            private _LinkedList<E> row = new _LinkedList<>();
            private Iterator<E> rowIterator = row.iterator();

            @Override
            public boolean hasNext() {
                return cnt < size;
            }

            @Override
            public E next() {
                if(rowIterator.hasNext()){
                    cnt++;
                    return rowIterator.next();
                }

                do {
                    pointer++;
                } while (table[pointer] == null);

                row = (_LinkedList<E>) table[pointer];
                rowIterator = row.iterator();
                cnt++;
                return rowIterator.next();
            }
        };
    }
}
