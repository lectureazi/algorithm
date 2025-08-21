package c_datastructure.set;

import c_datastructure.list._LinkedList;
import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class _HashSet_P3<E> implements Iterable<E>{
    
    private int arraySize = 2;
    private Object[] table;
    private int size = 0;
    
    public _HashSet_P3() {
        this.table = new Object[arraySize];
    }
    
    public _HashSet_P3(int initialCapacity) {
        this.table = new Object[initialCapacity];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return this.size;
    }
    
    private int hash(Object e) {
        int hashCode = Math.abs(e.hashCode());
        return hashCode % arraySize;
    }
    
    public boolean add(E e) {
        if(size == arraySize) {
            resize();
        }
        
        if(!addNode(e)) return false;
        size++;
        return true;
    }
    
    private boolean addNode(E e) {
        int index = hash(e);
        _LinkedList<E> row = (_LinkedList<E>) table[index];
        
        if(row == null) {
            _LinkedList<E> newRow = new _LinkedList<E>();
            newRow.add(e);
            table[index] = newRow;
            return true;
        }
        
        if(row.contains(e)) return false;
        row.add(e);
        return true;
    }
    
    public boolean remove(E data) {
        int index = hash(data);
        _LinkedList<E> row = (_LinkedList<E>) table[index];
        
        if(row == null) return false;
        if(!row.contains(data)) return false;
        
        row.remove(row.indexOf(data));
        if(row.isEmpty()) table[index] = null;
        size--;
        return true;
    }
    
    private void resize() {
        Object[] temp = Arrays.copyOf(table, arraySize);
        arraySize *= 2;
        table = new Object[arraySize];
        
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] == null) continue;
            _LinkedList<E> row = (_LinkedList<E>) temp[i];
            
            for (E e : row) {
                addNode(e);
            }
        }
    }
    
    @Override
    public String toString() {
        
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        
        for (int i = 0; i < table.length; i++) {
            if(table[i] == null) continue;
            _LinkedList<E> row = (_LinkedList<E>) table[i];
            
            for (E e : row) {
                sb.append(e).append(", ");
            }
        }
        
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            
            private int cnt = 0;
            private int rowPointer = -1;
            private _LinkedList<E> row = new _LinkedList<>();
            private Iterator<E> rowIterator = row.iterator();
            
            @Override
            public boolean hasNext() {
                return cnt < size;
            }
            
            @Override
            public E next() {
                if(rowIterator.hasNext()) {
                    cnt++;
                    return rowIterator.next();
                }
                
                do {
                    rowPointer++;
                }while(table[rowPointer] == null);
                
                row = (_LinkedList<E> ) table[rowPointer];
                rowIterator = row.iterator();
                cnt++;
                return rowIterator.next();
            }
        };
    }
}
