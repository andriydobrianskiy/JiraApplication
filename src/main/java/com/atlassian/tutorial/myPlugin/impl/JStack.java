package com.atlassian.tutorial.myPlugin.impl;

public class JStack {
    private Object[] data;
    private int index = 0;
    private int size = 0;

    public JStack() {
        super();
        this.size = 30; /* default stack size of 20 */
        data = new Object[this.size];
    }

    public void push(char o) {
        if (index >= size) {
            this.increaseSize();
        }
        this.data[index] = o;
        index++;
    }
  
    public Object pop() {
        if (index != 0) {
            Object obj = data[index - 1];
            this.data[index - 1] = null; // Deleted
            index--;
            return obj;
        } else
            return null;
    }
    public Object peek() throws RuntimeException {
        if (index != 0)
            return this.data[index - 1];
        else
            return null;
    }
    /* @Method This returns true if stack is empty */
    public boolean isEmpty() {
        return index == 0 ? true : false;
    }
    /* @Method This method returns the stack size */
    public int getStackSize() {
        return index;
    }
    /* @Method This deletes the entire stack */
    public void deleteStack() {
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                this.data[i] = null;
            }
            index = 0;
        }
    }
    private void increaseSize() {
        Object[] temp = new Object[size];
        size = size * 2;
        for (int i = 0; i < index; i++) {
            temp[i] = this.data[i];
        }
        this.data = new Object[this.size];
        for (int i = 0; i < index; i++) {
            this.data[i] = temp[i];
        }
    }
}
