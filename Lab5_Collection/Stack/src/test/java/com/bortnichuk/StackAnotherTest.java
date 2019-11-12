package com.bortnichuk;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackAnotherTest {
    private Stack<Integer> intStack = new LinkedStack<>();

    @Test
    public void pushAndPop(){
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        assertEquals(3, intStack.pop().intValue());
        assertEquals(2, intStack.pop().intValue());
        assertEquals(1, intStack.pop().intValue());
    }


}
