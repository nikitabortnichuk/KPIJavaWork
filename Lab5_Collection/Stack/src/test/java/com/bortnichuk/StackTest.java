package com.bortnichuk;

import com.bortnichuk.exception.EmptyStackException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class StackTest {
	private Stack<Integer> intStack = new LinkedStack<>();

	@Test
	public void testPushElementOntoEmptyStack() {
		intStack.push(234);

		boolean result = intStack.isEmpty();

		assertFalse(result);
	}

	@Test(expected = EmptyStackException.class)
	public void testPopElementFromEmptyStack() {
		intStack.pop();
	}

	@Test
	public void testPushElements() {
		intStack.push(23);
		intStack.push(35);
		intStack.push(72);

		intStack.push(55);

		assertThat(intStack.pop(), is(55));
	}

	@Test
	public void testPopElements() {
		intStack.push(87);
		intStack.push(53);
		intStack.push(66);

		intStack.pop();
		intStack.push(234);
		Integer lastElement = intStack.pop();

		assertThat(lastElement, is(234));
	}

	@Test
	public void testSize(){
		intStack.push(87);
		intStack.push(53);
		intStack.push(66);

		int actualSize = intStack.size();

		assertThat(actualSize, is(3));
	}

	@Test
	public void testSizeOnEmptyStack(){
		int actualSize = intStack.size();

		assertThat(actualSize, is(0));
	}

	@Test
	public void testIsEmpty(){
		intStack.push(87);
		intStack.push(53);
		intStack.push(66);

		boolean stackEmpty = intStack.isEmpty();

		assertThat(stackEmpty, is(false));
	}

	@Test
	public void testIsEmptyOnEmptyStack(){
		boolean stackEmpty = intStack.isEmpty();

		assertThat(stackEmpty, is(true));
	}
}
