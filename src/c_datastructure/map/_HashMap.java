package c_datastructure.map;

import c_datastructure.list._LinkedList;
import c_datastructure.set._HashSet_P3;

@SuppressWarnings("unchecked")
public class _HashMap<K, V> {

    private int size;
    private int arraySize = 17;
    private Object[] table;
    private _HashSet_P3<Entry<K,V>> entrySet = new _HashSet_P3();

    public _HashMap() {
        this.table = new Object[arraySize];
    }

    public _HashMap(int initialCapacity) {
        this.table = new Object[initialCapacity];
    }

    private int hash(K key){
        // 0 ~ 21억 사이의 값이 반환이 된다.
        int hashCode = Math.abs(key.hashCode());

        // 정수 N을 arraySize로 나눈 나머지는 0 ~ arraySize-1
        return hashCode % arraySize;
    }

    private void resize() {
        arraySize *= 2;
        Object[] temp = new Object[arraySize];

        for(int i = 0; i < table.length; i++){
            if(table[i] == null) continue;
            _LinkedList<Entry<K, V>> row = (_LinkedList<Entry<K, V>>) table[i];
            int index = hash(row.get(0).getKey());
            temp[index] = row;
        }

        table = temp;
    }

    public V put(K key, V value) {
        if (size == arraySize - 1) {
            resize();
        }

        int index = hash(key);
        Entry<K, V> entry = new Entry<>(key, value);
        _LinkedList<Entry<K,V>> row = ( _LinkedList<Entry<K,V>>) table[index];

        if (row == null) {
            createRow(entry, index);
            entrySet.add(entry);
            size++;
            return null;
        }

        if (row.contains(entry)) {
            Entry<K,V> res = row.remove(row.indexOf(entry));
            entrySet.remove(entry);
            row.add(entry);
            entrySet.add(entry);
            return res.getValue();
        }

        row.add(entry);
        entrySet.add(entry);
        size++;
        return null;
    }

    public V get(K key) {
        int index = hash(key);
        _LinkedList<Entry<K, V>> row = (_LinkedList<Entry<K, V>>) table[index];

        if(row == null){
            return null;
        }

        for (int i = 0; i < row.size(); i++) {
            if(row.get(i).equals(new Entry<K,V>(key,null))){
                return row.get(i).getValue();
            }
        }

        return null;
    }

    public V remove(K key){
        int index = hash(key);
        _LinkedList<Entry<K, V>> row = (_LinkedList<Entry<K, V>>) table[index];

        if(row == null){
            return null;
        }
        
        Entry<K,V> dummy = new Entry<K,V>(key,null);
        
        if(!row.contains(dummy)) return null;
        V prev = row.remove(row.indexOf(dummy)).getValue();
        entrySet.remove(dummy);
        
        if(row.isEmpty()){
            table[index] = null;
        }
        
        size--;
        return prev;
    }

    public _HashSet_P3<Entry<K,V>> entrySet(){
        return entrySet;
    }

    public boolean containsKey(K key){
        int index = hash(key);
        if(table[index] == null) return false;

        _LinkedList<Entry<K, V>> row = (_LinkedList<Entry<K, V>>) table[index];
        return row.contains(new Entry<K,V>(key,null));
    }

    private void createRow(Entry<K, V> data, int index) {
        _LinkedList<Entry<K,V>> newRow = new _LinkedList<>();
        newRow.add(data);
        table[index] = newRow;
    }

    public int size() {
        return size;
    }
}

