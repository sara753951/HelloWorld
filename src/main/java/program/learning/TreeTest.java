package program.learning;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Created by yanxinming on 2019/12/5
 */
public class TreeTest {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n5.left = n6;
        n6.right = n7;




        postOrder(n1);
        System.out.println();
//        inOrderCricle(n1);

    }

    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void postOrderCricle(Node node) {
        MyStack myStack = new MyStack();
        Node preVisitNode = null;
        while (!myStack.isEmpty() || node != null) {
            while (node != null) {
                myStack.push(node);
                node = node.left;
            }
            if (node.right == null || node.right == preVisitNode) {
                node = myStack.pop();
                System.out.print(node.value + " ");
                preVisitNode = node;
                node = node.right;
            } else {
                node = node.right;
            }
        }

    }


    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    public static void inOrderCricle(Node node) {
        MyStack myStack = new MyStack();
        while (!myStack.isEmpty() || node != null) {
            while (node != null) {
                myStack.push(node);
                node = node.left;
            }
            node = myStack.pop();
            System.out.print(node.value + " ");
            node = node.right;
        }

    }



    public static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private static void preOrderCricle(Node root) {
        MyStack myStack = new MyStack();
        Node node = root;
        while (node != null || !myStack.isEmpty()) {
            while (node != null) {
                System.out.print(node.value + " ");
                myStack.push(node);
                node = node.left;
            }
            node = myStack.pop().right;
        }
    }
    public static void preOrderCricle2(Node root){
        if(root!=null){
            Stack<Node> stack=new Stack<Node>();
            stack.add(root);
            while(!stack.empty()){
                root=stack.pop();
                System.out.print(root.value+" ");
                if(root.right!=null){
                    stack.push(root.right);
                }
                if(root.left!=null){
                    stack.push(root.left);
                }
            }
        }
    }

    public static void levelOrder(Node root) {

        List<Node> nodes = new ArrayList<>();
        if (root != null) {
            nodes.add(root);
        }

        int i = 0;
        while (i < nodes.size()) {
            Node n = nodes.get(i);
            System.out.print(n.value + " ");
            if (n.left != null) {
                nodes.add(n.left);
            }
            if (n.right != null) {
                nodes.add(n.right);
            }
            i++;
        }

    }

}

class MyStack {
    Node[] arr = new Node[10];
    int index = 0;

    public int push(Node node) {
        if (index < arr.length) {
            arr[index] = node;
            index++;
        }
        return index;
    }

    public Node pop() {
        if (index != 0) {
            index--;
        }
        return arr[index];
    }

    public boolean isEmpty() {
        return index == 0;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

}
