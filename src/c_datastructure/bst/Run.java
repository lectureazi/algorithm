package c_datastructure.bst;

import c_datastructure.list._LinkedList;

public class Run {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] nums = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (Integer num : nums) {
            bst.insert(num);
        }

        System.out.println(bst.inOrderRecursive());
        System.out.println(bst.preOrderRecursive());
        System.out.println(bst.postOrderRecursive());
        
        System.out.println("=================================");
        
        System.out.println(bst.inOrder());
        System.out.println(bst.preOrder());
        System.out.println(bst.postOrder());
        
        System.out.println("=================================");
        System.out.println(bst.bfs());
    }
}
