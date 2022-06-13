package ua.khpi.structure;

public class Stack {
    private int size;
    private Node top;

    private static class Node {
        Node next;
        double data;
        public Node(Node next, double data) {
            this.next = next;
            this.data = data;
        }
    }

    public void push(double data) {
        top = new Node(top, data);
        ++size;
    }

    public double pop() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot execute method \"pop\"" +
                    " because stack is empty");
        }
        double data = top.data;
        top = top.next;
        --size;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void swap() {
        if (size < 2) {
            System.out.println("Cannot execute method \"swap\" because stack must contains at least 2 elements");
            return;
        }
        Node temp = new Node(top.next, top.data);
        double first = top.data;
        while (temp.next != null) {
            temp = temp.next;
        }
        top.data = temp.data;
        temp.data = first;
    }

    public Stack turn() {
        Stack stack = new Stack();
        while (!isEmpty()) {
            stack.push(this.pop());
        }
        return stack;
    }

    public void removeEachSecondElement() {
        Node temp = top;
        for (int i = 1; i <= size / 2; i++, temp = temp.next) {
            temp.next = temp.next.next;
        }
    }

    public void printStarInTheMiddleOfTheStack() {
        Node temp = new Node(top.next, top.data);
        boolean isEvenAmountOfElements = size % 2 == 0;
        for (int i = 0; temp != null; i++, temp = temp.next) {
            System.out.println(temp.data);
            if ((isEvenAmountOfElements && size / 2 - 1 == i) ||
                    (!isEvenAmountOfElements && size / 2 - 1 == i)) {
                System.out.println("*");
            }
        }
    }

    public void insertZeroAfterMax() {
        double max = Double.MIN_VALUE;
        Node temp = new Node(top.next, top.data);
        int indexMaxElement = -1;
        for (int i = 0; temp != null; i++, temp = temp.next) {
            double element = temp.data;
            if (element > max) {
                max = element;
                indexMaxElement = i;
            }
        }
        double[] arr = new double[indexMaxElement + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.pop();
        }

        this.push(0.0);
        for (int i = arr.length - 1; i >= 0; i--) {
            this.push(arr[i]);
        }
        ++size;
    }

    public void removeMin() {
        double min = Double.MAX_VALUE;
        Node temp = new Node(top.next, top.data);
        int indexMinElement = -1;
        for (int i = 0; temp != null; i++, temp = temp.next) {
            double element = temp.data;
            if (element < min) {
                min = element;
                indexMinElement = i;
            }
        }
        --size;

        if (indexMinElement == 0) {
            this.pop();
            return;
        }
        temp = new Node(top.next, top.data);
        for (int i = 0; i < indexMinElement - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void removeAllBesidesFirst() {
        top = new Node(null, top.data);
        size = 1;
    }

    public void removeAllBesidesLast() {
        while (top.next != null) {
            top = top.next;
        }
        size = 1;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = top;
        while (temp != null) {
            sb.append(temp.data).append(System.lineSeparator());
            temp = temp.next;
        }
        return sb.toString();
    }
}