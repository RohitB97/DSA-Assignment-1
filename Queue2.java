import java.io.*;
import java.util.*;

public class Queue2<T> implements Queue<T>{
	ArrayStack<T> Stack1 = new ArrayStack<T>();
	ArrayStack<T> Stack2 = new ArrayStack<T>();

	public void enqueue (T element){
		this.Stack1.push(element);
	}

	public T dequeue() throws NoSuchElementException{
		if (this.Stack1.isEmpty() && this.Stack2.isEmpty()) throw new NoSuchElementException();
 		
 		if(this.Stack2.isEmpty()){
 			while(!this.Stack1.isEmpty()){
				this.Stack2.push(this.Stack1.pop());
			}
 		}
		
		return(this.Stack2.pop());
	}

	public T front() throws NoSuchElementException{
		if (this.Stack1.isEmpty() && this.Stack2.isEmpty()) throw new NoSuchElementException();

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