package ua.khpi.structure;

public class Queue {
    private static class Node {
        double data;
        Node next;
        Node(double data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    private int size;

    // Methods
    public boolean isEmpty() {
        return size == 0;
    }
    public void push(double data) {
        Node node = new Node(data, null);
        Node temp = head;
        if (!isEmpty()) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;

        } else {
            head = node;
        }
        ++size;
    }

    public double pop() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot execute method \"pop\" because queue is empty");
        }
        double data = head.data;
        head = head.next;
        --size;
        return data;
    }

    public int size() {
        return size;
    }

    public void findMinMaxElement() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot execute method \"findMinMaxElement\" because queue is empty");
        }
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        Node temp = head;
        while (temp != null) {
            double element = temp.data;
            if (element < min) {
                min = element;
            } else if (element > max) {
                max = element;
            }
            temp = temp.next;
        }
        System.out.printf("Max ==> %f%n", max);
        System.out.printf("Min ==> %f%n", min);
    }

    public double getAverage() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot execute method \"getAverage\" because queue is empty");
        }

        Node temp = head;
        double sum = 0;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum / size;
    }

    public double findElementBeforeMin() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot execute method \"getAverage\" because queue is empty");
        }
        Node temp = head;
        double min = Double.MAX_VALUE;
        int indexMinElement = -1;
        for (int i = 0; temp != null; i++, temp = temp.next) {
            double element = temp.data;
            if (element < min) {
                indexMinElement = i;
                min = element;
            }
        }
        temp = head;
        for (int i = 0; i < indexMinElement - 1; i++, temp = temp.next) {

        }
        return temp.data;
    }

    private String print() {
        StringBuilder sb = new StringBuilder();
        Node temp = new Node(head.data, head.next);
        sb.append("[");
        while (temp != null) {
            sb.append(temp.data).append(" ,");
            temp = temp.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return print();
    }
}
