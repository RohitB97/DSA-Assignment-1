import java.io.*;
import java.util.*;

public class myQueue1<T> implements Queue<T>{
	ArrayStack<T> Stack1 = new ArrayStack<T>();
	ArrayStack<T> Stack2 = new ArrayStack<T>();

	public void enqueue (T element){
		this.Stack1.push(element);
	}

	public T dequeue() throws NoSuchElementException{
		if (this.Stack1.isEmpty()) throw new NoSuchElementException();
 		
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
	
}