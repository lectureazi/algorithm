package c_datastructure.queue;

public class Run {
    public static void main(String[] args) {
        _Queue<Integer> queue = new _Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println( queue.dequeue());
        }

        for (Integer i : queue) {
            System.out.println(i);
        }
    }
}
