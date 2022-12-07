package com.cracker.java.interview.designpatterns.behavioral.chainofresponsibility;

public class HandlerC extends Handler {
    
    @Override
    public void doHandler() {
        System.out.println("I am Handler C, I have finished processing, the process is over");
    }
}
