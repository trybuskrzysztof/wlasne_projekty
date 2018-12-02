import org.junit.Test;
import static org.junit.Assert.*;

public class StackTests {

	@Test
	public void givenNewStack_WhenCHeckedForEmptiness_ThenTrueIsReturned() {
		Stack s = new Stack();
		
		assertTrue(s.isEmpty());
	}
	
	@Test
	public void givenNotEmptyStack_WhenCheckingForEmptiness_ThenFalseIsReturned() {
		Stack s = new Stack();
		s.push(42);
		
		assertFalse(s.isEmpty());
	}
	
	@Test(expected=EmptyStackException.class)
	public void givenEmptyStack_WhenPopping_ThenExceptionIsThrown() throws EmptyStackException {
		Stack s = new Stack();
		
		s.pop();
	}
	
	@Test
	public void givenNotEmptyStack_WhenPoping_ThenValueIsReturned() throws EmptyStackException {
		Stack s = new Stack();
		s.push(42);
		
		assertEquals(42, s.pop());
	}
	
	@Test
	public void givenStack_WhenPoping_ThenLastAddedValueIsReturned() throws EmptyStackException {
		Stack s = new Stack();
		s.push(42);
		s.push(15);
		
		assertEquals(15, s.pop());
	}
	
	@Test
	public void givenNotEmptyStack_WhenPopping_ThenStackBecomesEmpty() throws EmptyStackException {
		Stack s = new Stack();
		s.push(42);
		
		s.pop();
		
		assertTrue(s.isEmpty());
	}
	
	@Test
	public void givenStackWithTwoElements_WhenPoppingSingleItem_ThenStackIsStillNotEmpty() throws EmptyStackException {
		Stack s = new Stack();
		s.push(15);
		s.push(42);
		
		s.pop();
		
		assertFalse(s.isEmpty());
	}
	
	@Test
	public void givenStackWithTwoElements_WhenPoppingSecondtem_ThenFirstAddedValueIsReturned() throws EmptyStackException {
		Stack s = new Stack();
		s.push(15);
		s.push(42);
		
		s.pop();
		
		assertEquals(15, s.pop());
	}
	
	@Test
	public void givenEmptyStack_WhenGettingSize_EqualsZero(){
	Stack s = new Stack();
	assertEquals(0,s.getSize());
	}

	@Test
	public void givenTwoElementStack_WhenGettingSize_EqualsTwo(){
	Stack s = new Stack();
	s.push(15);
	s.push(42);
	assertEquals(2,s.getSize());
	}

	@Test(expected=EmptyStackException.class)
	public void clearEmptyStack_ThenExceptionIsThrown() throws EmptyStackException {
	Stack s = new Stack();
	s.clear();
	}
	
	@Test
	public void afterClearStackIsEmpty() throws EmptyStackException {
	Stack s = new Stack();
	s.push(15);
	s.push(42);
	s.clear();
	assertTrue(s.isEmpty());
	}
}
