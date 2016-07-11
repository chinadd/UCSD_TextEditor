/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		//test List1
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		int b = list1.remove(1);
		assertEquals("Remove: check a is correct ", 42, b);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 1, list1.size());
		
		// TODO: Add more tests here
		
		//remove from empty list
		try{
			int c = emptyList.remove(0);
			fail("Remove: index out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
		}
		//remove negative index
		try{
			int d = list1.remove(-1);
			fail("Remove: index out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
		}	
			
		//test remove longerList, first out of bounds, then contents one by one
		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.remove(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.remove(0));
		}
		
		//test shortList
		String s =shortList.remove(0);
		assertEquals("Remove: check s is correct ", "A", s);
		assertEquals("Remove: check element is correct", "B", shortList.get(0));
		assertEquals("Remove: check length is correct", 1, shortList.size());
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		
		//add string to short String list
		try {
			shortList.add("C");
			assertEquals("Add: check valude added","C",shortList.get(2));
			assertEquals("Add: check size is correct",3, shortList.size());
		}
		catch(IndexOutOfBoundsException e){
			fail("error in adding string to string list");
		}
		//add integer to emptyList, then test content
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			emptyList.add(i);
		}
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, emptyList.get(i));
		}
		//add integer to longerList
		try {
			longerList.add(12345);
			assertEquals("Add: check valude added",(Integer)12345,longerList.get(10));
			assertEquals("Add: check size is correct",11, longerList.size());
		}
		catch(IndexOutOfBoundsException e){
			fail("error in adding string to string list");
		}
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		try{
			assertEquals("Test longerList size",10,longerList.size());			
		}
		catch(IndexOutOfBoundsException e){
			fail("error in longerList size");
		}		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		//test add at index out of bound
		try{
			list1.add(-1,33);
			fail("Error in AddAtIndex: index out of bounds");
		}
		catch(IndexOutOfBoundsException e){
			
		}
		try{
			list1.add(4,33);
			fail("Error in AddAtIndex: index out of bounds");
		}
		catch(IndexOutOfBoundsException e){
			
		}
		
		//test add null element 
		try{
			list1.add(0,null);
			fail("Error in Add at index: null element added");
		}
		catch(NullPointerException e){
			
		}
		
		//test add into empty list
		emptyList.add(0,19);
		assertEquals("Remove: check added is correct ", (Integer)19, emptyList.get(0));
		assertEquals("Remove: check size is correct ", 1, emptyList.size());
		
		//test add element into longerList
		try {
			longerList.add(5,11);
			int temp = longerList.get(5);
			assertEquals("Test add within longer list",temp,11);
		}catch(IndexOutOfBoundsException e){
			fail("error in add within longerList");
		}
	
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		//set emptyList
		try{
			emptyList.set(0, 1);
			fail("Set: index out of bounds");
		}
		catch(IndexOutOfBoundsException e){
		}
		//set negative index
		try{
			emptyList.set(-1, 31);
			fail("Set: index out of bounds");
		}
		catch(IndexOutOfBoundsException e){
		}
		//test set null element 
		try{
			list1.set(0,null);
			fail("Error in set at index: null element added");
		}
		catch(NullPointerException e){
					
		}
		//set first element of String list
	    try {
	    	shortList.set(0, "X");
	    	assertEquals("Add: check valude changed","X",shortList.get(0));
			assertEquals("Add: check size is correct",2, shortList.size());
	    }
	    catch(IndexOutOfBoundsException e){
			fail("error in setting string list elements");
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
