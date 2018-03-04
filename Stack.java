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