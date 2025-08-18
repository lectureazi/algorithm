package c_datastructure.queue.quiz;

import c_datastructure.queue._Queue;

public class Quiz {
    public static void main(String[] args) {
        q1(10);
        q2(7,3);
    }

    public static void q1(int n){
        _Queue<Integer> cards = new _Queue<>();
        _Queue<Integer> trash = new _Queue<>();

        for (int i = 1; i <= n; i++) {
            cards.enqueue(i);
        }

        while (cards.size() > 1) {
            int t1 = cards.dequeue();
            trash.enqueue(t1);

            int t2 = cards.dequeue();
            cards.enqueue(t2);
        }

        System.out.println("trash: " + trash);
        System.out.println("last card: " + cards);
    }

    public static void q2(int n, int k){
        _Queue<Integer> persons = new _Queue<>();
        _Queue<Integer> dead = new _Queue<>();

        for (int i = 1; i <= n; i++) {
            persons.enqueue(i);
        }

        while (persons.size() > 1) {
            for (int i = 0; i < k-1; i++) {
                persons.enqueue(persons.dequeue());
            }
            dead.enqueue(persons.dequeue());
        }

        System.out.println("dead: " + dead);
        System.out.println("alive: " + persons);
    }







}
