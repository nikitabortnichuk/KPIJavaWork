package com.bortnichuk;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        Node<T> node = Node.get(element);

        if(first==null){
            first = last = node ;
        }
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        if(isEmpty()) {
            return null;
        }

        T element = first.element;
        first = first.next;
        if(first == null){
            last = null;
        }
        size--;
        return element;
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return first == null;
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
