package c_datastructure.stack;

public class Run {

    public static void main(String[] args) {
        _Stack<Integer> stack = new _Stack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}
