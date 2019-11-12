package com.bortnichuk;

import com.bortnichuk.exception.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

    private int size;
    private Node<T> first;

    @Override
    public void push(T element) {
        Node<T> node = Node.get(element);

        if (first != null) {
            node.next = null;
        }

        first = node;

        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = first.element;
        first = first.next;

        size--;

        return element;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
        }

        static <T> Node<T> get(T element) {
            return new Node<>(element);
        }
    }
}
