package ua.khpi.structure;

public class Deque {
    private static class Node {
        double data;
        Node next;
        Node(double data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushBack(double data) {
        Node newNode = new Node(data, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void pushFront(double data) {
        Node newNode = new Node(data, head);
        head = newNode;
        if (isEmpty()) {
            tail = newNode;
        }
        size++;
    }

    public double peekLast() {
        if (isEmpty()) {
                throw new RuntimeException("Cannot execute \"peekLast\" method " +
                        "because deque is empty");
        }
        return tail.data;
    }

    public double peekFirst() {
        if (isEmpty()) {
                throw new RuntimeException("Cannot execute \"peekFront\" method " +
                        "because deque is empty");
        }
        return head.data;
    }

    public double get(int index) {
        if (isEmpty()) {
            throw new RuntimeException("Cannot execute \"get\" method " +
                    "because index of deque can't be more or equal size of the deque");
        }
        Node temp = new Node(head.data, head.next);
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    private String print() {
        StringBuilder sb = new StringBuilder();
        Node temp = new Node(head.data, head.next);
        sb.append("[");
        while (temp != null) {
            sb.append(temp.data).append(", ");
            temp = temp.next;
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return print();
    }

}
