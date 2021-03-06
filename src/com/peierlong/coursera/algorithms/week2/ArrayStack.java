package com.peierlong.coursera.algorithms.week2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 使用数组实现栈
 * BY: elong
 * ON: 07/11/2017
 */
public class ArrayStack<T> implements Stack<T> {
    private Object[] s;
    private int N;

    public ArrayStack() {
        s = new Object[1];
    }

    @Override
    public void push(T item) {
        if (N > 0 && N == s.length) {
            resize(s.length * 2);
        }
        s[N++] = item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        Object item = s[--N];
        s[N] = null;
        return (T) item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        return (T) s[N-1];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    private void resize(int capacity) {
        Object[] copy = new Object[capacity];
        System.arraycopy(s, 0, copy, 0, N);
        s = copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) s[--i];
        }

    }

    public static void main(String[] args) {
        Stack<String> stack = new ArrayStack<>();
        stack.push("my");
        stack.push("name");
        stack.push("is");
        stack.push("elong");
        StdOut.println(stack.size());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.size());
    }

}
