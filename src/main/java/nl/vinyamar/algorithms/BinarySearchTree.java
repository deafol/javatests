package nl.vinyamar.algorithms;


class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean isValidBST(Node root) {
        Integer leftValue = calcMaxVal(root.left);
        Integer rightValue = calcMinVal(root.right);
        System.out.println(leftValue);
        System.out.println(rightValue);
        if (compareLeft(root.value, leftValue) && compareRight(root.value, rightValue)) {
            return true;
        }
        return false;
    }

    private static boolean compareRight(Integer value, Integer rightValue) {
        if (rightValue == null) return true;
        if (value == null) return false;
        return rightValue > value;
    }

    private static boolean compareLeft(Integer value, Integer leftValue) {
        if (leftValue == null) return true;
        if (value == null) return false;
        return leftValue <= value;
    }

    private static Integer calcMaxVal(Node root) {
        if (root != null) {
            Integer leftValue = getValue(root.left);
            Integer rightValue = getValue(root.right);
            return max(root.value, max(leftValue, rightValue));
        }
        return null;
    }

    private static Integer max(Integer first, Integer second) {
        if (first == null) return second;
        if (second == null) return first;
        return Math.max(first, second);
    }

    private static Integer calcMinVal(Node root) {
        if (root != null) {
            Integer leftValue = getValue(root.left);
            Integer rightValue = getValue(root.right);
            return min(root.value, min(leftValue, rightValue));
        }
        return null;
    }

    private static Integer min(Integer first, Integer second) {
        if (first == null) return second;
        if (second == null) return first;
        return Math.min(first, second);
    }

    private static Integer getValue(Node node) {
        if (node != null) {
            return node.value;
        }
        return null;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(10, null, null);
        Node n31 = new Node(12, n1, null);
        Node n2 = new Node(2, n1, n3);
        Node n4 = new Node(3, n2, n3);
        Node n5 = new Node(3, n4, n3);
        Node n6 = new Node(11, n5, n31);

        System.out.println(isValidBST(n6));
    }
}
