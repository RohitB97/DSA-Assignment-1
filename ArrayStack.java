import java.io.*;
import java.util.*;

public interface Stack<T> {
    /**
    * Return the number of elements in the stack.
    */
    public int size();
    /**
    * Return whether the stack is empty.
    * return true if the stack is empty, false otherwise.
    */
    public boolean isEmpty();
    /**
    * Inspect the element at the top of the stack.
    * return top element in the stack.
    * exception EmptyStackException if the stack is empty.
    */
    public T top() throws EmptyStackException;
    /**
    * Insert an element at the top of the stack.
    * param element to be inserted.
    */
    public void push (T element);
    /**
    * Remove the top element from the stack.
    * return element removed.
    * exception EmptyStackException if the stack is empty.
    */
    public T pop() throws EmptyStackException;
}

public class ArrayStack<T> implements Stack<T> {
    public static final int CAPACITY = 100000; // default capacity of stack
    
    private ArrayList<T> S;    // S holds the elements of the stack
    
    private int t = -1; // the top element of the stack
    
    public ArrayStack( ) // Initialize the stack with default capacity
    { this(CAPACITY); }
    
    public ArrayStack(int cap)
    {
        this.S = new ArrayList<T>(cap);
    }

    public int size( ){
        return (this.t + 1)  //Return the current stack size
    }

    public boolean isEmpty( ){ //Return true iff the stack is empty
        return (this.t < 0)
    }

    public void push(T obj){ //Push a new element on the stack
        this.S[++this.t] = obj;
    }

    public T top() throws EmptyStackException {   // Return the top stack element
        if (isEmpty( ))
            throw new EmptyStackException("Stack is empty");
        return this.S[t]
    }
    
    public T pop() throws EmptyStackException {    // Pop off the stack element
        T elem;
        if (isEmpty( ))
            throw new EmptyStackException("Stack is Empty");
        elem = this.S[this.t];
        this.S[this.t--] = null;  // Dereference S[top] and decrement top
        return elem
    }

}

