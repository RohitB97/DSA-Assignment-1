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
	
	public T front() throws EmptyQueueException;
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

	public T dequeue() throws EmptyQueueException;
}

public class Queue2<T> implements Queue<T>{
	ArrayStack Stack1 = new ArrayStack();
	ArrayStack Stack2 = new ArrayStack();

	public void enqueue (T element){
		this.Stack1.push(element);
	}

	public T dequeue() throws EmptyQueueException{
		if (this.Stack1.isEmpty() && this.Stack2.isEmpty()) throw new EmptyQueueException("Queue is empty");
 		
 		if(this.Stack2.isEmpty()){
 			while(!this.Stack1.isEmpty()){
				this.Stack2.push(this.Stack1.pop());
			}
 		}
		
		return(this.Stack2.pop());
	}

	public T front() throws EmptyQueueException{
		if (this.Stack1.isEmpty() && this.Stack2.isEmpty()) throw new EmptyQueueException("Queue is empty");

		if(this.Stack2.isEmpty()){
 			while(!this.Stack1.isEmpty()){
				this.Stack2.push(this.Stack1.pop());
			}
 		}

 		return (this.Stack2.top());
	}

	public int size(){
		return (this.Stack1.size() + this.Stack2.size());
	}

	public boolean isEmpty(){
		return (this.Stack1.isEmpty() && this.Stack2.isEmpty());
	}
}