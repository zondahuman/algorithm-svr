package com.abin.lee.algorithm.basic.stack;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-5-24 下午10:24
 */
public class Stack<T> {
    private Object[] obj = null;
    private int size;

    public Stack() {
        this.obj = new Object[10];
    }
    public Stack(int capacity) {
        this.obj = new Object[capacity];
    }
    public void push(T key){
        ensureCapacity(size+1);
        obj[size++] = key;
    }
    public T pop(){
         if(size == 0)
             throw new RuntimeException("null stack");
        else
             return (T)obj[--size];
    }
    public int getSize(){
        return size;
    }
    public void ensureCapacity(int minCapacity){
        int oldCapacity = obj.length;
        if(minCapacity>oldCapacity){
            Object oldData[] = obj;
            int newCapacity = (oldCapacity*3)/2+1;
            if(newCapacity<minCapacity)
                newCapacity = minCapacity;
            obj = Arrays.copyOf(oldData, newCapacity);
        }
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack(5);
        for(int i=0;i<5;i++){
            stack1.push(i);
        }
        System.out.println(JsonUtil.toJson(stack1.obj));
        for(int i=0;i<5;i++){
            int result = (Integer)stack1.pop();
            System.out.println("result="+result);
        }
    }

}
