package org.example;

import java.util.Comparator;

public class BinaryTree {

    private Node root;
    private final Comparator<? extends Person> comparator;
    private int size;

    private static class Node{
        Node left;
        Node right;
        Person person;

        Node(Person person){
            this.person = person;
        }
    }

    public BinaryTree(){
        comparator = Comparator.comparing(Person::getSurname);
    }

    public BinaryTree(BinaryTree tree, Comparator<? extends Person> comparator){
        this.put
        this.comparator = comparator;
        this.size = tree.size;
    }
    public BinaryTree(Comparator<? extends Person> comparator){
        this.comparator = comparator;
    }

    public void put(Person person){
        root = put(root, person);
        size++;
    }

    private Node put(Node current, Person person){
        if (current == null) {
            return new Node(person);
        }

        if(person.compareTo(current.person) < 0){
            current.left = put(current.left, person);
        }else if(person.compareTo(current.person) > 0){
            current.right = put(current.right, person);
        }
        return current;
    }

    public int size(){
        return size;
    }

    public double getAverageAge(){
        double sum = calculateSumAge(root);
        return sum / size;
    }

    private int calculateSumAge(Node node) {
        if(node == null){
            return 0;
        }
        return node.person.getAge() + calculateSumAge(node.left) +
                calculateSumAge(node.right) ;

    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node != null){
            System.out.println(node.person);
            preOrder(node.left);
            preOrder(node.right);
        }

    }


    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.person);
        }
    }

    public void symmetricOrder(){
        symmetricOrder(root);
    }

    private void symmetricOrder(Node node){
        if(node != null){
            postOrder(node.left);
            System.out.println(node.person);
            postOrder(node.right);
        }
    }

    public void removeLeftSubTree(){
        root.left = null;
    }

    public void removeRightSubTree(){
        root.right = null;
    }

    public void remove(String passport){
        if(passport.compareTo(root.person.getPassport()) < 0){
            removeNode(root.left, passport);
        }else if(passport.compareTo(root.person.getPassport()) > 0){
            removeNode(root.right, passport);
        }else{

        }
        removeNode(root, passport);
    }

    private void removeNode(Node node, String passport) {
        if(node.person.getPassport().equals(passport)){
            if(node.left == null && node.right == null){

            }
        }

    }

    public void clear(){
        clear(root);
    }

    private void clear(Node node) {
        if (node != null) {
            clear(node.left);
            clear(node.right);
            node = null;
        }
    }


    public void paintIntoRedBlackTree(){

    }

    public void print() {
        System.out.print('[');
        inOrder(root.left);
        inOrder(root.right);
        System.out.print(']');
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.person);
        inOrder(node.right);

    }
}
