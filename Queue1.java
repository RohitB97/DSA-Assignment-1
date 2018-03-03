import java.io.*;
import java.util.*;

interface Queue<T> {
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

public class Queue1<T> implements Queue<T>{
	ArrayStack<T> Stack1 = new ArrayStack<T>();
	ArrayStack<T> Stack2 = new ArrayStack<T>();

	public void enqueue (T element){
		this.Stack1.push(element);
	}

	public T dequeue() throws NoSuchElementException{
		if (this.Stack1.isEmpty()) throw new EmptyQueueException();
 		
 		while(!this.Stack1.isEmpty()){
			this.Stack2.push(this.Stack1.pop());
		}

		
		T pop = this.Stack2.pop();
		
		while(!this.Stack2.isEmpty()){
			this.Stack1.push(this.Stack2.pop());
		}
		
		return(pop);
	}

	public T front() throws NoSuchElementException{
		if (this.Stack1.isEmpty()) throw new NoSuchElementException();
 		
 		while(!this.Stack1.isEmpty()){
			this.Stack2.push(this.Stack1.pop());
		}

		T top = this.Stack2.top();
		
		while(!this.Stack2.isEmpty()){
			this.Stack1.push(this.Stack2.pop());
		}

		return (top);
	}

	public int size(){
		return this.Stack1.size();
	}

	public boolean isEmpty(){
		return this.Stack1.isEmpty();
	}

	public static void main(String[] args){
        Queue1<Integer> queue = new Queue1<Integer>();
        queue.enqueue(45);
        queue.enqueue(35);
        queue.enqueue(25);
        queue.enqueue(15);
        queue.enqueue(65);
        queue.enqueue(75);
        System.out.println(queue.size());
        System.out.println(queue.front());
    }
}