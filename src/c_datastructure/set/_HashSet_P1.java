package c_datastructure.set;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class _HashSet_P1<E> {

    private int arraySize = 6;
    private Object[] table;
    private int size;

    public _HashSet_P1(){
        table = new Object[arraySize];
    }

    public _HashSet_P1(int initialCapacity) {
        this.table = new Object[initialCapacity];
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public int size(){
        return size;
    }

    // 우리가 만들 해시함수 : E 타입의 데이터를 받아서 int로 변환, 인덱스
    // 해싱값의 범위는 0 ~ size-1
    // 해시함수의 연칙 : 같은 값이 들어오면 언제나 같은 해싱값을 반환해야한다.
    //                 다른 값이 들어오면 언제나 다른 해싱값을 반환해야한다.
    // 다른 값이 들어왔는데, 같은 해싱값이 반환되는 경우를 해시충돌이라 한다.
    // 해시충돌 해결방법 : chaining, open address
    private int hash(E data){
        // 0 ~ 21억 사이의 값이 반환이 된다.
        int hashCode = Math.abs(data.hashCode());

        // 정수 N을 arraySize로 나눈 나머지는 0 ~ arraySize-1
        return hashCode % arraySize;
    }

    public boolean add(E data){
        if(size == arraySize - 1){
            resize();
        }

        int index = hash(data);

        if(table[index] != null){
            return false;
        }

        table[index] = data;
        size++;
        return true;
    }

    private void resize() {
        arraySize *= 2;
        Object[] temp = new Object[arraySize];

        for(int i = 0; i < table.length; i++){
            if(table[i] == null) continue;
            int index = hash((E)table[i]);
            temp[index] = table[i];
        }

        table = temp;
    }

    public boolean remove(E data){
        int index = hash(data);
        if(table[index] == null) return false;
        table[index] = null;
        size--;
        return true;
    }

    @Override
    public String toString() {
        return "_HashSet_P1{ \n" +
                "table=" + Arrays.toString(table) +
                " \n }";
    }
    
   
}
