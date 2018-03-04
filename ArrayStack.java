import java.io.*;
import java.util.*;

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
        return (this.t + 1);  //Return the current stack size
    }

    public boolean isEmpty( ){ //Return true iff the stack is empty
        return (this.t < 0);
    }

    public void push(T obj){ //Push a new element on the stack
        this.S.add(obj);
        this.t++;
    }

    public T top() throws EmptyStackException {   // Return the top stack element
        if (isEmpty( ))
            throw new EmptyStackException();
        return this.S.get(this.t);
    }
    
    public T pop() throws EmptyStackException {    // Pop off the stack element
        if (isEmpty( ))
            throw new EmptyStackException();
        this.t--;
        return this.S.remove(t + 1);      // Dereference S[top] and decrement top
    }

}

