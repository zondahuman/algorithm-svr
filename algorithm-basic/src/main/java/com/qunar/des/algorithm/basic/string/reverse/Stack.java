package com.qunar.des.algorithm.basic.string.reverse;

import java.util.Arrays;

/**
 * @author: hejixiang
 * @since:${version} //
 */
public class Stack<E> {

    private int size;

    private Object[] elementData;

    public Stack() {
        elementData = new Object[10];
    }

    public Stack(int intiCapacity) {
        elementData = new Object[intiCapacity];
    }

    public void push(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new RuntimeException("空栈");
        }
        return (E) elementData[--size];
    }

    public int getSize() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            Object oldData[] = elementData;
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            // minCapacity is usually close to size, so this is a win:
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }



}
