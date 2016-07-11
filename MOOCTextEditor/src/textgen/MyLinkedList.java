package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	//private static final E value = null;
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		size = 0;
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null)
			return false;
		
		LLNode<E> prev = tail.prev;
		
		LLNode<E> temp =new LLNode<E>(element);
		prev.next = temp;
		temp.prev = prev;
		temp.next = tail;
		tail.prev = temp;
		size +=1;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0||index >= size)
			throw new IndexOutOfBoundsException("index out of bounds");
		
		LLNode<E> current = head;
		
		for (int i=0 ; i<= index; i ++)
		{
			current = current.next;
		}
		return current.data;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> temp =new LLNode<E>(element);
		
		if ((index <0 || index > size)&&(index!=0 || size !=0))//notice: index can be equal to size
			throw new IndexOutOfBoundsException("index out of bounds");
		if (element == null)
			throw new NullPointerException("Null elements added");
		LLNode<E> current = head;
		for (int i =0; i<= index ; i++){
			current = current.next;
		}
		LLNode<E> prev = current.prev;
		prev.next = temp;
		temp.prev = prev;
		temp.next = current;
		current.prev = temp;
		size +=1;	
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index <0 || index >= size)
			throw new IndexOutOfBoundsException("index out of bounds");
		if (size ==0)
			throw new NullPointerException("Empty list");
		LLNode<E> current = head;
		for (int i =0; i<= index; i++){
			current = current.next;
		}
		LLNode<E> prev = current.prev;
		LLNode<E> next = current.next;
		prev.next = next;
		next.prev = prev;		
		size -=1;
		E value = current.data;
		return value;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index <0 || index >= size)
			throw new IndexOutOfBoundsException("index out of bounds");
		if (element == null)
			throw new NullPointerException("Null elements added");
		LLNode<E> current= head;
		for (int i =0; i<= index; i++){
			current = current.next;
		}
		current.data = element;
		return element;
		
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	
	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	public LLNode(E e)  
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
}
