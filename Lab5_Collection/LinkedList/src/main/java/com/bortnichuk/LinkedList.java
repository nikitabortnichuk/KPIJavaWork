package com.bortnichuk;
import java.util.stream.Stream;
import java.util.Objects;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {

    private int size;
    private Node<T> head;

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> List<T> of(T... elements) {
        List<T> list = new LinkedList<>();
        Stream.of(elements)
                .forEach(list::add);
        return list;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        add(size, element);
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        Node<T> node = Node.get(element);

        if(index == 0){
            node.next = head;
            head = node;
        } else {
            Node<T> newNode = getNodeByIndex(index-1);
            node.next = newNode.next;
            newNode.next = node;
        }
        size++;
    }

    private Node<T> getNodeByIndex(int index) {

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;

        }

        return node;
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {

        Node<T> node = getNodeByIndex(index);

        node.element = element;

    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        return getNodeByIndex(index).element;
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {

        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        if(index==0){
            head = head.next;
        }
        else {
            Node<T> node = getNodeByIndex(index-1);
            node.next = node.next.next;
        }
        size--;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        Node<T> node = head;
        while (node != null){
            if(node.element.equals(element)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }


    private static class Node<T>{
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
        }

        static <T> Node<T> get(T element){
            return new Node<>(element);
        }

    }

}
