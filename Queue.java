import java.io.*;
import java.util.*;

public interface Queue<T> {
	/**
	* Returns the number of elements in the queue.
 	* return number of elements in the queue.
	*/
 	
 	public int size();
 	/**
	* Returns whether the queue is empty.
	* return true if the queue is empty, false otherwise.
	*/
	
	public boolean isEmpty();
	/**
	* Inspects the element at the front of the queue.
	* return element at the front of the queue.
	* exception EmptyQueueException if the queue is empty.
	*/
	
	public T front() throws NoSuchElementException;
	/**
	*Inserts an element at the rear of the queue.
	* param element new element to be inserted.
	*/
	
	public void enqueue (T element);
 	/**
	* Removes the element at the front of the queue
	* return element removed.
	* exception EmptyQueueException if the queue is empty.
	*/

	public T dequeue() throws NoSuchElementException;
}