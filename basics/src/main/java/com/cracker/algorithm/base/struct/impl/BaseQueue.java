package com.cracker.algorithm.base.struct.impl;

import com.cracker.algorithm.base.struct.Queue;

public class BaseQueue<I> extends Queue<I> {
    
    public BaseQueue() {
        super();
    }
    
    @Override
    public void enqueue(final I item) {
        linkLast(item);
    }
    
    @Override
    public I dequeue() {
        return removeFirst();
    }
    
    @Override
    public I peek() {
        return getFirstItem();
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (isEmpty()) {
            return "";
        }
        this.stream().forEach(each -> str.append(each).append(", "));
        return str.substring(0, str.length() - 2);
    }
}
